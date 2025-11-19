package com.cdc.poc.client.keycloak.client;

import com.cdc.poc.client.keycloak.filter.TokenLoggingFilter;
import com.cdc.poc.client.keycloak.model.CreateUserRequest;
import com.cdc.poc.client.keycloak.model.UpdateUserRequest;
import com.cdc.poc.client.keycloak.model.UserMdl;
import io.quarkus.oidc.client.filter.OidcClientFilter;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/users")
@RegisterRestClient(configKey = "user-data-api")
@OidcClientFilter("user-data-api")
@RegisterProvider(TokenLoggingFilter.class)
public interface UserClient {
    @GET
    RestResponse<Object> getUser(@QueryParam("id") String id, @QueryParam("username") String username);

    @POST
    RestResponse<UserMdl> createUser(CreateUserRequest request);

    @DELETE
    RestResponse<String> deleteUser(@QueryParam("id") String id, @QueryParam("username") String username);

    @PUT
    RestResponse<Object> updateUser(UpdateUserRequest request);
}
