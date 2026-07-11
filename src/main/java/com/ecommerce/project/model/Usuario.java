package com.ecommerce.project.model;

import jakarta.persistence.*;

/**
 * Classe abstrata que representa um usuário genérico do sistema.
 * Serve como base para as hierarquias de {@link Cliente} e {@link Administrador}.
 * Utiliza herança com estratégia JOINED para manter tabelas separadas
 * mas relacionadas no banco.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    /**
     * @param nome  nome completo do usuário
     * @param email e-mail para login
     * @param senha senha de acesso
     */
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Tenta autenticar o usuário comparando e-mail e senha fornecidos
     * com os dados armazenados.
     *
     * @param email e-mail informado no login
     * @param senha senha informada no login
     * @return {@code true} se as credenciais coincidirem, {@code false} caso contrário
     */
    public boolean fazerLogin(String email, String senha){
        return (this.email.equals(email) && this.senha.equals(senha));
    }
}
