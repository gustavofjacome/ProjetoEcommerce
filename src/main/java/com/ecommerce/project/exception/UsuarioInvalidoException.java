package com.ecommerce.project.exception;

/**
 * Lancada quando as credenciais de login estao incorretas
 * ou o usuario nao foi encontrado.
 */
public class UsuarioInvalidoException extends RuntimeException {
    public UsuarioInvalidoException(String message) {
        super(message);
    }
}
