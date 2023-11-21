package com.example.demo.dto;

public record Cep(
        String cep, String logradouro,
        String bairro, String localidade, String uf) {
}
