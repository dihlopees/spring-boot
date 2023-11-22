package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Produto")
public class Produto implements Serializable {

    public Produto() {
    }

    @Id
    @GeneratedValue()
    @Column( name = "CODIGO" )
    private Integer codigo;

    @Column( name = "DESCRICAO" )
    private String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo( Integer codigo ) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo( char tipo ) {
        this.tipo = tipo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade( String unidade ) {
        this.unidade = unidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade( String quantidade ) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor( Double valor ) {
        this.valor = valor;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao( Classificacao classificacao ) {
        this.classificacao = classificacao;
    }

    @Column( name = "TIPO" )
    private char tipo;
    @Column( name = "UNIDADE" )
    private String unidade;

    @Column( name = "QUANTIDADE" )
    private String quantidade;

    @Column( name = "VALOR" )
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "CODIGO_CLASSIFICACAO" )
    private Classificacao classificacao;
}
