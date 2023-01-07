package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

public class ConflictException extends RuntimeException{
    public ConflictException(String detail) {
        super(detail);
    }
}
