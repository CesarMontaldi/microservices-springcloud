package br.com.cesarmontaldi.msavalidorcredito.application.exceptions;

import feign.Request;
import feign.RetryableException;

public class ErroComunicacaoMicroservicesException extends Exception {

    private Integer status;


    public ErroComunicacaoMicroservicesException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
