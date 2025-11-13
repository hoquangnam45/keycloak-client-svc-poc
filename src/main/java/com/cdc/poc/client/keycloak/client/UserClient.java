package com.cdc.poc.client.keycloak.client;

import com.cdc.poc.client.keycloak.model.CreateUserRequest;
import com.cdc.poc.client.keycloak.model.UpdateUserRequest;
import com.cdc.poc.client.keycloak.model.UserMdl;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/api/data/user")
@RegisterRestClient(configKey = "user-data-api")
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
