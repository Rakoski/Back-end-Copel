package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.ClienteEnderecoPost;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.servico.ServicoClienteEndereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente-endereco")
public class ClienteEnderecoController {

    private ServicoClienteEndereco servicoClienteEndereco;

    public ClienteEnderecoController(ServicoClienteEndereco servicoClienteEndereco) {
        this.servicoClienteEndereco = servicoClienteEndereco;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> salvarClienteComEndereco(@RequestBody ClienteEnderecoPost request) {
        try {
            ClienteEnderecoPost savedClienteEndereco =
                    servicoClienteEndereco.salvandoClienteComSeuEndereco(request.getClienteId(),
                    request.getEnderecoId());

            // se não conseguir salvar o cliente com o endereço
            if (savedClienteEndereco == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro ao salvar o Cliente com seu Endereco.");
            }

            return ResponseEntity.ok("Cliente salvo com seu endereço com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar o Cliente com endereço: " + e.getMessage());
        }
    }


}
