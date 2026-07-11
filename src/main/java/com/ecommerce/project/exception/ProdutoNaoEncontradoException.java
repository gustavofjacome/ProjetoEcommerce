package com.ecommerce.project.exception;

/**
 * Lancada quando um produto com o ID informado nao existe no banco.
 */
public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
