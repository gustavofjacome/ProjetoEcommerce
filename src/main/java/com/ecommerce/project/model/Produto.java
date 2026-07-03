package com.ecommerce.project.model;

import com.ecommerce.project.exception.EstoqueInsuficienteException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private String categoria;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        // se pá nem precisa disso, criei por costume.todo: Revisar no final
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean temEstoque(Integer qtd){
        return quantidadeEstoque >= qtd;
    }

    public void reduzirEstoque(Integer qtd){
        if (temEstoque(qtd)){
            quantidadeEstoque -= qtd;
        } else{
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto: " + this.nome);
        }


    }


}
