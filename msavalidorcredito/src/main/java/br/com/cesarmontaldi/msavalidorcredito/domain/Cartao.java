package br.com.cesarmontaldi.msavalidorcredito.domain;

import java.math.BigDecimal;

public class Cartao {

    private Long id;
    private String nome;
    private String bandeira;
    private BigDecimal limiteBasico;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public BigDecimal getLimiteBasico() {
        return limiteBasico;
    }
}
