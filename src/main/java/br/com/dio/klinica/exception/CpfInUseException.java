package br.com.dio.klinica.exception;

public class CpfInUseException extends RuntimeException {
    public CpfInUseException(String message) {
        super(message);
    }
}
