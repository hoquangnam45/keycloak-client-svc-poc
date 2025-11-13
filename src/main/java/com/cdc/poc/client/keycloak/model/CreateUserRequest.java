package com.cdc.poc.client.keycloak.model;

public record CreateUserRequest(String username, String password, String fullName) {
}
