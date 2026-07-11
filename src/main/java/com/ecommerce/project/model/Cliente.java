package com.ecommerce.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

/**
 * Representa um cliente do e-commerce, que é um tipo de {@link Usuario}.
 * Cada cliente possui CPF, telefone, um endereço embutido e um carrinho
 * de compras próprio.
 */
@Entity
public class Cliente extends Usuario{
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private CarrinhoDeCompras carrinho;

    public Cliente() {
    }

    /**
     * @param nome     nome completo do cliente
     * @param email    e-mail para login
     * @param senha    senha de acesso
     * @param cpf      CPF do cliente (sem pontuação)
     * @param telefone telefone para contato
     * @param carrinho carrinho de compras associado
     */
    public Cliente(String nome, String email, String senha, String cpf, String telefone, CarrinhoDeCompras carrinho) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.carrinho = carrinho;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
    }


}
