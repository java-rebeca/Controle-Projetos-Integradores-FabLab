package com.example.controleProjetoIntegrador.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.controleProjetoIntegrador.repositories.UsuarioRepository;
import com.example.controleProjetoIntegrador.models.Usuario;


@Service
public class UsuarioService{

    @Autowired
    UsuarioRepository ur;

    public Usuario cadastrarUsuario(Usuario u){
        return ur.save(u);
    }

    public Usuario buscarUsuarioPorId(Long id){
        return ur.findById(id).orElse(null);
    }

    public boolean loginUsuario(String email, String senha){
        Usuario u = ur.findUserByEmail(email);
        if(u != null && u.getSenha().equals(senha)){
            return true;
        } else {
            return false;
        }
    }

    public void deletarUsuario(Integer id){
        ur.deleteById(id);
    }

    public List<Usuario> listarUsuarios(){
        return ur.findAll();
    }

    public Usuario atualizarUsuario(Usuario u, Integer id){
        _u = ur.findById(id).orElse(null);
        _u.setCpf(u.getCpf());
        _u.setEmail(u.getEmail());
        _u.setSenha(u.getSenha());
        return ur.save(_u);
    }
}