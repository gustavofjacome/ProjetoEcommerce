package com.ecommerce.project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa o carrinho de compras de um cliente.
 * Armazena temporariamente os itens selecionados antes da finalização
 * do pedido. Cada cliente possui um único carrinho ativo.
 */
@Entity
public class CarrinhoDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    public CarrinhoDeCompras() {
    }

    /**
     * @param itens lista inicial de itens do carrinho
     */
    public CarrinhoDeCompras(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    /**
     * Adiciona um produto ao carrinho com a quantidade especificada.
     * Cria automaticamente um {@link ItemPedido} com o preço atual do produto.
     *
     * @param produto produto a ser adicionado
     * @param qtd     quantidade do produto
     */
    public void adicionarItem(Produto produto, Integer qtd) {
        itens.add(new ItemPedido(produto, qtd, produto.getPreco()));
    }

    /**
     * Remove todas as ocorrências de um produto do carrinho.
     *
     * @param produto produto a ser removido
     */
    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    /**
     * Calcula o valor total de todos os itens do carrinho.
     *
     * @return soma dos subtotais de cada item
     */
    public BigDecimal calcularTotal(){
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Remove todos os itens do carrinho, deixando-o vazio.
     */
    public void esvaziar(){
        itens.clear();
    }
}
