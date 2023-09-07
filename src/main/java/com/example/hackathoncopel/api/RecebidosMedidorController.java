package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.RecebidosMedidorPost;
import com.example.hackathoncopel.repositorios.RecebidosMedidorPostRepository;
import com.example.hackathoncopel.servico.ServicoRecebidosMedidor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/energia")
public class RecebidosMedidorController {

    private ServicoRecebidosMedidor servicoRecebidosMedidor;


    public RecebidosMedidorController(ServicoRecebidosMedidor servicoRecebidosMedidor) {
        this.servicoRecebidosMedidor = servicoRecebidosMedidor;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> addAmperagem(@RequestBody RecebidosMedidorPost requestBody) {
        BigDecimal amperagem = requestBody.getAmperagem();
        servicoRecebidosMedidor.addAmperagem(amperagem);
        return ResponseEntity.status(HttpStatus.CREATED).body("Amperagem added successfully");
    }

}
