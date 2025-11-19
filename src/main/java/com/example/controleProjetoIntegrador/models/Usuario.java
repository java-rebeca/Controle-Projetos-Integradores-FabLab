package com.example.controleProjetoIntegrador.models;
import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "email")
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "senha")
    private String senha;

    public Usuario(){}
    public Usuario(String email, String cpf, String senha) {
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}