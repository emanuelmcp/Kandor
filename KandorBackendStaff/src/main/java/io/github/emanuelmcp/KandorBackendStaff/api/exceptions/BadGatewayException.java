package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

public class BadGatewayException extends RuntimeException{
    public BadGatewayException(String detail) {
        super(detail);
    }

}
