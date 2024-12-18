package br.com.cesarmontaldi.mscartoes.application.representation;

import br.com.cesarmontaldi.mscartoes.infra.ClienteCartao;

import java.math.BigDecimal;

public record DadosCartaoPorCliente(String nome, String bandeira, BigDecimal limiteLiberado) {

    public DadosCartaoPorCliente(ClienteCartao clienteCartao) {
        this(
                clienteCartao.getCartao().getNome(),
                clienteCartao.getCartao().getBandeira().toString(),
                clienteCartao.getLimite()
        );
    }
}
