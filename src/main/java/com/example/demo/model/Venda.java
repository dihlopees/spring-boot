package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "VENDA")
public class Venda implements Serializable {
    @Id
    private Integer id_venda;

    @OneToMany(mappedBy = "pk.venda")
    private List<ItensVenda> itensVendas;
}
