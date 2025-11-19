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

    public Usuario cadastrarUsuario(Usuario u){
        return ur.save(u);
    }

    public Usuario buscarUsuarioPorId(Integer id){
        return ur.findById(id).orElse(null);
    }

    public boolean loginUsuario(String email, String senha, String confSenha){
        if (senha.equals(confSenha)){
            Usuario u = ur.findUserByEmail(email);
            return (u != null && u.getSenha().equals(senha));
        }
        else{
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
        Usuario _u = ur.findById(id).orElse(null);
        if (_u == null) return null;
        _u.setCpf(u.getCpf());
        _u.setNome(u.getNome());
        _u.setEmail(u.getEmail());
        _u.setSenha(u.getSenha());
        return ur.save(_u);
    }
}