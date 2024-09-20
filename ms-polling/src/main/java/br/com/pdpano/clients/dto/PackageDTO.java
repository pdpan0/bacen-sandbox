package br.com.pdpano.clients.dto;


import java.nio.charset.StandardCharsets;

public record PackageDTO(String code, String binary) {
    public static PackageDTO build(byte[] bytes) {
        return new PackageDTO(null, new String(bytes, StandardCharsets.UTF_8));
    }
}
