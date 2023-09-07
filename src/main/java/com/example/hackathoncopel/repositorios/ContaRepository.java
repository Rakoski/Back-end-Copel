package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.Conta;
import com.example.hackathoncopel.modelo.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "SELECT * FROM copel.conta c WHERE c.endereco_id = :enderecoId", nativeQuery = true)
    Optional<Conta> findByEnderecoId(@Param("enderecoId") Long enderecoId);

    @Query(
            value = "SELECT c.* FROM copel.conta c WHERE c.id_conta = :contaId; ",
            nativeQuery = true
    )
    Optional<Conta> findByIdConta(@Param("contaId") Long contaId);

    @Query(value = "SELECT endereco.* FROM copel.endereco JOIN copel.conta ON endereco.id_endereco" +
            " = conta.endereco_id WHERE conta.id_conta = :contaId", nativeQuery = true)
    Optional<Endereco> findEnderecoByContaId(@Param("contaId") Long contaId);


}
