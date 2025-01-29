package glassfish_fullstack.domain;

import java.util.List;

public interface MessageService {

    public List<MessageDto> getMessages();

    public void createMessage(MessageDto messageDto);

    public void updateMessage(Long id, MessageDto messageDto);

    public void deleteMessage(Long id);

}
