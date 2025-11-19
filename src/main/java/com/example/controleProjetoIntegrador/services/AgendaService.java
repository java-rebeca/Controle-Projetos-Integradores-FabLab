package com.example.controleProjetoIntegrador.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.controleProjetoIntegrador.repositories.AgendaRepository;
import com.example.controleProjetoIntegrador.models.Agenda;
import java.util.List;


@Service
public class AgendaService {

    @Autowired
    private AgendaRepository ar;

    public Agenda cadastrarAgenda(Agenda a){
        return ar.save(a);
    }

    public Agenda buscarAgendaPorId(Integer id){
        return ar.findById(id).orElse(null);
    }

    public void deletarAgenda(Integer id){
        ar.deleteById(id);
    }

    public List<Agenda> listarAgendas(){
        return ar.findAll();
    }

    public Agenda atualizarAgenda(Agenda a, Integer id){
        Agenda _a = ar.findById(id).orElse(null);
        if (_a == null) {
            return null;
        }
        _a.setData(a.getData());
        _a.setHorario(a.getHorario());
        return ar.save(_a);
    }
}