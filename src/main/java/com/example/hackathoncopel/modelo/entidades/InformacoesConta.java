package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "InformacoesConta")
public class InformacoesConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInformacoesConta")
    private Long IdInformacoesConta;

    @Column(name = "ClienteId")
    @JsonBackReference
    private Long ClienteId;

    @Column(name = "valor_a_pagar")
    private BigDecimal ValorAPagar;

    @Column(name = "data_de_emissao")
    private Date DataDeEmissao;

    @Column(name = "data_de_vencimento")
    private Date DataDeVencimento;

    @Column(name = "status_pagamento")
    private String StatusPagamento;

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

    public Date getDataDeEmissao() {
        return DataDeEmissao;
    }

    public void setDataDeEmissao(Date dataDeEmissao) {
        DataDeEmissao = dataDeEmissao;
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
