package com.example.demo.facade;

import com.example.demo.dto.Cep;
import com.example.demo.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CepFacade {
    @Autowired
    private CepService service;
    public Cep buscaCep(String cep){
        return service.getCep(cep);
    }
}
