package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "cliente_endereco")
public class ClienteEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clienteendereco")
    private Long IdClienteEndereco;

    @Column(name = "cliente_id")
    @JsonBackReference
    private Long ClienteId;

    @Column(name = "endereco_id")
    @JsonBackReference
    private Long EnderecoId;

    public Long getIdClienteEndereco() {
        return IdClienteEndereco;
    }

    public void setIdClienteEndereco(Long idClienteEndereco) {
        IdClienteEndereco = idClienteEndereco;
    }

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long clienteId) {
        ClienteId = clienteId;
    }

    public Long getEnderecoId() {
        return EnderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        EnderecoId = enderecoId;
    }
}
