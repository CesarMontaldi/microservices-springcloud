package br.com.cesarmontaldi.msavalidorcredito.domain;

import java.util.List;

public class RetornoAvaliacaoCliente {

    private List<CartaoAprovado> cartoes;

    public RetornoAvaliacaoCliente() {

    }

    public RetornoAvaliacaoCliente(List<CartaoAprovado> cartoes) {
        this.cartoes = cartoes;
    }

    public List<CartaoAprovado> getCartoes() {
        return cartoes;
    }
}
