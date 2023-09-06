package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "cliente_endereco")
public class ClienteEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clienteendereco")
    private Long IdClienteEndereco;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Clientes ClienteId;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    @JsonBackReference
    private Endereco EnderecoId;

    public Long getIdClienteEndereco() {
        return IdClienteEndereco;
    }

    public void setIdClienteEndereco(Long idClienteEndereco) {
        IdClienteEndereco = idClienteEndereco;
    }

    public Clientes getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Clientes clienteId) {
        ClienteId = clienteId;
    }

    public Endereco getEnderecoId() {
        return EnderecoId;
    }

    public void setEnderecoId(Endereco enderecoId) {
        EnderecoId = enderecoId;
    }
}
