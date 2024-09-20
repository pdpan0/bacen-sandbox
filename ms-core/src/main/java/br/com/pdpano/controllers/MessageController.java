package br.com.pdpano.controllers;

import br.com.pdpano.entities.MessageEntity;
import br.com.pdpano.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@SuppressWarnings("unused")
@RequestMapping("v1/messages")
@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<MessageEntity> save(@RequestBody String message) {
        return ResponseEntity.created(URI.create(messageService.saveMessage(message).getMessageId())).build();
    }

    @GetMapping
    public ResponseEntity<List<MessageEntity>> getMessages() {
        return ResponseEntity.ok(messageService.getMessages());
    }
}
