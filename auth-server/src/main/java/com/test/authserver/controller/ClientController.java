package com.test.authserver.controller;

import com.test.authserver.dto.CreateClientDto;
import com.test.authserver.entity.Client;
import com.test.authserver.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody CreateClientDto dto) {
        Client client = this.clientService.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
}
