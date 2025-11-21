package com.example.controleProjetoIntegrador.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "agenda")
public class Agenda{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agenda_id")
    private Integer agendaId;

    @Column(name = "data")
    private LocalDate data;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "horario")
    private LocalTime horario;

    public Agenda(){}

    public Agenda(LocalDate data, LocalTime horario) {
        this.data = data;
        this.horario = horario;
    }
    
    public Integer getAgendaId() {
        return agendaId;
    }
    public void setAgendaId(Integer agendaId) {
        this.agendaId = agendaId;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }


}