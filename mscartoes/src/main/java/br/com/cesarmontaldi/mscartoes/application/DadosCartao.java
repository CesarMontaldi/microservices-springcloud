package br.com.cesarmontaldi.mscartoes.application;

import br.com.cesarmontaldi.mscartoes.domain.BandeiraCartao;
import br.com.cesarmontaldi.mscartoes.infra.Cartao;

import java.math.BigDecimal;

public record DadosCartao(Long id, String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {

    public DadosCartao(Cartao cartao) {
        this(cartao.getId(), cartao.getNome(), cartao.getBandeira(), cartao.getRenda(), cartao.getLimiteBasico());
    }
}
