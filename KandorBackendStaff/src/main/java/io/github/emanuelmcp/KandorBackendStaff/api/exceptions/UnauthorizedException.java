package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String detail) {
        super(detail);
    }
}
