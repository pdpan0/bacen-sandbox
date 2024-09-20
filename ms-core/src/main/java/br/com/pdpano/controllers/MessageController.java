package br.com.pdpano.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("packages")
@RestController
public class MessageController {

    @PostMapping
    public ResponseEntity<Void> create() {
        return ResponseEntity.ok().build();
    }

}
