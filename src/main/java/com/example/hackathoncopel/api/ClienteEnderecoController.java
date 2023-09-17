package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import com.example.hackathoncopel.repositorios.ClienteEnderecoRepository;
import com.example.hackathoncopel.servico.ServicoClienteEndereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente-endereco")
public class ClienteEnderecoController {

    private final ServicoClienteEndereco servicoClienteEndereco;

    private final ClienteEnderecoRepository clienteEnderecoRepository;

    public ClienteEnderecoController(ServicoClienteEndereco servicoClienteEndereco, ClienteEnderecoRepository clienteEnderecoRepository) {
        this.servicoClienteEndereco = servicoClienteEndereco;
        this.clienteEnderecoRepository = clienteEnderecoRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClienteEnderecoPost> salvarClienteComEndereco(@RequestBody ClienteEnderecoPost request) {
        servicoClienteEndereco.salvandoClienteComSeuEndereco(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/encontre-todos-ceps/{IdCliente}")
    public List<String> pegarCepsPeloIdDoCliente(@PathVariable Long IdCliente) {
        return clienteEnderecoRepository.encontreTodosCepsPeloIdCliente(IdCliente);
    }

    // quero fazer uma função que retorna todos os ids do cliente que tão cadastrados com um id de endereço

    // e outro que retorna todos os ids de endereços (e seus ceps) cadastrados com um id do cliente


}
