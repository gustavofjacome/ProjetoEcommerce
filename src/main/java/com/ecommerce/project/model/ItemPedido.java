package com.ecommerce.project.model;

import java.math.BigDecimal;

public class ItemPedido {
    private Produto produto;
    private Integer quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto, Integer quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    //todo: implementar a função que falta
}
