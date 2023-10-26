package com.api.educationalsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Result {
    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private Map<String, Object> data;

    public Result(String message, Map<String, Object> data) {
        this.message = message;
        this.data = data;
    }

    public static Result of(String message, Map<String, Object> data) {
        return new Result(message, data);
    }
}
