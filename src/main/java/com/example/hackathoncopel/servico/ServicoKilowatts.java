package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.ContaPost;
import com.example.hackathoncopel.modelo.entidades.KilowattsRecebidosPost;
import com.example.hackathoncopel.repositorios.ContaPostRepository;
import com.example.hackathoncopel.repositorios.KilowattsRecebidosPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoKilowatts {

    private final KilowattsRecebidosPostRepository kilowattsRecebidosPostRepository;
    private final ContaPostRepository contaRepository;

    @Autowired
    public ServicoKilowatts(KilowattsRecebidosPostRepository kilowattsRecebidosPostRepository, ContaPostRepository contaRepository) {
        this.kilowattsRecebidosPostRepository = kilowattsRecebidosPostRepository;
        this.contaRepository = contaRepository;
    }

    // os kilowatts recebidos irão vir do arduino, então eles que se virem pra me mandar isso
    @Transactional
    public void registrarKilowattsRecebidos(KilowattsRecebidosPost request, Long contaId) {
        // encontrando a conta pelo seu id, se não tiver retorne uma ResponseStatusException
        ContaPost conta = contaRepository.findById(contaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada com ID: " + contaId));

        KilowattsRecebidosPost kilowattsRecebidos = new KilowattsRecebidosPost();
        kilowattsRecebidos.setContaId(conta.getIdConta());
        kilowattsRecebidos.setKilowattsPegos(request.getKilowattsPegos());
        kilowattsRecebidos.setDataDeEmissao(request.getDataDeEmissao());

        // salvando o kilowatts recebidos
        kilowattsRecebidosPostRepository.save(kilowattsRecebidos);
    }
}

