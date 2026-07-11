package com.ecommerce.project.model;

/**
 * Enum que define os níveis de acesso disponíveis para
 * um {@link Administrador} no sistema.
 */
public enum NivelAcesso {
    /** Acesso total a todas as funcionalidades do sistema. */
    ADMIN_TOTAL,
    /** Acesso a funcionalidades gerenciais. */
    GERENTE,
    /** Acesso restrito ao suporte ao cliente. */
    SUPORTE_CLIENTE
}
