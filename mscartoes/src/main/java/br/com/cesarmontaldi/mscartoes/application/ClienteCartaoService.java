package br.com.cesarmontaldi.mscartoes.application;

import br.com.cesarmontaldi.mscartoes.application.representation.DadosCartaoPorCliente;
import br.com.cesarmontaldi.mscartoes.infra.ClienteCartao;
import br.com.cesarmontaldi.mscartoes.infra.ClienteCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCartaoService {

    @Autowired
    private ClienteCartaoRepository repository;


    public List<DadosCartaoPorCliente> listarCartoesByCpf(String cpf) {
        List<ClienteCartao> cartaoList = repository.findByCpf(cpf);

        return cartaoList.stream()
                .map(DadosCartaoPorCliente::new)
                .toList();
    }
}
