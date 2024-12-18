package br.com.cesarmontaldi.msavalidorcredito.application;

import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.DadosClienteNotFoundException;
import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.ErroComunicacaoMicroservicesException;
import br.com.cesarmontaldi.msavalidorcredito.domain.*;
import br.com.cesarmontaldi.msavalidorcredito.infra.clients.CartoesResourseClient;
import br.com.cesarmontaldi.msavalidorcredito.infra.clients.ClienteResourceClient;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliadorCreditoService {

    @Autowired
    private ClienteResourceClient clienteClient;

    @Autowired
    private CartoesResourseClient cartoesClient;


    public SituacaoCliente obterSituacaoCliente(String cpf)
            throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {

        try {
            ResponseEntity<DadosCliente> dadosCliente = clienteClient.dadosCliente(cpf);
            ResponseEntity<List<CartaoCliente>> cartoesCliente = cartoesClient.getCartoesByCliente(cpf);

            return new SituacaoCliente(dadosCliente.getBody(), cartoesCliente.getBody());
        } catch (FeignException.FeignClientException | FeignException.ServiceUnavailable e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException(status);
            }
            throw new ErroComunicacaoMicroservicesException(e.contentUTF8(), status);
        }
    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, Long renda)
            throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException{

        try {
            ResponseEntity<DadosCliente> dadosCliente = clienteClient.dadosCliente(cpf);
            ResponseEntity<List<Cartao>> cartoesLiberado = cartoesClient.getCartoesRendaAte(renda);

            List<Cartao> cartoes = cartoesLiberado.getBody();

            List<CartaoAprovado> listaCartoesAprovados = cartoes
                    .stream()
                    .map(cartao -> {
                DadosCliente cliente = dadosCliente.getBody();

                BigDecimal limiteBasico = cartao.getLimiteBasico();
                BigDecimal idade = BigDecimal.valueOf(cliente.getIdade());
                var fator = idade.divide(BigDecimal.valueOf(10));
                BigDecimal limiteAprovado = fator.multiply(limiteBasico);

                CartaoAprovado cartaoAprovado = new CartaoAprovado();
                cartaoAprovado.setCartao(cartao.getNome());
                cartaoAprovado.setBandeira(cartao.getBandeira());
                cartaoAprovado.setLimiteAprovado(limiteAprovado);

                return cartaoAprovado;
            }).toList();

            return new RetornoAvaliacaoCliente(listaCartoesAprovados);

        } catch (FeignException.FeignClientException | FeignException.ServiceUnavailable e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException(status);
            }
            throw new ErroComunicacaoMicroservicesException(e.contentUTF8(), status);
        }
    }
}
