package sever.com.serverFacturation.exceptions;

public class InvalidOperationException extends RuntimeException{
    public InvalidOperationException(String message){
        super(message);
    }

    public InvalidOperationException(Throwable cause) {
        super(cause);
    }

}
