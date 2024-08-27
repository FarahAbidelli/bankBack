package com.pfe.Bank.controller;

import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.model.Client;
import com.pfe.Bank.model.ClientProfes;
import com.pfe.Bank.repository.ClientRepository;
import com.pfe.Bank.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;
    @PostMapping(value = "/uploadClient", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadClients(
            @RequestPart("file") MultipartFile file) throws IOException {

        Set<ClientProfes> clients = clientService.uploadClients(file);

        clients.forEach(client -> clientRepository.save(client));

        return ResponseEntity.ok(clients.size());
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return clientService.getClients();
    }
    @GetMapping("/getClientById/{id}")
    public Client getClientById(@PathVariable Long id) throws MissingEntity {
        Client client = clientService.getClientById(id);
        return client;
    }
    @DeleteMapping("/deleteClient/{id}")
    public Map<String,Boolean> deleteClient(@PathVariable Long id) throws MissingEntity{
        return clientService.deleteClient(id);
    }
}
