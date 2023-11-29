package com.example.demo.service;

import com.example.demo.model.Classificacao;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    public List<Produto> listaProdutos() {
        return this.repository.findAll();
    }

    public Optional<Produto> listaUmProduto( Long id){
        return repository.findById(id);
    }

    public List<Produto> exercicio1() {
    return repository.exercicio1();
    }
    public List<Produto> exercicio2() {
    return repository.exercicio2();
    }

    public Double exercicio3() {
    return repository.exercicio3();
    }

    public List<Produto> exercicio4() {
    return repository.exercicio4();
    }

}
