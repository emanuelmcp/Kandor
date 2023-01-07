package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String detail) {
        super(detail);
    }
}
