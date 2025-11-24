package com.example.controleProjetoIntegrador.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.controleProjetoIntegrador.repositories.ProjetoRepository;
import com.example.controleProjetoIntegrador.repositories.AgendaRepository;
import com.example.controleProjetoIntegrador.repositories.UsuarioRepository;
import com.example.controleProjetoIntegrador.models.Projeto;
import com.example.controleProjetoIntegrador.models.Agenda;
import com.example.controleProjetoIntegrador.models.Usuario;
import java.util.List;


@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository pr;
    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private AgendaRepository ar;

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

    public Projeto atualizarProjeto(Projeto p, Integer id, Integer idUsuario, Integer idAgenda){
        Projeto _p = pr.findById(id).orElse(null);
        if (_p == null) {
            return null;
        }
        if (p.getNome() != null){
            _p.setNome(p.getNome());
        }
        if (p.getDescricao() != null){
            _p.setDescricao(p.getDescricao());
        }
        if (p.getCurso() != null){
            _p.setCurso(p.getCurso());
        }
        if (p.getAlunos() != null){
            _p.setAlunos(p.getAlunos());
        }
        if (idUsuario != null){
            Usuario usr = ur.findById(idUsuario).orElse(null);
            _p.setUsuario(usr);
        }
        if (idAgenda != null){
            Agenda ag = ar.findById(idAgenda).orElse(null);
            _p.setAgenda(ag);
        }
        return pr.save(_p);
    }
}