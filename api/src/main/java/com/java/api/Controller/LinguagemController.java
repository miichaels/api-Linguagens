package com.java.api.Controller;

import com.java.api.Linguagem.Linguagem;
import com.java.api.Repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinguagemController {


    @Autowired
    private LinguagemRepository repositorio;


    @GetMapping("/linguagens-alura")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @GetMapping("/linguagens")
    public ResponseEntity<List<Linguagem>> GetAll () {
        return ResponseEntity.ok(repositorio.findAll());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Linguagem>> GetTitle (@PathVariable String title){
        return ResponseEntity.ok(repositorio.title(title));
    }


    @PostMapping
    public ResponseEntity<Linguagem> post(@Validated @RequestBody Linguagem linguagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(linguagem));
    }

    @PutMapping
    public ResponseEntity<Linguagem> put (@Validated @RequestBody Linguagem linguagem){
        return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(linguagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLinguagem (@PathVariable String id){
        return repositorio.findById(id).map(resposta -> {repositorio.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();})
                .orElse(ResponseEntity.notFound().build());

    }

}
