package glassfish_fullstack.api.controllers;

import glassfish_fullstack.domain.MessageDto;
import glassfish_fullstack.domain.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("message")
public class MessageController {

    @Inject
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageDto> getMessages() {
        return this.messageService.getMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMessage(@QueryParam("id") Long id, MessageDto messageDto) {
        this.messageService.createMessage(id, messageDto);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMessage(@QueryParam("id") Long id, MessageDto messageDto) {
        this.messageService.updateMessage(id, messageDto);
    }

    @DELETE
    public void deleteMessage(@QueryParam("id") Long id) {
        this.messageService.deleteMessage(id);
    }

}
