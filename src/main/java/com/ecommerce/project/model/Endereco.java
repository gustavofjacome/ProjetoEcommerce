package com.ecommerce.project.model;

import jakarta.persistence.Embeddable;

/**
 * Representa um endereço de entrega ou residencial.
 * É uma classe embutível ({@link Embeddable}) utilizada dentro
 * de {@link Cliente} para evitar uma tabela separada no banco.
 */
@Embeddable
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    public Endereco() {
    }

    /**
     * @param rua    nome da rua
     * @param numero número do imóvel
     * @param bairro bairro
     * @param cep    Código de Endereçamento Postal
     */
    public Endereco(String rua, String numero, String bairro, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
