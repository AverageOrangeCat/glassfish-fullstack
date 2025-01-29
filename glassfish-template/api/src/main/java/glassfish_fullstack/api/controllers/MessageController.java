package glassfish_fullstack.api.controllers;

import glassfish_fullstack.domain.MessageDto;
import glassfish_fullstack.domain.MessageService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("")
@ApplicationScoped()
public class MessageController {

    @Inject
    private MessageService messageService;

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageDto> getMessages() {
        return this.messageService.getMessages();
    }

    @POST
    @Path("/message")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMessage(MessageDto messageDto) {
        this.messageService.createMessage(messageDto);
    }

    @PUT
    @Path("/message/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMessage(@PathParam("id") Long id, MessageDto messageDto) {
        this.messageService.updateMessage(id, messageDto);
    }

    @DELETE
    @Path("/message/{id}")
    public void deleteMessage(@PathParam("id") Long id) {
        this.messageService.deleteMessage(id);
    }

}
