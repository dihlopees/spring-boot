package com.example.demo.controller;

import com.example.demo.model.NovoProduto;
import com.example.demo.model.Produto;
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

    @PostMapping()
    public Produto adicionarProduto(@RequestBody NovoProduto novoProduto) {
        int c = listaProduto.size();
        System.out.printf(novoProduto.getDescricao());
        Produto p = new Produto();
        p.setCodigo(Long.valueOf(1+c));
        p.setDescricao(novoProduto.getDescricao());
        p.setValor(novoProduto.getValor());
        listaProduto.add(p);
        return p;
    }

}
