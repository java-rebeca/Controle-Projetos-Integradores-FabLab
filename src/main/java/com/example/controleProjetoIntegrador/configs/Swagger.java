package com.example.controleProjetoIntegrador.repositories;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Controle-Projeto-Integrador-FabLab", 
        version = "1.0", 
        description = "API para gerenciamento do Controle Projeto Integrador"
    )
)


public class Swagger {
}