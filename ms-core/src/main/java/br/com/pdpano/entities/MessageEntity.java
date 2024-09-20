package br.com.pdpano.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "tb_messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    @Column
    private final String messageId;
    @Column
    private final String message;

    public MessageEntity(String messageId, String message) {
        this.message = message;
        this.id = null;
        this.messageId = messageId;
    }

    public MessageEntity(Long id, String messageId, String message) {
        this.id = id;
        this.messageId = messageId;
        this.message = message;
    }

    public static MessageEntity build(String messageId) {
        return new MessageEntity(messageId, UUID.randomUUID().toString());
    }

    public Long getId() {
        return id;
    }

    public String getMessageId() {
        return messageId;
    }
}
