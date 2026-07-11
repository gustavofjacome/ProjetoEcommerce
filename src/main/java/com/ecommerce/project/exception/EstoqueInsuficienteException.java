package com.ecommerce.project.exception;

/**
 * Lancada quando uma compra tenta reduzir o estoque de um produto
 * alem da quantidade disponivel.
 */
public class EstoqueInsuficienteException extends RuntimeException {
    public EstoqueInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
