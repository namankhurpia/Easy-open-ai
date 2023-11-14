package com.namankhurpia.openai.openaibackend.Pojo;

import lombok.Data;

@Data
public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

}
