package glassfish_fullstack.domain;

import java.util.List;

public interface MessageService {

    List<MessageDto> getMessages();

    void createMessage(MessageDto messageDto);

    void updateMessage(Long id, MessageDto messageDto);

    void deleteMessage(Long id);

}
