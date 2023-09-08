package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.ClienteEndereco;
import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.servico.ServicoClienteEndereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cliente-endereco")
public class ClienteEnderecoController {

    private final ServicoClienteEndereco servicoClienteEndereco;

    public ClienteEnderecoController(ServicoClienteEndereco servicoClienteEndereco) {
        this.servicoClienteEndereco = servicoClienteEndereco;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClienteEnderecoPost> salvarClienteComEndereco(@RequestBody ClienteEnderecoPost request) {
        servicoClienteEndereco.salvandoClienteComSeuEndereco(request);
        return ResponseEntity.ok().build();
    }

    // quero fazer uma função que retorna todos os ids do cliente que tão cadastrados com um id de endereço

    // e outro que retorna todos os ids de endereços (e seus ceps) cadastrados com um id do cliente


}
