package br.com.cesarmontaldi.mscartoes.application.representation;

import br.com.cesarmontaldi.mscartoes.domain.BandeiraCartao;

import java.math.BigDecimal;

public record DadosCadastroCartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
}
