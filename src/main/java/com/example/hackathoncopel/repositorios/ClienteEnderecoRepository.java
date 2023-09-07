package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteEnderecoRepository extends JpaRepository<ClienteEnderecoPost, Long> {
}
