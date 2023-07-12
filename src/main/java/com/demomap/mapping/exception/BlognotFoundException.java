package com.demomap.mapping.exception;

import org.springframework.http.HttpStatus;

public class BlognotFoundException extends RuntimeException {
    public BlognotFoundException(String message, HttpStatus status) {
        super(message);

    }
}
