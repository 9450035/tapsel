package ir.test.tapsel.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    ProblemDetail handleConstraintViolationException(ConstraintViolationException e) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, "Request validation failed");
        problemDetail.setTitle("Validation Failed");
        return problemDetail;
    }
}
