package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT id_endereco FROM copel.endereco WHERE cep = :cep", nativeQuery = true)
    List<Long> findIdByCep(@Param("cep") String cep);
}
