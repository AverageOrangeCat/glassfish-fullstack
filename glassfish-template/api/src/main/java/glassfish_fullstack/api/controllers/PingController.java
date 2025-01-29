package glassfish_fullstack.api.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("")
public class PingController {

    @GET
    @Path("/ping")
    public String ping() {
        return "Pong";
    }

}
