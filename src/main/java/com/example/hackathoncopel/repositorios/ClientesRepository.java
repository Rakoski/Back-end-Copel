package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByEmail(String email);
}
