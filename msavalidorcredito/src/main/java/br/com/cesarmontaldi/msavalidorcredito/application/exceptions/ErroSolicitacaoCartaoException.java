package br.com.cesarmontaldi.msavalidorcredito.application.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException {
    public ErroSolicitacaoCartaoException(String message) {
        super(message);
    }
}
