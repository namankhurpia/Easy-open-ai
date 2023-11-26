package io.github.namankhurpia.Exception;

public class InvalidSizeException extends RuntimeException{

    public InvalidSizeException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
