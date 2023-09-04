package com.example.hackathoncopel.modelo.entidades;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "conta")
public class ContaPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long IdInformacoesConta;

    @Column(name = "cliente_id")
    private Long ClienteId;

    @Column(name = "valor_a_pagar")
    private BigDecimal ValorAPagar;

    @Column(name = "data_de_vencimento")
    private Date DataDeVencimento;

    @Column(name = "status_pagamento")
    private String StatusPagamento;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = KilowattsRecebidosPost.class)
    @JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
    private Set<KilowattsRecebidosPost> kilowattsRecebidosPosts;

    public Set<KilowattsRecebidosPost> getKilowattsRecebidosPosts() {
        return kilowattsRecebidosPosts;
    }

    public void setKilowattsRecebidosPosts(Set<KilowattsRecebidosPost> kilowattsRecebidosPosts) {
        this.kilowattsRecebidosPosts = kilowattsRecebidosPosts;
    }

    public Long getIdInformacoesConta() {
        return IdInformacoesConta;
    }

    public void setIdInformacoesConta(Long idInformacoesConta) {
        IdInformacoesConta = idInformacoesConta;
    }

    public Long getClienteId() {
        return ClienteId;
    }

    public void setClienteId(Long clienteId) {
        ClienteId = clienteId;
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
}