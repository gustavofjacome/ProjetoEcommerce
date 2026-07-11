package com.ecommerce.project.exception;

/**
 * Lancada quando uma operacao exige um cliente e nenhum foi informado ou encontrado.
 */
public class ClienteNaoInformadoException extends RuntimeException {
    public ClienteNaoInformadoException(String message) {
        super(message);
    }
}
