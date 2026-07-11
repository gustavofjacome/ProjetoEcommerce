package com.ecommerce.project.model;

/**
 * Enum que representa as possíveis etapas do ciclo de vida
 * de um {@link Pedido}, desde a criação até a entrega ou cancelamento.
 */
public enum StatusPedido {
    /** Pedido criado aguardando confirmação do pagamento. */
    AGUARDANDO_PAGAMENTO,
    /** Pagamento confirmado. */
    PAGO,
    /** Pedido sendo separado no estoque. */
    EM_SEPARACAO,
    /** Pedido despachado para o transporte. */
    ENVIADO,
    /** Pedido entregue ao cliente. */
    ENTREGUE,
    /** Pedido cancelado antes ou durante o processamento. */
    CANCELADO
}
