package br.com.pdpano.consumers;

import br.com.pdpano.entities.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.MessageMapping;

import java.util.function.Consumer;

@MessageEndpoint
public class IsoMessageConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IsoMessageConsumer.class);

    @MessageMapping
    Consumer<MessageEntity> initiate() {
        return message -> LOGGER .info("Received message: {}", message);
    }

}
