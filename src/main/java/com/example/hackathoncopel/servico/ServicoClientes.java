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
        if (!PasswordUtils.isValidEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email inválido!");
        }

        byte[] passwordSalt = PasswordUtils.generateSalt();
        byte[] passwordHash = PasswordUtils.generateHash(request.getPassword(), passwordSalt);

        String passwordHashString = PasswordUtils.encodeBase64(passwordHash);
        String passwordSaltString = PasswordUtils.encodeBase64(passwordSalt);

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
        Clientes clientes = clientesRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado"));

        byte[] storedPasswordHash = PasswordUtils.decodeBase64(clientes.getSenha_hash());
        byte[] storedPasswordSalt = PasswordUtils.decodeBase64(clientes.getSenha_salt());

        byte[] enteredPasswordHash = PasswordUtils.generateHash(request.getPassword(), storedPasswordSalt);

        if (!MessageDigest.isEqual(storedPasswordHash, enteredPasswordHash)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta");
        }
    }

    public List<Clientes> findAllClients() {
        return clientesRepository.findAll();
    }

    // Pegue as informações em forma de JSON para dar para o front, com o id informado.
    // Eu decidi
    public Map<String, String> findClientInfoById(Long idCliente) {
        Clientes clientes = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com id " + idCliente));

        Map<String, String> clientInfo = new HashMap<>();
        clientInfo.put("nome", clientes.getNome());
        clientInfo.put("sobrenome", clientes.getSobrenome());
        clientInfo.put("email", clientes.getEmail());

        return clientInfo;
    }

    @Transactional
    public void updateClienteEmail(Long clienteId, String newEmail) {
        Clientes clientes = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com id"
                        + clienteId));

        clientes.setEmail(newEmail);
        clientesRepository.save(clientes);
    }

    @Transactional
    public void updateClienteSenha(Long idCliente, String novaSenha) {
        Clientes clientes = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com id"
                        + idCliente));

        byte[] passwordSalt = PasswordUtils.generateSalt();
        byte[] passwordHash = PasswordUtils.generateHash(novaSenha, passwordSalt);

        String passwordHashString = PasswordUtils.encodeBase64(passwordHash);
        String passwordSaltString = PasswordUtils.encodeBase64(passwordSalt);

        clientes.setSenha_hash(passwordHashString.getBytes());
        clientes.setSenha_salt(passwordSaltString.getBytes());

        clientesRepository.save(clientes);

    }
}
