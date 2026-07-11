package com.ecommerce.project.model;

import com.ecommerce.project.exception.EstoqueInsuficienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;


/**
 * Representa um produto disponível para venda no e-commerce.
 * Cada produto possui nome, descrição, preço, quantidade em estoque
 * e uma categoria para organização.
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private String categoria;

    public Produto() {
    }

    /**
     * @param nome             nome do produto
     * @param descricao        descrição detalhada do produto
     * @param preco            preço unitário
     * @param quantidadeEstoque quantidade disponível em estoque
     * @param categoria        categoria do produto (ex: eletrônicos, roupas)
     */
    public Produto(String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque, String categoria) {
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

    /**
     * Verifica se há estoque suficiente para atender uma determinada quantidade.
     *
     * @param qtd quantidade desejada
     * @return {@code true} se o estoque atual for maior ou igual à quantidade
     */
    public boolean temEstoque(Integer qtd){
        return quantidadeEstoque >= qtd;
    }

    /**
     * Reduz a quantidade em estoque após uma venda.
     * Caso o estoque seja insuficiente, lança uma exceção.
     *
     * @param qtd quantidade a ser reduzida do estoque
     * @throws EstoqueInsuficienteException se não houver estoque suficiente
     */
    public void reduzirEstoque(Integer qtd){
        if (temEstoque(qtd)){
            quantidadeEstoque -= qtd;
        } else{
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto: " + this.nome);
        }


    }


}
