package io.github.emanuelmcp.KandorBackendStaff.api.exceptions;

public class MalformedHeaderException extends BadRequestException {
    public MalformedHeaderException(String detail) {
        super(detail);
    }
}
