package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

import lombok.Getter;

@Getter
public class ErrorMessage {
    private final String exception;
    private final String message;

    public ErrorMessage(Exception exception) {
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
    }
}
