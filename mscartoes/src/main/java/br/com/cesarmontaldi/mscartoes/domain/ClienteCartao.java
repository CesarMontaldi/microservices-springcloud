package br.com.cesarmontaldi.mscartoes.domain;

import java.math.BigDecimal;

public class ClienteCartao {

    private Long id;
    private String cpf;
    private Cartao cartao;
    private BigDecimal limite;

    public ClienteCartao(String cpf, Cartao cartao, BigDecimal limite) {
        this.cpf = cpf;
        this.cartao = cartao;
        this.limite = limite;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public BigDecimal getLimite() {
        return limite;
    }
}
