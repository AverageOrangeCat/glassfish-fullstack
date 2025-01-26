package glassfish_fullstack.api.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("ping")
public class PingController {

    @GET
    public String ping() {
        return "Pong";
    }

}
