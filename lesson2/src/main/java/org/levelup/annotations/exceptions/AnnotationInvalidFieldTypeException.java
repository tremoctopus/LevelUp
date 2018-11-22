package org.levelup.annotations.exceptions;

public class AnnotationInvalidFieldTypeException extends IllegalArgumentException {

    public AnnotationInvalidFieldTypeException(String message) {
        super(message);
    }

    public AnnotationInvalidFieldTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
