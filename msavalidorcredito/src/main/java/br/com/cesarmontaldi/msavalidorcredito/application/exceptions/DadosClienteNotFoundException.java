package br.com.cesarmontaldi.msavalidorcredito.application.exceptions;

public class DadosClienteNotFoundException extends Exception {

    private Integer status;

    public DadosClienteNotFoundException(Integer status) {
        super("Dados do cliente não encontrados para o CPF informado.");
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
