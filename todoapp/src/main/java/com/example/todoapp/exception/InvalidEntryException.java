package com.example.todoapp.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidEntryException extends RuntimeException {

    private String debugMessage;

    public InvalidEntryException(String message) {
        super(message);
    }

    public InvalidEntryException(String message, String debugMessage) {
        super(message);
        this.debugMessage = debugMessage;
    }
}
