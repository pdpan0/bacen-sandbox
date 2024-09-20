package br.com.pdpano.services;

import br.com.pdpano.entities.MessageEntity;
import br.com.pdpano.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageEntity saveMessage(String message) {
        return messageRepository.save(MessageEntity.build(message));
    }

    public List<MessageEntity> getMessages() {
        final List<MessageEntity> messages = messageRepository.findAllByIsPollingFalse();
        LOGGER.info("Messages: {}", messages);
        messages.forEach(it -> messageRepository.save(it.setMessageGotByPolling()));
        return messages;
    }
}
