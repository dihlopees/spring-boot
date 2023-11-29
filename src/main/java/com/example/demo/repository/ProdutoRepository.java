package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.unidade != 'UN' and p.classificacao.codigo = '003'")
    public List<Produto> exercicio1();

    @Query("SELECT p FROM Produto p WHERE p.unidade = 'UN' and p.classificacao.codigo = '003' and p.quantidade between '5.00' and '7.00' and p.valor < 10.0 ")
    public List<Produto> exercicio2();

    @Query("SELECT sum(p.valor) FROM Produto p WHERE p.descricao LIKE '%biscoito%'")
    public Double exercicio3();

     @Query("SELECT p.descricao FROM Produto p WHERE p.descricao LIKE '%martelo%' and p.classificacao.descricao != 'material de Construção'")
    public List<Produto> exercicio4();
}
