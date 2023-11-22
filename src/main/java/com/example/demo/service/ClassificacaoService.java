package com.example.demo.service;

import com.example.demo.model.Classificacao;
import com.example.demo.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificacaoService {

    @Autowired
    private ClassificacaoRepository repository;

    public List<Classificacao> listarClassificacao () {
        return this.repository.findAll();
    }

    public Optional<Classificacao> listaUmaClassificacao ( Long id ) {
        return repository.findById(id);
    }

    public Optional<Classificacao>exercicio1() {
        return repository.findById(Long.valueOf(003));
    }


//    public Optional<Produto> resolucao(Long id) {
//        if (id == 1) {
//            return repository.findAll()
//        }
//    }
}
