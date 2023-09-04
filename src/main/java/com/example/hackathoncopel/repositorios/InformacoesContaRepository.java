package com.example.hackathoncopel.repositorios;


import com.example.hackathoncopel.modelo.entidades.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformacoesContaRepository extends JpaRepository<Conta, Long> {
}
