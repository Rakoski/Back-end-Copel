package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
