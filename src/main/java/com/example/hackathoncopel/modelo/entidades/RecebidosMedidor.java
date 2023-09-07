package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "recebidos_do_medidor")
public class RecebidosMedidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recebidosmedidor")
    private Long idRecebidosMedidor;

    @Column(name = "amperagem")
    private BigDecimal Amperagem;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = KilowattsRecebidos.class)
    @JoinColumn(name = "recebidosmedidor_id", referencedColumnName = "id_recebidosmedidor")
    @JsonManagedReference
    private Set<KilowattsRecebidos> kilowattsRecebidos;

    public Long getIdRecebidosMedidor() {
        return idRecebidosMedidor;
    }

    public void setIdRecebidosMedidor(Long idRecebidosMedidor) {
        this.idRecebidosMedidor = idRecebidosMedidor;
    }

    public BigDecimal getAmperagem() {
        return Amperagem;
    }

    public void setAmperagem(BigDecimal amperagem) {
        this.Amperagem = amperagem;
    }

    public Set<KilowattsRecebidos> getKilowattsRecebidos() {
        return kilowattsRecebidos;
    }

    public void setKilowattsRecebidos(Set<KilowattsRecebidos> kilowattsRecebidos) {
        this.kilowattsRecebidos = kilowattsRecebidos;
    }
}
