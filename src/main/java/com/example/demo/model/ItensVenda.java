package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ITENS_VENDA")
public class ItensVenda implements Serializable {
    @EmbeddedId
    private ItensVendaPk pk;

    public ItensVenda () {
    }

    public ItensVendaPk getPk () {
        return pk;
    }

    public void setPk ( ItensVendaPk pk ) {
        this.pk = pk;
    }

    public Integer getQuantidade () {
        return quantidade;
    }

    public void setQuantidade ( Integer quantidade ) {
        this.quantidade = quantidade;
    }

    public Double getValor () {
        return valor;
    }

    public void setValor ( Double valor ) {
        this.valor = valor;
    }

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor")
    private Double valor;
}
