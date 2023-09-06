package com.example.hackathoncopel.modelo.entidades;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "clientes")
public class ClientesPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha_salt")
    private byte[] senha_salt;

    @Column(name = "senha_hash")
    private byte[] senha_hash;

    @Transient
    private String password;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ClienteEnderecoPost.class)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private Set<ClienteEnderecoPost> clienteEnderecoPosts;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getSenha_salt() {
        return senha_salt;
    }

    public void setSenha_salt(byte[] senha_salt) {
        this.senha_salt = senha_salt;
    }

    public byte[] getSenha_hash() {
        return senha_hash;
    }

    public void setSenha_hash(byte[] senha_hash) {
        this.senha_hash = senha_hash;
    }

    public Set<ClienteEnderecoPost> getClienteEnderecoPosts() {
        return clienteEnderecoPosts;
    }

    public void setClienteEnderecoPosts(Set<ClienteEnderecoPost> clienteEnderecoPosts) {
        this.clienteEnderecoPosts = clienteEnderecoPosts;
    }
}
