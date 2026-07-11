package com.ecommerce.project.model;

import java.math.BigDecimal;

/**
 * Interface que define o contrato para entidades que podem ser pagas.
 * Qualquer classe que represente algo com valor monetário e que
 * precise processar um pagamento deve implementá-la, como é o
 * caso de {@link Pedido}.
 */
public interface Pagavel {
    /**
     * Calcula o valor total a ser pago.
     *
     * @return valor total
     */
    BigDecimal calcularTotal();

    /**
     * Processa o pagamento, alterando o estado interno da entidade.
     */
    void processarPagamento();
}
