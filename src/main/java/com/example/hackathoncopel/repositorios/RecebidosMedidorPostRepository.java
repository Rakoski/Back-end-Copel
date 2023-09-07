package com.example.hackathoncopel.repositorios;

import com.example.hackathoncopel.modelo.entidades.RecebidosMedidorPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecebidosMedidorPostRepository extends JpaRepository<RecebidosMedidorPost, Long> {
}
