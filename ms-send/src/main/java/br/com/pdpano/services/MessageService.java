package br.com.pdpano.services;

import br.com.pdpano.entities.MessageEntity;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private static final String INITIATE_BINDING = "initiate";
    private final StreamBridge streamBridge;

    public MessageService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void send(MessageEntity message) {
        streamBridge.send(INITIATE_BINDING, message);
    }
}
