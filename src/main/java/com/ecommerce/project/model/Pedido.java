package com.ecommerce.project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido implements Pagavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;
    private StatusPedido status;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<ItemPedido> itens = new ArrayList<>();

    private BigDecimal totalPagamento;

    public Pedido() {
    }

    public Pedido(LocalDateTime dataPedido, StatusPedido status, Cliente cliente, List<ItemPedido> itens, BigDecimal totalPagamento) {
        this.dataPedido = dataPedido;
        this.status = status;
        this.cliente = cliente;
        this.itens = itens;
        this.totalPagamento = totalPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotalPagamento() {
        return totalPagamento;
    }

    public void setTotalPagamento(BigDecimal totalPagamento) {
        this.totalPagamento = totalPagamento;
    }

    public void fecharPedido(){
        this.dataPedido = LocalDateTime.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.totalPagamento = this.calcularTotal();
    }

    @Override
    public BigDecimal calcularTotal(){
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    @Override
    public void processarPagamento(){
        this.status = StatusPedido.PAGO;
    }
}
