package com.example.demo.controller;

import com.example.demo.model.NovoProduto;
import com.example.demo.model.ProdutoAula02;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teste")
public class ProdutoAula2Controller {

    private final List<ProdutoAula02> listaProduto = new ArrayList<>();
    private ProdutoAula02 prod;
    private Long codigo = Long.valueOf(1);

    public List<ProdutoAula02> getListaProduto() {
        return listaProduto;
    }

    public ProdutoAula02 getProd() {
        return prod;
    }

    public void setProd( ProdutoAula02 prod) {
        this.prod = prod;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @GetMapping("/teste")
    public String teste() {
        return "Java teste";
    }

    @GetMapping()
    public List<ProdutoAula02> listarTodos() {
        return listaProduto;
    }
    int c = 1;
    @PostMapping()
    public ProdutoAula02 adicionarProduto( @RequestBody NovoProduto novoProduto) {
        ProdutoAula02 p = new ProdutoAula02();
        p.setCodigo(Long.valueOf(c++));
        p.setDescricao(novoProduto.getDescricao());
        p.setValor(novoProduto.getValor());
        listaProduto.add(p);
        return p;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarProduto(@PathVariable(value = "id") Long id){
        if(!listaProduto.isEmpty()) {
            for(ProdutoAula02 p : listaProduto) {
                if(p.getCodigo() == id) return ResponseEntity.status(HttpStatus.OK).body(p);
            }
        }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> altProduto(@PathVariable(value = "id") Long id, @RequestBody ProdutoAula02 prod){
         if(!listaProduto.isEmpty()) {
            for(ProdutoAula02 p : listaProduto) {
                if(p.getCodigo() == id) {
                    p.setDescricao(prod.getDescricao());
                    p.setValor(prod.getValor());
                }
            }
        }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delProd(@PathVariable(value = "id") Long id) {
        if(!listaProduto.isEmpty()) {
            for(ProdutoAula02 p : listaProduto) {
                if(p.getCodigo() == id) listaProduto.remove(p);
            }
        }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

}
