package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "endereco")
public class EnderecoPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long IdEndereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private String numero;

    @OneToMany(targetEntity = ClienteEnderecoPost.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    private Set<ClienteEnderecoPost> clienteEnderecosPost;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ContaPost.class)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    private Set<ContaPost> contasPost;

    public EnderecoPost(Long idEndereco, String cep, String numero,
                        Set<ClienteEnderecoPost> clienteEnderecosPost, Set<ContaPost> contasPost) {
        IdEndereco = idEndereco;
        this.cep = cep;
        this.numero = numero;
        this.clienteEnderecosPost = clienteEnderecosPost;
        this.contasPost = contasPost;
    }

    public EnderecoPost() {

    }

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

    public Set<ClienteEnderecoPost> getClienteEnderecosPost() {
        return clienteEnderecosPost;
    }

    public void setClienteEnderecosPost(Set<ClienteEnderecoPost> clienteEnderecosPost) {
        this.clienteEnderecosPost = clienteEnderecosPost;
    }

    public Set<ContaPost> getContasPost() {
        return contasPost;
    }

    public void setContasPost(Set<ContaPost> contasPost) {
        this.contasPost = contasPost;
    }
}
