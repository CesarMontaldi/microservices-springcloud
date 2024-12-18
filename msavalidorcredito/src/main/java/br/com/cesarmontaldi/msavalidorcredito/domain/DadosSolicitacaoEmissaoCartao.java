package br.com.cesarmontaldi.msavalidorcredito.domain;

import java.math.BigDecimal;

public class DadosSolicitacaoEmissaoCartao {

    private Long idCartao;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;

    public DadosSolicitacaoEmissaoCartao() {

    }


    public Long getIdCartao() {
        return idCartao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }
}
