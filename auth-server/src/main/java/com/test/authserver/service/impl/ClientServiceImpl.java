package com.test.authserver.service.impl;

import com.test.authserver.dto.CreateClientDto;
import com.test.authserver.entity.Client;
import com.test.authserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements RegisteredClientRepository {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client createClient(CreateClientDto dto) {
        Client client = Client.builder()
                .clientId(dto.getClientId())
                .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                .clientName(dto.getClientName())
                .clientAuthenticationMethods(dto.getClientAuthenticationMethods())
                .authorizationGrantTypes(dto.getAuthorizationGrantTypes())
                .redirectUris(dto.getRedirectUris())
                .scopes(dto.getScopes())
                .isRequireProofKey(dto.getIsRequireProofKey())
                .build();

        return clientRepository.save(client);
    }

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return clientRepository.findByClientId(id)
                .map(Client::toRegisteredClient)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return clientRepository.findByClientId(clientId)
                .map(Client::toRegisteredClient)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }
}
