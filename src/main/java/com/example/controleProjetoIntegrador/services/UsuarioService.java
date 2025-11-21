// ...existing code...
package com.example.controleProjetoIntegrador.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.controleProjetoIntegrador.repositories.UsuarioRepository;
import com.example.controleProjetoIntegrador.models.Usuario;
import java.util.List;


@Service
public class UsuarioService{

    @Autowired
    private UsuarioRepository ur;

    // alterado: agora recebe confSenha e valida antes de salvar
    public Usuario cadastrarUsuario(Usuario u, String confSenha){
        if (u == null || u.getSenha() == null || !u.getSenha().equals(confSenha)){
            return null;
        }
        return ur.save(u);
    }

    // alterado: login não recebe mais confSenha
    public boolean loginUsuario(String email, String senha){
        Usuario u = ur.findUserByEmail(email);
        return (u != null && u.getSenha().equals(senha));
    }

    public Usuario buscarUsuarioPorId(Integer id){
        return ur.findById(id).orElse(null);
    }

    public void deletarUsuario(Integer id){
        ur.deleteById(id);
    }

    public List<Usuario> listarUsuarios(){
        return ur.findAll();
    }

    public Usuario atualizarUsuario(Usuario u, Integer id){
        Usuario _u = ur.findById(id).orElse(null);
        if (_u == null) return null;
        _u.setCpf(u.getCpf());
        _u.setNome(u.getNome());
        _u.setEmail(u.getEmail());
        _u.setSenha(u.getSenha());
        return ur.save(_u);
    }

    public Usuario findUserByEmail(String email) {
        return ur.findUserByEmail(email);
    }
}