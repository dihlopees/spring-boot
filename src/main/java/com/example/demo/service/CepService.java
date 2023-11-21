package com.example.demo.service;


import com.example.demo.dto.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient( url = "https://viacep.com.br/ws/" , name = "cep")
public interface CepService {
        @GetMapping("{cep}/json")
        Cep getCep(@PathVariable String cep);
}

