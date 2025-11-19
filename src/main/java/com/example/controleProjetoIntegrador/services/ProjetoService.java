package com.example.controleProjetoIntegrador.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.controleProjetoIntegrador.repositories.ProjetoRepository;
import com.example.controleProjetoIntegrador.models.Projeto;
import java.util.List;


@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository pr;

    public Projeto cadastrarProjeto(Projeto p){
        return pr.save(p);
    }

    public Projeto buscarProjetoPorId(Integer id){
        return pr.findById(id).orElse(null);
    }

    public void deletarProjeto(Integer id){
        pr.deleteById(id);
    }

    public List<Projeto> listarProjetos(){
        return pr.findAll();
    }

    public Projeto atualizarProjeto(Projeto p, Integer id){
        Projeto _p = pr.findById(id).orElse(null);
        if (_p == null) {
            return null;
        }
        _p.setNome(p.getNome());
        _p.setDescricao(p.getDescricao());
        _p.setCurso(p.getCurso());
        _p.setAlunos(p.getAlunos());
        _p.setUsuario(p.getUsuario());
        _p.setAgenda(p.getAgenda());
        return pr.save(_p);
    }
}