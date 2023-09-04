package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "SELECT * FROM copel.conta c WHERE c.cliente_id = :clienteId", nativeQuery = true)
    Optional<Conta> findByClienteId(@Param("clienteId") Long clienteId);

}
