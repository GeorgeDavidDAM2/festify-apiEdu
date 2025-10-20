package com.GeorgeDavidDAM2.festify_apiEdu.web.advice;

import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.InvalidIdException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidIdException.class)
    ProblemDetail handleInvalidIdException(InvalidIdException ex, HttpServletRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        pd.setTitle("El formato del id no es válido");
        pd.setProperty("path", request.getRequestURI());
        return pd;
    }

    
}