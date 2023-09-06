package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.*;
import com.example.hackathoncopel.repositorios.ClientesPostRepository;
import com.example.hackathoncopel.repositorios.ClientesRepository;
import com.example.hackathoncopel.repositorios.ContaPostRepository;
import com.example.hackathoncopel.repositorios.EnderecoPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoConta {

    private final ContaPostRepository contaRepository;

    private final ClientesRepository clientesRepository;

    private final EnderecoPostRepository enderecoPostRepository;

    @Autowired
    public ServicoConta(ContaPostRepository contaRepository, ClientesRepository clientesRepository, ClientesPostRepository clientesPostRepository, EnderecoPostRepository enderecoPostRepository) {
        this.contaRepository = contaRepository;
        this.clientesRepository = clientesRepository;
        this.enderecoPostRepository = enderecoPostRepository;
    }

    @Transactional
    public void registrarConta(ContaPost request, Long enderecoId) {
        // encontrando os clientes pelo seu id
        EnderecoPost enderecoPost = enderecoPostRepository.findById(enderecoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado com ID: " + enderecoId));

        // instanciando a nova conta com todos seus métodos e propriedades
        ContaPost conta = new ContaPost();
        conta.setIdConta(request.getIdConta());
        conta.setDataDeVencimento(request.getDataDeVencimento());
        conta.setValorAPagar(request.getValorAPagar());
        conta.setStatusPagamento(request.getStatusPagamento());
        conta.setKilowattsHora(request.getKilowattsHora());

        // associando o cliente com a conta
        conta.setEnderecoId(enderecoPost.getIdEndereco());

        // salvando a conta
        contaRepository.save(conta);
    }
}
