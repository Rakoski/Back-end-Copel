package com.example.hackathoncopel.api;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.repositorios.ClientesRepository;
import com.example.hackathoncopel.servico.EmailSenderService;
import com.example.hackathoncopel.servico.ServicoClientes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClientesController {

    private final ServicoClientes servicoClientes;

    private final ClientesRepository clientesRepository;

    private final EmailSenderService emailSenderService;

    public ClientesController(ServicoClientes servicoClientes, ClientesRepository clientesRepository, EmailSenderService emailSenderService) {
        this.servicoClientes = servicoClientes;
        this.clientesRepository = clientesRepository;
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ClientesPost> registrarUmCliente(@RequestBody ClientesPost request) {
        servicoClientes.registrarCliente(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginDoCliente(@RequestBody ClientesPost request) {
        servicoClientes.loginUser(request);
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/mandar-email-de-mudar-senha")
    public ResponseEntity<String> mandarEmailDeMudarSenha(@RequestBody String email) {
        Optional<Clientes> encontrouPeloEmail = clientesRepository.findByEmail(email);

        if (encontrouPeloEmail.isPresent()) {
            emailSenderService.SendEmail(email, "Mudança de senha requisitada",
                    "Para mudar sua senha, entre nesse site: ");
            return ResponseEntity.ok("Email enviado");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get")
    public List<Clientes> encontreInformacoesDeTodosClientes() {
        return servicoClientes.findAllClients();
    }

    @GetMapping("/cliente_info/{IdCliente}")
    public ResponseEntity<Map<String, String>> encontreInformacoesDeUmClientePorId(@PathVariable("IdCliente") Long IdCliente) {
        Map<String, String> userInfo = servicoClientes.findClientInfoById(IdCliente);
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/encontre/{email}")
    public Optional<Clientes> encontreInformacoesDeUmClientePorEmail(@PathVariable String email) {
        return clientesRepository.findByEmail(email);
    }

    @PutMapping("/update-email/{IdCliente}/{newEmail}")
    public ResponseEntity<String> updateEmailDeUmCliente(@PathVariable Long IdCliente, @PathVariable String newEmail) {
        servicoClientes.updateClienteEmail(IdCliente, newEmail);
        return ResponseEntity.ok("Email editado com sucesso!");
    }

    @PutMapping("/update-senha/{IdCliente}/{novaSenha}")
    public ResponseEntity<String> updateSenhaDeUmCliente(@PathVariable Long IdCliente, @PathVariable String novaSenha) {
        servicoClientes.updateClienteSenha(IdCliente, novaSenha);
        return ResponseEntity.ok("Senha editada com sucesso!");
    }
}
