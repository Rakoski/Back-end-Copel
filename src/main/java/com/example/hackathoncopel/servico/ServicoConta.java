package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.modelo.entidades.Conta;
import com.example.hackathoncopel.modelo.entidades.ContaPost;
import com.example.hackathoncopel.repositorios.ClientesPostRepository;
import com.example.hackathoncopel.repositorios.ClientesRepository;
import com.example.hackathoncopel.repositorios.ContaPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoConta {

    private final ContaPostRepository contaRepository;

    private final ClientesRepository clientesRepository;

    private final ClientesPostRepository clientesPostRepository;

    @Autowired
    public ServicoConta(ContaPostRepository contaRepository, ClientesRepository clientesRepository, ClientesPostRepository clientesPostRepository) {
        this.contaRepository = contaRepository;
        this.clientesRepository = clientesRepository;
        this.clientesPostRepository = clientesPostRepository;
    }

    @Transactional
    public void registrarConta(ContaPost request, Long clienteId) {
        // encontrando os clientes pelo seu id
        ClientesPost cliente = clientesPostRepository.findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com ID: " + clienteId));

        // instanciando a nova conta com todos seus métodos e propriedades
        ContaPost conta = new ContaPost();
        conta.setIdConta(request.getIdConta());
        conta.setDataDeVencimento(request.getDataDeVencimento());
        conta.setValorAPagar(request.getValorAPagar());
        conta.setStatusPagamento(request.getStatusPagamento());
        conta.setKilowattsHora(request.getKilowattsHora());

        // associando o cliente com a conta
        conta.setCliente(cliente.getIdCliente());

        // salvando a conta
        contaRepository.save(conta);
    }
}
