package com.example.hackathoncopel.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente_endereco")
public class ClienteEnderecoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clienteendereco")
    private Long IdClienteEndereco;

    // eu coloquei tanto o clienteId como o enderecoId como long pois tavam dando BadRequest ao associar os dois
    // acredito que isso não será um problema já que os dois foram possíveis de se associarem assim,
    // mesmo com a ligação many-to-one
    @Column(name = "cliente_id")
    private Long ClienteId;

    @Column(name = "endereco_id")
    private Long EnderecoId;

    public ClienteEnderecoPost(Long clienteId, Long enderecoId) {
        this.ClienteId = clienteId;
        this.EnderecoId = enderecoId;
    }

    public ClienteEnderecoPost() {

    }

    public Long getIdClienteEndereco() {
        return IdClienteEndereco;
    }

    public void setIdClienteEndereco(Long idClienteEndereco) {
        IdClienteEndereco = idClienteEndereco;
    }

    public Long getClienteId() {
        return ClienteId;
    }

    public Long getEnderecoId() {
        return EnderecoId;
    }

    public void setClienteId(Long clienteId) {
        ClienteId = clienteId;
    }

    public void setEnderecoId(Long enderecoId) {
        EnderecoId = enderecoId;
    }
}
