package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT id_endereco FROM copel.endereco WHERE cep = :cep", nativeQuery = true)
    Optional<Long> findIdByCep(@Param("cep") String cep);

    @Query(value = "SELECT e.cep FROM copel.endereco e" +
            " INNER JOIN copel.cliente_endereco ce ON ce.endereco_id = e.id_endereco" +
            " WHERE ce.cliente_id = :idCliente", nativeQuery = true)
    List<String> encontreTodosCepsPeloIdCliente(Long idCliente);
}
