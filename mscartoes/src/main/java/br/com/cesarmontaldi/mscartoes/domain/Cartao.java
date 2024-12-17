package br.com.cesarmontaldi.mscartoes.domain;

import java.math.BigDecimal;

public class Cartao {

    private Long id;
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }
}
