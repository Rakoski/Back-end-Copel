package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.Conta;
import com.example.hackathoncopel.modelo.entidades.ContaPost;
import com.example.hackathoncopel.repositorios.ContaRepository;
import com.example.hackathoncopel.servico.ServicoConta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

    private ServicoConta servicoConta;

    private ContaRepository contaRepository;

    public ContaController(ServicoConta servicoConta, ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
        this.servicoConta = servicoConta;
    }

    @PostMapping("/registrar/{clienteId}")
    public ResponseEntity<ContaPost> registrarConta(@RequestBody ContaPost request, @PathVariable Long clienteId) {
        servicoConta.registrarConta(request, clienteId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/conta-info/{contaId}")
    public Optional<Conta> getContaInfo(@PathVariable Long contaId) {
        return contaRepository.findByIdConta(contaId);
    }

    @GetMapping("/{ClienteId}")
    public Optional<Conta> encontreContaPeloIdDoCliente(@PathVariable Long ClienteId) {
        return contaRepository.findByClienteId(ClienteId);
    }

}
