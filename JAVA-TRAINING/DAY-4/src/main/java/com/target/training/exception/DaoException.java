package com.target.training.exception;

public class DaoException extends Exception{
    public DaoException(String message) {
        super(message);
    }

    public DaoException() {
        super();
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
