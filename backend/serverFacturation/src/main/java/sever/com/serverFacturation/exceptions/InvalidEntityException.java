package sever.com.serverFacturation.exceptions;

public class InvalidEntityException extends RuntimeException{
    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause){
        super(message,cause);
    }

}
