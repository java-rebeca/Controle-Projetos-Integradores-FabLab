package com.example.controleProjetoIntegrador.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "projeto")
public class Projeto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_id")
    private Integer projetoId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "cursos")
    private String curso;

    @Column(name = "alunos")
    private List<String> alunos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    public Projeto(){}
    
    public Projeto(String nome, String descricao, String curso, List<String> alunos, Usuario usuario, Agenda agenda) {
        this.nome = nome;
        this.descricao = descricao;
        this.curso = curso;
        this.alunos = alunos;
        this.usuario = usuario;
        this.agenda = agenda;
    }

    public Integer getProjetoId() {
        return projetoId;
    }
    public void setProjetoId(Integer projetoId) {
        this.projetoId = projetoId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public List<String> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Agenda getAgenda() {
        return agenda;
    }
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}