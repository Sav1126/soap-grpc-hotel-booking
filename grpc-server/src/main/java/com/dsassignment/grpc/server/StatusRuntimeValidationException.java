package com.dsassignment.grpc.server;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;

public class StatusRuntimeValidationException extends RuntimeException {

    private final Status status;

    public StatusRuntimeValidationException(Status status, String message) {
        super(message);
        this.status = status;
    }

    public StatusRuntimeException toStatusException() {
        return status.withDescription(getMessage()).asRuntimeException();
    }
}