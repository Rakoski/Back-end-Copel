package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.Endereco;
import com.example.hackathoncopel.modelo.entidades.EnderecoPost;
import com.example.hackathoncopel.repositorios.ContaRepository;
import com.example.hackathoncopel.servico.ServicoEndereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final ServicoEndereco servicoEndereco;

    private final ContaRepository contaRepository;

    public EnderecoController(ServicoEndereco servicoEndereco, ContaRepository contaRepository) {
        this.servicoEndereco = servicoEndereco;
        this.contaRepository = contaRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<EnderecoPost> registrarEndereco(@RequestBody EnderecoPost request) {
        servicoEndereco.registrarEndereco(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{contaId}")
    public Optional<Endereco> pegarInformacoesEnderecoPeloIdDaConta(@RequestBody EnderecoPost enderecoPost,
                                                                    @PathVariable Long contaId) {
        return contaRepository.findEnderecoByContaId(contaId);
    }

}
