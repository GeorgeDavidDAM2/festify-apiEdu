package com.GeorgeDavidDAM2.festify_apiEdu.web.advice;

import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.ArtistNotFoundException;
import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.ConflictException;
import com.GeorgeDavidDAM2.festify_apiEdu.utils.exception.InvalidIdException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Conflict;

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

    @ExceptionHandler(ArtistNotFoundException.class)
    ProblemDetail artistNotFoundException(ArtistNotFoundException ex, HttpServletRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        pd.setTitle("Artista no encontrado");
        pd.setProperty("path", request.getRequestURI());
        return pd;
    }

    @ExceptionHandler(ConflictException.class)
    ProblemDetail conflictException(ConflictException ex, HttpServletRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );
        pd.setTitle("Conflicto de artista");
        pd.setProperty("path", request.getRequestURI());
        return pd;
    }


    
}