package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.modelo.entidades.Endereco;
import com.example.hackathoncopel.modelo.entidades.EnderecoPost;
import com.example.hackathoncopel.repositorios.EnderecoPostRepository;
import com.example.hackathoncopel.repositorios.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServicoEndereco {

    private EnderecoRepository enderecoRepository;

    private EnderecoPostRepository enderecoPostRepository;

    public ServicoEndereco(EnderecoRepository enderecoRepository, EnderecoPostRepository enderecoPostRepository) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoPostRepository = enderecoPostRepository;
    }

    @Transactional
    public void registrarEndereco(EnderecoPost request) {

        EnderecoPost endereco = new EnderecoPost();
        endereco.setCep(request.getCep());
        endereco.setNumero(request.getNumero());

        enderecoPostRepository.save(endereco);
    }

}
