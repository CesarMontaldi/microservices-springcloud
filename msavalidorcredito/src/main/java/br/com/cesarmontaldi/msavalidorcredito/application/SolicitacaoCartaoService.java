package br.com.cesarmontaldi.msavalidorcredito.application;

import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.ErroSolicitacaoCartaoException;
import br.com.cesarmontaldi.msavalidorcredito.domain.DadosSolicitacaoEmissaoCartao;
import br.com.cesarmontaldi.msavalidorcredito.domain.ProtocoloSolicitacaoCartao;
import br.com.cesarmontaldi.msavalidorcredito.infra.mqueue.SolicitacaoEmissaoCartaoPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SolicitacaoCartaoService {

    @Autowired
    private SolicitacaoEmissaoCartaoPublisher emissaoCartaoPublisher;


    public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados) {
        try {
            emissaoCartaoPublisher.solicitacaoCartao(dados);
            var protocolo = UUID.randomUUID().toString();
            return new ProtocoloSolicitacaoCartao(protocolo);
        }
        catch (Exception e) {
            throw new ErroSolicitacaoCartaoException(e.getMessage());
        }
    }
}
