package com.example.course.exceptions;

public class RestControllerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RestControllerNotFoundException(Object id){
        super("Resource not found. Id:"+id);
    }
}
