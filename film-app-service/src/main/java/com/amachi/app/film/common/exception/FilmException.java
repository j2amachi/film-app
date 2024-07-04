package com.amachi.app.film.common.exception;

import com.amachi.app.film.common.util.ErrorEnum;
import lombok.Getter;

@Getter
public class FilmException extends RuntimeException {
    private final ErrorEnum errorEnum;

    public FilmException() {
        this(ErrorEnum.UNHANDLED_ERROR, "Aucun message pour cette exception");
    }

    public FilmException(final Exception e) {
        this(ErrorEnum.UNHANDLED_ERROR, e);
    }

    public FilmException(ErrorEnum errorEnum, Exception e) {
        super(String.format(errorEnum.getMessage(), e));
        this.errorEnum = errorEnum;
    }


    public FilmException(ErrorEnum errorEnum, Object... args) {
        super(String.format(errorEnum.getMessage(), args));
        this.errorEnum = errorEnum;
    }
}
