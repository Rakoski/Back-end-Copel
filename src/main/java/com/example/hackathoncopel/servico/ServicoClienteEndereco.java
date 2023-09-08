package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import com.example.hackathoncopel.repositorios.ClienteEnderecoPostRepository;
import com.example.hackathoncopel.repositorios.ClienteEnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ServicoClienteEndereco {

    private ClienteEnderecoRepository clienteEnderecoRepository;

    private final ClienteEnderecoPostRepository clienteEnderecoPostRepository;

    public ServicoClienteEndereco(ClienteEnderecoRepository clienteEnderecoRepository, ClienteEnderecoPostRepository clienteEnderecoPostRepository) {
        this.clienteEnderecoRepository = clienteEnderecoRepository;
        this.clienteEnderecoPostRepository = clienteEnderecoPostRepository;
    }

    @Transactional
    public void salvandoClienteComSeuEndereco(ClienteEnderecoPost request) {
        try {
            ClienteEnderecoPost clienteEndereco = new ClienteEnderecoPost();

            clienteEndereco.setClienteId(request.getClienteId());
            clienteEndereco.setEnderecoId(request.getEnderecoId());

            clienteEnderecoPostRepository.save(clienteEndereco);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o relacionamento ClienteEndereço: " + e.getMessage());
        }
    }


}
