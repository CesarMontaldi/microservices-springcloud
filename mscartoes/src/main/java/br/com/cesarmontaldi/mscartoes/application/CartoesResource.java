package br.com.cesarmontaldi.mscartoes.application;

import br.com.cesarmontaldi.mscartoes.infra.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {

    @Autowired
    private CartaoService service;

    @GetMapping
    public String status() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroCartao dadosCartao) {
        Cartao cartao = service.save(dadosCartao);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cartao.getId())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<DadosCartao>> getCartoesRendaAte(@RequestParam Long renda) {
        List<DadosCartao> cartoes = service.getCartoesRendaMenorIgual(renda);

        return ResponseEntity.ok(cartoes);
    }
}
