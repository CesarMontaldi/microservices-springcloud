package br.com.cesarmontaldi.msavalidorcredito.domain;

import java.util.List;

public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartoes;


    public DadosCliente getCliente() {
        return cliente;
    }

    public List<CartaoCliente> getCartoes() {
        return cartoes;
    }
}
