package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ItensVendaPk implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda")
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo")
    private Produto produto;

    public ItensVendaPk () {
    }

    public Venda getVenda () {
        return venda;
    }

    public void setVenda ( Venda venda ) {
        this.venda = venda;
    }

    public Produto getProduto () {
        return produto;
    }

    public void setProduto ( Produto produto ) {
        this.produto = produto;
    }
}
