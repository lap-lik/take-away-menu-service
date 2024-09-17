package ru.kokhno.menuservice.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class MenuServiceException extends RuntimeException {

    private final String message;
    private final HttpStatus status;
}
