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
import com.example.controleProjetoIntegrador.models.Agenda;
import com.example.controleProjetoIntegrador.services.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity<Agenda> criarAgenda(@RequestBody Agenda agenda) {
        Agenda a = agendaService.cadastrarAgenda(agenda);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> obterAgendaPorId(@PathVariable Integer id) {
        Agenda a = agendaService.buscarAgendaPorId(id);
        if (a == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Integer id) {
        agendaService.deletarAgenda(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizarAgenda(@PathVariable Integer id, @RequestBody Agenda agenda) {
        Agenda a = agendaService.atualizarAgenda(agenda, id);
        return ResponseEntity.ok(a);
    }

    @GetMapping("/findall")
    public ResponseEntity<Iterable<Agenda>> listarAgendas() {
        Iterable<Agenda> agendas = agendaService.listarAgendas();
        return ResponseEntity.ok(agendas);
    }

}
