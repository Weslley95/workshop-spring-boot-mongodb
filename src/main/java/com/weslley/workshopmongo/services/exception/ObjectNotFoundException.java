package com.weslley.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Sobrepor construtor
     * @param msg
     */
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
