package io.github.namankhurpia.Exception;

public class MalformedRequestException extends  RuntimeException {

    public MalformedRequestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

