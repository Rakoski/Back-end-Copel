package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.servico.ServicoClientes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno")
public class ClientesController {

    private final ServicoClientes servicoClientes;

    public ClientesController(ServicoClientes servicoClientes) {
        this.servicoClientes = servicoClientes;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClientesPost> registrarCliente(@RequestBody ClientesPost request) {
        // Delegate registration logic to UserService
        servicoClientes.registerUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCliente(@RequestBody ClientesPost request) {
        // Delegate login logic to UserService
        servicoClientes.loginUser(request);
        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/get")
    public List<Clientes> encontreTodosClientes() {
        return servicoClientes.findAllClients();
    }

    @GetMapping("/cliente_info/{IdCliente}")
    public ResponseEntity<Map<String, String>> encontreClientePorId(@PathVariable("IdCliente") Long IdCliente) {
        Map<String, String> userInfo = servicoClientes.findClientInfoById(IdCliente);
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/encontre/{email}")
    public Optional<Clientes> encontreClientePorEmail(@PathVariable String email) {
        return servicoClientes.findClientsByEmail(email);
    }
}