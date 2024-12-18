package br.com.cesarmontaldi.msavalidorcredito.domain;

import java.math.BigDecimal;

public class CartaoCliente {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;


    public String getNome() {
        return nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }
}
