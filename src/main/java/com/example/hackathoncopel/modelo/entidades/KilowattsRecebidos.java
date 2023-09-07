package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "kilowatts_recebidos")
public class KilowattsRecebidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tabela_kilowatts")
    private Long IdKilowatts;

    @ManyToOne
    @JoinColumn(name = "recebidosmedidor_id")
    private RecebidosMedidor recebidosMedidor;

    @Column(name = "kilowatts_hora")
    private int KilowattsPegos;

    @Column(name = "mes_recebido")
    private Date DataDeEmissao;

    public Long getIdKilowatts() {
        return IdKilowatts;
    }

    public void setIdKilowatts(Long idKilowatts) {
        IdKilowatts = idKilowatts;
    }

    public RecebidosMedidor getRecebidosMedidor() {
        return recebidosMedidor;
    }

    public void setRecebidosMedidor(RecebidosMedidor recebidosMedidor) {
        this.recebidosMedidor = recebidosMedidor;
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
