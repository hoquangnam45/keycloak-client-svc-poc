package com.cdc.poc.client.keycloak.filter;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class TokenLoggingFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        String authHeader = requestContext.getHeaderString("Authorization");
        log.info("Outbound request to: {}. Auth header: {}", requestContext.getUri(), authHeader);
    }
}
