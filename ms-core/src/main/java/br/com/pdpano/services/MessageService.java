package br.com.pdpano.services;

import br.com.pdpano.entities.MessageEntity;
import br.com.pdpano.repositories.MessageRepository;

import java.util.UUID;

public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void createMessage() {
        messageRepository.save(MessageEntity.build("M" + UUID.randomUUID()));
    }
}
