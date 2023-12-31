package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long ContaId;

    @Column(name = "endereco_id")
    @JsonBackReference
    private Long EnderecoId;

    @Column(name = "valor_a_pagar")
    private BigDecimal ValorAPagar;

    @Column(name = "data_de_vencimento")
    private Date DataDeVencimento;

    @Column(name = "status_pagamento")
    private String StatusPagamento;

    @Column(name = "kilowatts_hora")
    private int KilowattsHora;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = KilowattsRecebidos.class)
    @JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
    private Set<KilowattsRecebidos> kilowattsRecebidos;

    public Set<KilowattsRecebidos> getKilowattsRecebidos() {
        return kilowattsRecebidos;
    }

    public void setKilowattsRecebidos(Set<KilowattsRecebidos> kilowattsRecebidos) {
        this.kilowattsRecebidos = kilowattsRecebidos;
    }

    public Long getCliente() {
        return EnderecoId;
    }

    public void setCliente(Long enderecoId) {
        EnderecoId = enderecoId;
    }

    public BigDecimal getValorAPagar() {
        return ValorAPagar;
    }

    public void setValorAPagar(BigDecimal valorAPagar) {
        ValorAPagar = valorAPagar;
    }

    public Date getDataDeVencimento() {
        return DataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        DataDeVencimento = dataDeVencimento;
    }

    public String getStatusPagamento() {
        return StatusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        StatusPagamento = statusPagamento;
    }

    public int getKilowattsHora() {
        return KilowattsHora;
    }

    public void setKilowattsHora(int kilowattsHora) {
        KilowattsHora = kilowattsHora;
    }

    public Long getContaId() {
        return ContaId;
    }

    public void setContaId(Long contaId) {
        ContaId = contaId;
    }

    public Long getEnderecoId() {
        return EnderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        EnderecoId = enderecoId;
    }
}
