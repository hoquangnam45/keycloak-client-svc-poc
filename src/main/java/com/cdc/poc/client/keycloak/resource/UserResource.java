package com.cdc.poc.client.keycloak.resource;

import com.cdc.poc.client.keycloak.client.UserClient;
import com.cdc.poc.client.keycloak.model.CreateUserRequest;
import com.cdc.poc.client.keycloak.model.UpdateUserRequest;
import com.cdc.poc.client.keycloak.model.UserMdl;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/client/user")
public class UserResource {
    private final UserClient userClient;

    public UserResource(@RestClient UserClient userClient) {
        this.userClient = userClient;
    }

    @GET
    public RestResponse<Object> getUser(@QueryParam("id") String id, @QueryParam("username") String username) {
        return userClient.getUser(id, username);
    }

    @POST
    public RestResponse<UserMdl> createUser(CreateUserRequest request) {
        return userClient.createUser(request);
    }

    @PUT
    public RestResponse<Object> updateUser(UpdateUserRequest request) {
        return userClient.updateUser(request);
    }

    @DELETE
    public RestResponse<String> deleteUser(@QueryParam("id") String id, @QueryParam("username") String username) {
        return userClient.deleteUser(id, username);
    }
}
