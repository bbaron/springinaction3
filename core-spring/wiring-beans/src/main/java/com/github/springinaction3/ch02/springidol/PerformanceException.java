package com.github.springinaction3.ch02.springidol;

public class PerformanceException extends Exception {

    public PerformanceException() {
        super();
    }

    public PerformanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PerformanceException(String message) {
        super(message);
    }

    public PerformanceException(Throwable cause) {
        super(cause);
    }

}
