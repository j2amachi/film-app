package com.amachi.app.film.advice;

import com.amachi.app.film.common.exception.FilmException;
import com.amachi.app.film.common.exception.NoParametersProvidedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {
    private static final String ERROR_MESSAGE = "errorMensaje";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        e.getBindingResult().getFieldErrors().forEach(err -> error.getViolations().add(
                new Violation(err.getField(), err.getDefaultMessage()
                )));
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FilmException.class)
    @ResponseBody
    ValidationErrorResponse handleBusinessException(FilmException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation(ERROR_MESSAGE, e.getMessage()));
        return error;
    }

    @ExceptionHandler(NoParametersProvidedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleNoParametersProvidedException(NoParametersProvidedException ex) {
        log.error("No Parameters Provided exception occurred: {}", ex.getMessage());
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation(ERROR_MESSAGE, ex.getMessage()));
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ValidationErrorResponse notValid(RuntimeException ex, HttpServletRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation(ERROR_MESSAGE, ex.getMessage()));
        return error;
    }
}
