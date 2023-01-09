package com.rds.barcodegen.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class DocumentServiceException extends RuntimeException {
    String message;

    public DocumentServiceException(String message) {
        super(message);
        this.message = message;
    }

    public DocumentServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public DocumentServiceException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public DocumentServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message;
    }
}
