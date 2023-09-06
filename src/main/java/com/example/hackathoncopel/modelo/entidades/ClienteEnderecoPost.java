package com.example.hackathoncopel.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente_endereco")
public class ClienteEnderecoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clienteendereco")
    private Long IdClienteEndereco;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientesPost ClienteId;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoPost EnderecoId;

    public Long getIdClienteEndereco() {
        return IdClienteEndereco;
    }

    public void setIdClienteEndereco(Long idClienteEndereco) {
        IdClienteEndereco = idClienteEndereco;
    }

    public ClientesPost getClienteId() {
        return ClienteId;
    }

    public void setClienteId(ClientesPost clienteId) {
        ClienteId = clienteId;
    }

    public EnderecoPost getEnderecoId() {
        return EnderecoId;
    }

    public void setEnderecoId(EnderecoPost enderecoId) {
        EnderecoId = enderecoId;
    }
}
