package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends Usuario{
    private String cpf;
    private String telefone;

    @OneToOne
    private CarrinhoDeCompras carrinho;

    public Cliente() {
    }

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

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
    }


}
