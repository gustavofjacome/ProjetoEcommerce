package com.ecommerce.project.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private Long id;
    private List<ItemPedido> itens = new ArrayList<>();

    public CarrinhoDeCompras() {
    }

    public CarrinhoDeCompras(Long id, List<ItemPedido> itens) {
        this.id = id;
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

    public void adicionarItem(Produto produto, Integer qtd) {
        itens.add(new ItemPedido(produto, qtd, produto.getPreco()));
    }

    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto().equals(produto));
    }

    public BigDecimal calcularTotal(){
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void esvaziar(){
        itens.clear();
    }
}
