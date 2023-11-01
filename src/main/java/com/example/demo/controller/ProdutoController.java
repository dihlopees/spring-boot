package com.example.demo.controller;

import com.example.demo.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final List<Produto> listaProduto = new ArrayList<>();
    private  Produto prod;
    private Long codigo = Long.valueOf(1);

    @GetMapping()
    public String teste() {
        return "Java testehhhh";
    }

}
