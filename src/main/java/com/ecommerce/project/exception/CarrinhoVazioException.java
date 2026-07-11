package com.ecommerce.project.exception;

/**
 * Lancada quando se tenta finalizar um pedido com o carrinho vazio.
 */
public class CarrinhoVazioException extends RuntimeException {
    public CarrinhoVazioException(String message) {
        super(message);
    }
}
