package com.amachi.app.film.common.exception;

public class NoParametersProvidedException extends Exception {
    public static final String ERROR_MESSAGE = "No Parameters Provided, You must provide at least ONE valid parameter";

    public NoParametersProvidedException() {
        super(ERROR_MESSAGE);
    }
}
