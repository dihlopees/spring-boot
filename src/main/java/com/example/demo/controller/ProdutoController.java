package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.service.ClassificacaoService;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    public ProdutoController() {
    }

    @Autowired
    private ProdutoService service;
    private ClassificacaoService classificacaoService;

    @GetMapping()
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listaProdutos());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getProduto(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.listaUmProduto(id));
    }

    @GetMapping({"/exercicio/{id}"})
    public ResponseEntity<Object> resolucaoExercicio(@PathVariable("id") Integer id) {
        if (id == 1) return ResponseEntity.status(HttpStatus.OK).body(this.service.exercicio1());
        if (id == 2) return ResponseEntity.status(HttpStatus.OK).body(this.service.exercicio2());
        if (id == 3) return ResponseEntity.status(HttpStatus.OK).body(this.service.exercicio3());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe o exercicio solicitado");
    }
}
