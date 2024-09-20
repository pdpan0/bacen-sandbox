package br.com.pdpano.clients.dto;

public record MessageDTO(String messageId,
                         String message,
                         boolean isPolling) { }
