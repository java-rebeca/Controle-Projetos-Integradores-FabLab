package com.example.controleProjetoIntegrador.repositories;

import com.example.controleProjetoIntegrador.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findUserByEmail(@Param("email") String email);
}
