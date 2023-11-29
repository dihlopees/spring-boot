package com.example.demo.service;

import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired //injeção de dependencia
    private LivroRepository repository;

    public Livro gravaLivro(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> buscarTodos() {
        return repository.findAll();
    }

    public Optional<Livro> buscaUm( Long id) {
        return repository.findById(id);
    }

    public void deleta( Optional<Livro> livro) {
       repository.delete(livro.get());
    }
}
