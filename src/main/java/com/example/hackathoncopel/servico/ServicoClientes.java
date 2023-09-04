package com.example.hackathoncopel.servico;

import com.example.hackathoncopel.modelo.entidades.Clientes;
import com.example.hackathoncopel.modelo.entidades.ClientesPost;
import com.example.hackathoncopel.repositorios.ClientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicoClientes {

    private final ClientesRepository clientesRepository;

    @Autowired
    public ServicoClientes(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Transactional
    public void registrarCliente(ClientesPost request) {
        // Validando o email pelo PasswordUtils
        if (!PasswordUtils.isValidEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email inválido!");
        }

        // Gerando o hash e salt
        byte[] passwordSalt = PasswordUtils.generateSalt();
        byte[] passwordHash = PasswordUtils.generateHash(request.getPassword(), passwordSalt);

        // Codificando usando Base64
        String passwordHashString = PasswordUtils.encodeBase64(passwordHash);
        String passwordSaltString = PasswordUtils.encodeBase64(passwordSalt);

        // Criando e salvando o cliente na db
        Clientes clientes = new Clientes();
        clientes.setNome(request.getNome());
        clientes.setSobrenome(request.getSobrenome());
        clientes.setEmail(request.getEmail());
        clientes.setSenha_salt(passwordSaltString.getBytes());
        clientes.setSenha_hash(passwordHashString.getBytes());

        clientesRepository.save(clientes);
    }

    @Transactional
    public void loginUser(ClientesPost request) {
        // encontrando o cliente pelo email
        Clientes clientes = clientesRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        // Decode stored salt and hash from Base64
        byte[] storedPasswordHash = PasswordUtils.decodeBase64(clientes.getSenha_hash());
        byte[] storedPasswordSalt = PasswordUtils.decodeBase64(clientes.getSenha_salt());

        // Generate hash for entered password using stored salt
        byte[] enteredPasswordHash = PasswordUtils.generateHash(request.getPassword(), storedPasswordSalt);

        // Compare the generated hash with the stored hash
        if (!MessageDigest.isEqual(storedPasswordHash, enteredPasswordHash)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect password");
        }
    }

    // Pegue uma lista de todos os clientes
    public List<Clientes> findAllClients() {
        return clientesRepository.findAll();
    }

    // Pegue as informações em forma de JSON para dar para o front, com o id informado
    public Map<String, String> findClientInfoById(Long idCliente) {
        Clientes clientes = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found with ID " + idCliente));

        Map<String, String> clientInfo = new HashMap<>();
        clientInfo.put("nome", clientes.getNome());
        clientInfo.put("sobrenome", clientes.getSobrenome());
        clientInfo.put("email", clientes.getEmail());

        return clientInfo;
    }

    public Optional<Clientes> findClientsByEmail(String email) {
        // Pegando os clientes do repositório
        return clientesRepository.findByEmail(email);
    }

    @Transactional
    public void updateClienteEmail(Long userId, String newEmail) {
        // encontrar o cliente pelo Id
        Clientes clientes = clientesRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID " + userId));

        // fazendo o update do email do cliente...
        clientes.setEmail(newEmail);
        clientesRepository.save(clientes);
    }
}
