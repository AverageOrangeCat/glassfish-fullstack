package glassfish_fullstack.domain;

import java.util.List;

public interface MessageRepository {

    public List<MessageBo> getMessages();

    public void createMessage(Long id, MessageDto messageDto);

    public void updateMessage(Long id, MessageDto messageDto);

    public void deleteMessage(Long id);

}
