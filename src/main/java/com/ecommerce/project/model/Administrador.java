package com.ecommerce.project.model;

import jakarta.persistence.Entity;


@Entity
public class Administrador extends Usuario {

    private String codigoCracha;
    private NivelAcesso nivelAcesso;

    public Administrador() {
    }

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