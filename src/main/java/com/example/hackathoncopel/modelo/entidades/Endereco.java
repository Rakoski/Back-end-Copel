package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long IdEndereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private String numero;

    @OneToMany(targetEntity = ClienteEndereco.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    @JsonManagedReference
    private Set<ClienteEndereco> clienteEnderecos;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Conta.class)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    @JsonManagedReference
    private Set<Conta> contas;

    public Long getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        IdEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Set<ClienteEndereco> getClienteEnderecos() {
        return clienteEnderecos;
    }

    public void setClienteEnderecos(Set<ClienteEndereco> clienteEnderecos) {
        this.clienteEnderecos = clienteEnderecos;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }
}
