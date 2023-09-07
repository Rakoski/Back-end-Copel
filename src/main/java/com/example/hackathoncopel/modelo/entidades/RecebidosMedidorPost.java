package com.example.hackathoncopel.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "recebidos_do_medidor")
public class RecebidosMedidorPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recebidosmedidor")
    private Long idRecebidosMedidor;

    @Column(name = "amperagem")
    private BigDecimal Amperagem;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = KilowattsRecebidosPost.class)
    @JoinColumn(name = "recebidosmedidor_id", referencedColumnName = "id_recebidosmedidor")
    private Set<KilowattsRecebidosPost> kilowattsRecebidosPost;

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

    public Set<KilowattsRecebidosPost> getKilowattsRecebidosPost() {
        return kilowattsRecebidosPost;
    }

    public void setKilowattsRecebidosPost(Set<KilowattsRecebidosPost> kilowattsRecebidosPost) {
        this.kilowattsRecebidosPost = kilowattsRecebidosPost;
    }
}
