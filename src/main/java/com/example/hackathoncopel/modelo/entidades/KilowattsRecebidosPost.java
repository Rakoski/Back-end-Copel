package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "kilowatts_recebidos")
public class KilowattsRecebidosPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tabela_kilowatts")
    private Long IdKilowatts;

    @Column(name = "conta_id")
    @JsonBackReference
    private Long ContaId;

    @Column(name = "kilowatts_pegos")
    private int KilowattsPegos;

    @Column(name = "data_de_emissao")
    private Date DataDeEmissao;

    public Long getIdKilowatts() {
        return IdKilowatts;
    }

    public void setIdKilowatts(Long idKilowatts) {
        IdKilowatts = idKilowatts;
    }

    public Long getContaId() {
        return ContaId;
    }

    public void setContaId(Long contaId) {
        ContaId = contaId;
    }

    public int getKilowattsPegos() {
        return KilowattsPegos;
    }

    public void setKilowattsPegos(int kilowattsPegos) {
        KilowattsPegos = kilowattsPegos;
    }

    public Date getDataDeEmissao() {
        return DataDeEmissao;
    }

    public void setDataDeEmissao(Date dataDeEmissao) {
        DataDeEmissao = dataDeEmissao;
    }
}

