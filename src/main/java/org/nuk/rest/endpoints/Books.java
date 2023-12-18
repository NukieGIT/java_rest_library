package org.nuk.rest.endpoints;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class Books {

    @GET
    public String get() {
        return "Books";
    }

}
