package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.ContaPost;
import com.example.hackathoncopel.modelo.entidades.KilowattsRecebidos;
import com.example.hackathoncopel.modelo.entidades.KilowattsRecebidosPost;
import com.example.hackathoncopel.servico.ServicoConta;
import com.example.hackathoncopel.servico.ServicoKilowatts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kilowatts")
public class KilowattsController {

    private ServicoKilowatts servicoKilowatts;

    public KilowattsController(ServicoKilowatts servicoKilowatts) {
        this.servicoKilowatts = servicoKilowatts;
    }

    @PostMapping("/registrar/{contaId}")
    public ResponseEntity<KilowattsRecebidosPost> registrarKilowatts(@RequestBody KilowattsRecebidosPost request,
                                                                     @PathVariable Long contaId) {
        servicoKilowatts.registrarKilowattsRecebidos(request, contaId);
        return ResponseEntity.ok().build();
    }

}
