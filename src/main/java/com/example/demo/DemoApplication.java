package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("aula java 1");

//		List<Produto> listaProduto = new ArrayList<>();
//		listaProduto.add(null);
//
//		for(int x= 0; x<=9; x++) {
//			Produto p = new Produto();
//			p.setCodigo(Long.valueOf(1+x));
//			p.setDescricao("teste " + x);
//			p.setValor(29.90 + x);
//			listaProduto.add(p);
//		}
//
//				for(Produto prod: listaProduto) {
//					System.out.println(prod.getDescricao());
//				}
	}

}
