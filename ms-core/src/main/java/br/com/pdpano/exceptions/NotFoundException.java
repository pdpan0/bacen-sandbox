package br.com.pdpano.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String code) {
        super("Resource " + code + "was not found");
    }
}
