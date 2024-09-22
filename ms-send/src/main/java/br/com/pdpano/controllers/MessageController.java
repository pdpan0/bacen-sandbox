package br.com.pdpano.controllers;

import br.com.pdpano.entities.MessageEntity;
import br.com.pdpano.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody MessageEntity message) {
        messageService.send(message);
        return ResponseEntity.accepted().build();
    }
}
