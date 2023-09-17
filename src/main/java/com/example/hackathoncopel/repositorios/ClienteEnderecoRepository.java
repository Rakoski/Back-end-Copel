package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.ClienteEndereco;
import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteEnderecoRepository extends JpaRepository<ClienteEndereco, Long> {

    @Query(value = "SELECT e.* FROM copel.endereco e" +
            " INNER JOIN copel.cliente_endereco ce ON ce.endereco_id = e.id_endereco" +
            " WHERE ce.cliente_id = :idCliente", nativeQuery = true)
    List<String> encontreTodosCepsPeloIdCliente(Long idCliente);
}
