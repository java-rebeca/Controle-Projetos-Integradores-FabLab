package com.example.controleProjetoIntegrador.repositories;
import com.example.controleProjetoIntegrador.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Agenda, Integer> {
}