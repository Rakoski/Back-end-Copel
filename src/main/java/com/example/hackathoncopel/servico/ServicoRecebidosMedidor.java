package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.RecebidosMedidor;
import com.example.hackathoncopel.modelo.entidades.RecebidosMedidorPost;
import com.example.hackathoncopel.repositorios.KilowattsRecebidosPostRepository;
import com.example.hackathoncopel.repositorios.RecebidosMedidorPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ServicoRecebidosMedidor {

    private RecebidosMedidorPostRepository recebidosMedidorPostRepository;

    private final KilowattsRecebidosPostRepository kilowattsRecebidosPostRepository;

    public ServicoRecebidosMedidor(RecebidosMedidorPostRepository recebidosMedidorPostRepository, KilowattsRecebidosPostRepository kilowattsRecebidosPostRepository) {
        this.recebidosMedidorPostRepository = recebidosMedidorPostRepository;
        this.kilowattsRecebidosPostRepository = kilowattsRecebidosPostRepository;
    }

    public void addAmperagem(BigDecimal amperagem) {
        RecebidosMedidorPost recebido = new RecebidosMedidorPost();
        recebido.setAmperagem(amperagem);
        recebidosMedidorPostRepository.save(recebido);
    }

}
