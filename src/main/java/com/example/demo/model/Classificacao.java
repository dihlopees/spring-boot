package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table( name = "Classificacao" )
public class Classificacao implements Serializable {

    @Id
    @Column( name = "CODIGO" )
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo( String codigo ) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

    @Column( name = "DESCRICAO" )
    private String descricao;

    public Classificacao() {
    }

}
