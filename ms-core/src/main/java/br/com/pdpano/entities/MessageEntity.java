package br.com.pdpano.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "tb_messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String messageId = "M" + UUID.randomUUID();
    @Column
    private String message;
    @Column
    private boolean isPolling;

    public MessageEntity() { }

    public MessageEntity(Long id, String message, boolean isPolling) {
        this.id = id;
        this.message = message;
        this.isPolling = isPolling;
    }

    public static MessageEntity build(String message) {
        return new MessageEntity(null, message, false);
    }

    public Long getId() {
        return id;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public boolean isPolling() {
        return isPolling;
    }

    public MessageEntity setMessageGotByPolling() {
        return new MessageEntity(this.id, this.message, true);
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", messageId='" + messageId + '\'' +
                ", message='" + message + '\'' +
                ", isPolling=" + isPolling +
                '}';
    }
}
