package br.com.dio.klinica.exception;

public class UniqueConstraintException extends RuntimeException{

    public UniqueConstraintException(String message) {
        super(message);
    }
    
}
