package br.com.cesarmontaldi.msavalidorcredito.application;

import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.ErroSolicitacaoCartaoException;
import br.com.cesarmontaldi.msavalidorcredito.domain.DadosSolicitacaoEmissaoCartao;
import br.com.cesarmontaldi.msavalidorcredito.domain.ProtocoloSolicitacaoCartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("solicitacoes-cartao")
public class SolicitacaoCartaoController {

    @Autowired
    private SolicitacaoCartaoService solicitacaoCartaoService;

    @PostMapping()
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {
        try {
            ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao = solicitacaoCartaoService
                    .solicitarEmissaoCartao(dados);
            return ResponseEntity.ok(protocoloSolicitacaoCartao);
        }
        catch (ErroSolicitacaoCartaoException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
