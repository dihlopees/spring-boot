package com.example.demo.controller;

import com.example.demo.dto.Cep;
import com.example.demo.facade.CepFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {
    @Autowired
    private CepFacade cepFacade;
    @GetMapping("/{cep}")
    public Cep buscaCep(@PathVariable String cep){
        return cepFacade.buscaCep(cep);
    }
}
