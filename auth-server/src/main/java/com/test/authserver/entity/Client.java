package com.test.authserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @MongoId
    private String id;

    private String clientId;

    private Instant clientIdIssuedAt = Instant.now();

    private String clientSecret;

    private String clientName;

    private Set<String> clientAuthenticationMethods;

    private Set<String> authorizationGrantTypes;

    private Set<String> redirectUris;

    private Set<String> scopes;

    private Boolean isRequireProofKey;

    @Bean
    public static RegisteredClient toRegisteredClient(Client client) {
        RegisteredClient.Builder builder = RegisteredClient.withId(client.getClientId())
                .clientId(client.getClientId())
                .clientIdIssuedAt(client.getClientIdIssuedAt())
                .clientSecret(client.getClientSecret())
                .clientName(client.getClientName())
                .clientAuthenticationMethods(
                        a -> a.addAll(
                                client.getClientAuthenticationMethods()
                                        .stream()
                                        .map(ClientAuthenticationMethod::new)
                                        .collect(Collectors.toSet())
                        )
                )
                .authorizationGrantTypes(
                        a -> a.addAll(
                                client.getAuthorizationGrantTypes()
                                        .stream()
                                        .map(AuthorizationGrantType::new)
                                        .collect(Collectors.toSet())
                        )
                )
                .redirectUris(a -> a.addAll(client.getRedirectUris()))
                .scopes(a -> a.addAll(client.getScopes()))
                .clientSettings(ClientSettings.builder()
                        .requireProofKey(client.isRequireProofKey)
                        .requireAuthorizationConsent(true)
                        .build()
                );

        return builder.build();
    }
}
