package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.repositorios.ClientesRepository;
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

    private final ClientesRepository clientesRepository;

    public ClientesController(ServicoClientes servicoClientes, ClientesRepository clientesRepository) {
        this.servicoClientes = servicoClientes;
        this.clientesRepository = clientesRepository;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClientesPost> registrarCliente(@RequestBody ClientesPost request) {
        servicoClientes.registrarCliente(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCliente(@RequestBody ClientesPost request) {
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
        return clientesRepository.findByEmail(email);
    }

    @PutMapping("/update-email/{IdCliente}/{newEmail}")
    public ResponseEntity<String> updateEmail(@PathVariable Long IdCliente, @PathVariable String newEmail) {
        servicoClientes.updateClienteEmail(IdCliente, newEmail);
        return ResponseEntity.ok("Email editado com sucesso!");
    }

    @PutMapping("/update-senha/{IdCliente}/{novaSenha}")
    public ResponseEntity<String> updateSenha(@PathVariable Long IdCliente, @PathVariable String novaSenha) {
        servicoClientes.updateClienteSenha(IdCliente, novaSenha);
        return ResponseEntity.ok("Senha editada com sucesso!");
    }
}
