package glassfish_fullstack.infrastructure;

import glassfish_fullstack.domain.MessageBo;
import glassfish_fullstack.domain.MessageDto;
import glassfish_fullstack.domain.MessageRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MessageRepositoryImpl implements MessageRepository {

    @Override
    public List<MessageBo> getMessages() {
        return List.of(new MessageBo[]{

            new MessageBo.Builder()
                .setId(1L)
                .setUsername("Peter")
                .setContext("Hello everyone")
                .build(),

            new MessageBo.Builder()
                .setId(2L)
                .setUsername("Chad")
                .setContext("Shut up Peter")
                .build(),

            new MessageBo.Builder()
                .setId(3L)
                .setUsername("Peter")
                .setContext("Okay :(")
                .build(),

        });
    }

    @Override
    public void createMessage(Long id, MessageDto messageDto) {

    }

    @Override
    public void updateMessage(Long id, MessageDto messageDto) {

    }

    @Override
    public void deleteMessage(Long id) {

    }

}
