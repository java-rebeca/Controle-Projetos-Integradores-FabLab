package com.example.controleProjetoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.controleProjetoIntegrador.models.Projeto;
import com.example.controleProjetoIntegrador.services.ProjetoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto p = projetoService.cadastrarProjeto(projeto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> obterProjetoPorId(@PathVariable Integer id) {
        Projeto p = projetoService.buscarProjetoPorId(id);
        if (p == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Integer id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable Integer id, @RequestBody Projeto projeto) {
        Projeto p = projetoService.atualizarProjeto(projeto, id);
        if (p == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(p);
    }
}
