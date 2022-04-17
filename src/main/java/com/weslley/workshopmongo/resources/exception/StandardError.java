package com.weslley.workshopmongo.resources.exception;

import java.io.Serializable;

/**
 * Retornar erros estruturados
 */
public class StandardError implements Serializable {

    private static final long serialVersionUUID = 1L;

    // Attributes

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    /**
     * Construtor
     * @param timestamp
     * @param status
     * @param error
     * @param message
     * @param path
     */
    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters and Setters

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
