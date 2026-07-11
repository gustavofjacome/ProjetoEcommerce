package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/**
 * Representa um administrador do sistema, que é um tipo de {@link Usuario}.
 * Possui um código de crachá e um nível de acesso que define suas
 * permissões dentro da plataforma.
 */
@Entity
public class Administrador extends Usuario {

    private String codigoCracha;
    @Enumerated(EnumType.STRING)
    private NivelAcesso nivelAcesso;

    public Administrador() {
    }

    /**
     * @param nome        nome completo do administrador
     * @param email       e-mail para login
     * @param senha       senha de acesso
     * @param codigoCracha código identificador do crachá
     * @param nivelAcesso nível de permissão do administrador
     */
    public Administrador(String nome, String email, String senha, String codigoCracha, NivelAcesso nivelAcesso) {
        super(nome, email, senha);
        this.codigoCracha = codigoCracha;
        this.nivelAcesso = nivelAcesso;
    }

    public String getCodigoCracha() {
        return codigoCracha;
    }

    public void setCodigoCracha(String codigoCracha) {
        this.codigoCracha = codigoCracha;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
