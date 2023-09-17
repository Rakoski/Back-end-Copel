package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.Endereco;
import com.example.hackathoncopel.modelo.entidades.EnderecoPost;
import com.example.hackathoncopel.repositorios.ContaRepository;
import com.example.hackathoncopel.repositorios.EnderecoRepository;
import com.example.hackathoncopel.servico.ServicoEndereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final ServicoEndereco servicoEndereco;

    private final ContaRepository contaRepository;

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(ServicoEndereco servicoEndereco, ContaRepository contaRepository, EnderecoRepository enderecoRepository) {
        this.servicoEndereco = servicoEndereco;
        this.contaRepository = contaRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<EnderecoPost> registrarEndereco(@RequestBody EnderecoPost request) {
        servicoEndereco.registrarEndereco(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{contaId}")
    public Optional<Endereco> pegarInformacoesEnderecoPeloIdDaConta(@PathVariable Long contaId) {
        return contaRepository.findEnderecoByContaId(contaId);
    }

    // eu vou fazer um endpoint pra pegar um id de um endereço pelo seu cep porque no site, eu vou colocar o cep como
    // sessionstorage, daí depois eu pego o cep da sessionstorage e com ele, pesquiso o id do endereço,
    // com o id do endereço, eu retorno todos os ceps cadastrados com tal id de endereço
    @GetMapping("/encontre-pelo-cep/{cep}")
    public List<Long> pegarIdDoEnderecoPeloCEP(@PathVariable String cep) {
        return enderecoRepository.findIdByCep(cep);
    }

}
