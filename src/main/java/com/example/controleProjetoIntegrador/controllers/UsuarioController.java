// ...existing code...
package com.example.controleProjetoIntegrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.controleProjetoIntegrador.models.Usuario;
import com.example.controleProjetoIntegrador.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // alterado: recebe confSenha como RequestParam para validação na criação
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario, @RequestParam String confSenha) {
        Usuario u = usuarioService.cadastrarUsuario(usuario, confSenha);
        if (u == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senhas não conferem");
        }
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    // alterado: login não exige confSenha
    @PostMapping("/login")
    public String loginUsuario(@RequestParam String email, @RequestParam String senha) {
        boolean autenticado = usuarioService.loginUsuario(email, senha);
        if (autenticado) {
            return "Login bem-sucedido!";
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Integer id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);
        if (u == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario u = usuarioService.atualizarUsuario(usuario, id);
        if (u == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(u);
    }
}