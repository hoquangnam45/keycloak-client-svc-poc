package com.cdc.poc.client.keycloak.model;

public record UpdateUserRequest(String id, String fullName, String password) {
}
