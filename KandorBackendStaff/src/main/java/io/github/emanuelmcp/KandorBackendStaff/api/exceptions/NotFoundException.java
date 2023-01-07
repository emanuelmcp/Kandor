package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String detail) {
        super(detail);
    }
}
