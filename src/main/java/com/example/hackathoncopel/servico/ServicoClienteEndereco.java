package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.ClienteEndereco;
import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.modelo.entidades.EnderecoPost;
import com.example.hackathoncopel.repositorios.ClienteEnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoClienteEndereco {

    private ClienteEnderecoRepository clienteEnderecoRepository;

    public ServicoClienteEndereco(ClienteEnderecoRepository clienteEnderecoRepository) {
        this.clienteEnderecoRepository = clienteEnderecoRepository;
    }

    public ClienteEnderecoPost salvandoClienteComSeuEndereco(ClientesPost cliente, EnderecoPost endereco) {
        try {
            ClienteEnderecoPost clienteEndereco = new ClienteEnderecoPost();

            clienteEndereco.setClienteId(cliente);
            clienteEndereco.setEnderecoId(endereco);

            return clienteEnderecoRepository.save(clienteEndereco);
        } catch (Exception e) {
            throw new RuntimeException("Error saving ClienteEndereco relationship: " + e.getMessage());
        }
    }

}
