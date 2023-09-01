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
    public void registerUser(ClientesPost request) {
        // Validate the email format using PasswordUtils
        if (!PasswordUtils.isValidEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Email");
        }

        // Generate password salt and hash using PasswordUtils
        byte[] passwordSalt = PasswordUtils.generateSalt();
        byte[] passwordHash = PasswordUtils.generateHash(request.getPassword(), passwordSalt);

        // Encode the salt and hash as Base64 strings
        String passwordHashString = PasswordUtils.encodeBase64(passwordHash);
        String passwordSaltString = PasswordUtils.encodeBase64(passwordSalt);

        // Create and save the Clientes entity
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
        // Retrieve clients by email from the repository
        return clientesRepository.findByEmail(email);
    }
}
