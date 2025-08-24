package com.bmt.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String status; // SUCCESS / FAILURE
    private String message;
    private T data; // Generic
    private Object error;
    private String path;
    private LocalDateTime timestamp;

    public ApiResponse(String status, String message, T data, Object error, String path) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.error = error;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("SUCCESS", message, data, null, null);
    }

    public static <T> ApiResponse<T> failure(String message, Object error, String path) {
        return new ApiResponse<>("FAILURE", message, null, error, path);
    }
}