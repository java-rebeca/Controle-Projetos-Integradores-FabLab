package com.example.controleProjetoIntegrador.repositories;

import com.example.controleProjetoIntegrador.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findUserByEmail(@Param("email") String email);
}
