package com.amachi.app.film.advice;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Hidden
public class ValidationErrorResponse {

    private List<Violation> violations = new ArrayList<>();
}
