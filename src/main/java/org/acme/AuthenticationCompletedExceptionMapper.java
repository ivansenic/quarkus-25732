package org.acme;

import io.quarkus.security.AuthenticationCompletionException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationCompletedExceptionMapper implements ExceptionMapper<AuthenticationCompletionException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(AuthenticationCompletionException exception) {
        // on purpose change to 5xx
        return Response.status(500).entity("Custom body").build();
    }
}
