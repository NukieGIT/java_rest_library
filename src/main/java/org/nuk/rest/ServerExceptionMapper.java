package org.nuk.rest;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static jakarta.ws.rs.core.Response.*;

@Provider
public class ServerExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException e) {
        String message = e.getMessage();
        Response response = e.getResponse();
        Status status = response.getStatusInfo().toEnum();

        return status(status)
                .entity(new Error(message, status.getStatusCode()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
