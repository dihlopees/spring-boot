package com.example.demo.controller;

import com.example.demo.model.NovoProduto;
import com.example.demo.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final List<Produto> listaProduto = new ArrayList<>();
    private  Produto prod;
    private Long codigo = Long.valueOf(1);

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
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
    public List<Produto> listarTodos() {
        return listaProduto;
    }
    int c = 1;
    @PostMapping()
    public Produto adicionarProduto(@RequestBody NovoProduto novoProduto) {
        Produto p = new Produto();
        p.setCodigo(Long.valueOf(c++));
        p.setDescricao(novoProduto.getDescricao());
        p.setValor(novoProduto.getValor());
        listaProduto.add(p);
        return p;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarProduto(@PathVariable(value = "id") Long id){
        if(!listaProduto.isEmpty()) {
            for(Produto p : listaProduto) {
                if(p.getCodigo() == id) return ResponseEntity.status(HttpStatus.OK).body(p);
            }
        }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> altProduto(@PathVariable(value = "id") Long id, @RequestBody Produto prod){
         if(!listaProduto.isEmpty()) {
            for(Produto p : listaProduto) {
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
            for(Produto p : listaProduto) {
                if(p.getCodigo() == id) listaProduto.remove(p);
            }
        }return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

}
