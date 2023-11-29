package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping()
    public ResponseEntity<Livro> gravarLivro( @RequestBody Livro livro ) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.gravaLivro(livro));
    }

    @GetMapping()
    public ResponseEntity<List<Livro>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarTodos());
    }

      @GetMapping("/{id}")
    public ResponseEntity<Object> buscarId(@PathVariable(value = "id") Long id) {
        Optional t = livroService.buscaUm(id);

        if (t.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(t);
      }

      @PutMapping("/{id}")
      public ResponseEntity<Object> atualizarLivro(@PathVariable(value = "id") Long id, @RequestBody Livro livro  ) {
          Optional<Livro> t = livroService.buscaUm(id);
            if (t.isEmpty()) {
             return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
            }

          Livro novoLivro = t.get();
          novoLivro.setAutor(livro.getAutor());
          novoLivro.setGenero(livro.getGenero());
          novoLivro.setTitulo(livro.getTitulo());

          return ResponseEntity.status(HttpStatus.OK).body(livroService.gravaLivro(novoLivro));
      }

      @DeleteMapping("/{id}")
     public ResponseEntity<Object> deletaLivro(@PathVariable(value = "id") Long id ) {
          Optional<Livro> livro = livroService.buscaUm(id);

          if (livro.isEmpty()) {
              return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
          }

        livroService.deleta(livro);
        return ResponseEntity.status(HttpStatus.OK).body("deletado");
      }

}
