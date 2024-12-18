package br.com.cesarmontaldi.msavalidorcredito.application;

import br.com.cesarmontaldi.msavalidorcredito.domain.DadosCliente;
import br.com.cesarmontaldi.msavalidorcredito.domain.SituacaoCliente;
import br.com.cesarmontaldi.msavalidorcredito.infra.clients.ClienteResourceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AvaliadorCreditoService {

    @Autowired
    private ClienteResourceClient clienteClient;


    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosCliente = clienteClient.dadosCliente(cpf);

        return new SituacaoCliente(dadosCliente.getBody(), null);
    }
}
