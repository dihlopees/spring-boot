package com.example.demo.model;

public class Produto {
    public Produto() {
    }

    public Produto(String descricao, double valor) {
        Long c = getCodigo();

    }
    private Long codigo;
    private String descricao;
    private double valor;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
