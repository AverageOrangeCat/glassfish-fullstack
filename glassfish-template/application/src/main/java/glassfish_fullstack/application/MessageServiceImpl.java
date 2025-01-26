package glassfish_fullstack.application;

import glassfish_fullstack.domain.MessageDto;
import glassfish_fullstack.domain.MessageRepository;
import glassfish_fullstack.domain.MessageService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MessageServiceImpl implements MessageService {

    @Inject
    private MessageRepository messageRepository;

    @Override
    public List<MessageDto> getMessages() {
        return this.messageRepository.getMessages()
            .stream()
            .map(MessageDto::from)
            .collect(Collectors.toList());
    }

    @Override
    public void createMessage(Long id, MessageDto messageDto) {
        this.messageRepository.createMessage(id, messageDto);
    }

    @Override
    public void updateMessage(Long id, MessageDto messageDto) {
        this.messageRepository.updateMessage(id, messageDto);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messageRepository.deleteMessage(id);
    }

}
