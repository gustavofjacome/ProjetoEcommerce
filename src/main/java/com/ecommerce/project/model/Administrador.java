package com.ecommerce.project.model;

public class Administrador extends Usuario {

    private String codigoCracha;
    private NivelAcesso nivelAcesso;

    public Administrador(String codigoCracha, NivelAcesso nivelAcesso) {
        this.codigoCracha = codigoCracha;
        this.nivelAcesso = nivelAcesso;
    }

    public Administrador(long id, String nome, String email, String senha, String codigoCracha, NivelAcesso nivelAcesso) {
        super(id, nome, email, senha);
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