package com.ecommerce.project.model;

import java.math.BigDecimal;

public interface Pagavel {
    BigDecimal calcularTotal();
    void processarPagamento();
}
