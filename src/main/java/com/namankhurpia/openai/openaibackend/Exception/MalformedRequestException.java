package com.namankhurpia.openai.openaibackend.Exception;

public class MalformedRequestException extends  RuntimeException {

    public MalformedRequestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

