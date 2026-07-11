package com.ecommerce.project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um pedido fechado por um {@link Cliente}.
 * Implementa a interface {@link Pagavel} e gerencia o ciclo de vida
 * do pedido, desde a criação até o processamento do pagamento.
 * Cada pedido possui uma lista de itens, status e valor total.
 */
@Entity
public class Pedido implements Pagavel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    private BigDecimal totalPagamento;

    public Pedido() {
    }

    /**
     * @param dataPedido     data e hora em que o pedido foi realizado
     * @param status         status atual do pedido
     * @param cliente        cliente que fez o pedido
     * @param itens          itens do pedido
     * @param totalPagamento valor total a ser pago
     */
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

    /**
     * Finaliza o pedido definindo a data atual, alterando o status
     * para AGUARDANDO_PAGAMENTO e calculando o total com base nos itens.
     */
    public void fecharPedido(){
        this.dataPedido = LocalDateTime.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.totalPagamento = this.calcularTotal();
    }

    /**
     * Calcula o valor total do pedido somando os subtotais de todos os itens.
     *
     * @return total do pedido
     */
    @Override
    public BigDecimal calcularTotal(){
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Processa o pagamento do pedido, alterando o status para PAGO.
     */
    @Override
    public void processarPagamento(){
        this.status = StatusPedido.PAGO;
    }
}
