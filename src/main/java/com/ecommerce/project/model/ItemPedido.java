package com.ecommerce.project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Representa um item individual dentro de um pedido ou carrinho.
 * Associa um {@link Produto} a uma quantidade e um preço unitário
 * no momento da compra, garantindo o valor mesmo que o produto
 * mude de preço depois.
 */
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido() {
    }

    /**
     * @param produto      produto comprado
     * @param quantidade   quantidade comprada
     * @param precoUnitario preço unitário no momento da compra
     */
    public ItemPedido(Produto produto, Integer quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    /**
     * Calcula o subtotal do item (quantidade * preço unitário).
     *
     * @return valor total deste item
     */
    public BigDecimal calcularSubtotal(){
        return this.precoUnitario.multiply(new BigDecimal(this.quantidade));
    }
}
