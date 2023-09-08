package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.KilowattsRecebidosPost;
import com.example.hackathoncopel.modelo.entidades.RecebidosMedidorPost;
import com.example.hackathoncopel.repositorios.KilowattsRecebidosPostRepository;
import com.example.hackathoncopel.repositorios.RecebidosMedidorPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoKilowatts {

    private final KilowattsRecebidosPostRepository kilowattsRecebidosPostRepository;
    private final RecebidosMedidorPostRepository recebidosMedidorPostRepository;

    @Autowired
    public ServicoKilowatts(KilowattsRecebidosPostRepository kilowattsRecebidosPostRepository, RecebidosMedidorPostRepository recebidosMedidorPostRepository, RecebidosMedidorPostRepository recebidosMedidorPostRepository1) {
        this.kilowattsRecebidosPostRepository = kilowattsRecebidosPostRepository;
        this.recebidosMedidorPostRepository = recebidosMedidorPostRepository1;
    }

    // os kilowatts fotovoltaicos recebidos irão vir do arduino, então eles que se virem pra me mandar isso
    // aqui, estamos registrando eles no servico para que o cliente possa vẽ-los no site.
    // para isso, será necessário o endpoint mais simples da face da terra. É o que eu fiz no servicoRecebidosMedidor
    @Transactional
    public void registrarKilowattsRecebidos(KilowattsRecebidosPost request, Long recebidosMedidorId) {
        RecebidosMedidorPostRepository recebidosMedidorPostRepository1 =
                (RecebidosMedidorPostRepository) recebidosMedidorPostRepository.findById(recebidosMedidorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "recebidosMedidor não encontrados com ID: " + recebidosMedidorId));

        KilowattsRecebidosPost kilowattsRecebidos = new KilowattsRecebidosPost();
        kilowattsRecebidos.setRecebidosMedidor(kilowattsRecebidos.getRecebidosMedidor());
        kilowattsRecebidos.setKilowattsPegos(request.getKilowattsPegos());
        kilowattsRecebidos.setDataDeEmissao(request.getDataDeEmissao());

        kilowattsRecebidosPostRepository.save(kilowattsRecebidos);
    }
}

