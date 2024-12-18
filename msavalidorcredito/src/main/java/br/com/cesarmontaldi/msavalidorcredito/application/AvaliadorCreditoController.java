package br.com.cesarmontaldi.msavalidorcredito.application;

import br.com.cesarmontaldi.msavalidorcredito.domain.SituacaoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@RequestParam String cpf) {
        SituacaoCliente situacaoCliente = avaliadorCreditoservice.obterSituacaoCliente(cpf);
    }
}
