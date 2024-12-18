package br.com.cesarmontaldi.msavalidorcredito.application;

import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.DadosClienteNotFoundException;
import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.ErroComunicacaoMicroservicesException;
import br.com.cesarmontaldi.msavalidorcredito.application.exceptions.ErroSolicitacaoCartaoException;
import br.com.cesarmontaldi.msavalidorcredito.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoController {

    @Autowired
    private AvaliadorCreditoService avaliadorCreditoservice;

    @GetMapping
    public String status() {
        return "OK";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam String cpf) {
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoservice.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        }
        catch (DadosClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dados) {
        try {
            RetornoAvaliacaoCliente realizarAvaliacao = avaliadorCreditoservice.realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(realizarAvaliacao);
        }
        catch (DadosClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

}
