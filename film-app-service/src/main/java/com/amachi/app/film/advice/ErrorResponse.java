package com.amachi.app.film.advice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {
    //General error message about nature of error
    private String message;
    //Specific errors in API request processing
    private List<String> details;

    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

}
