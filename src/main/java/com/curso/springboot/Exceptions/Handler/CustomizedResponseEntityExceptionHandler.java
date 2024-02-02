package com.curso.springboot.Exceptions.Handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.curso.springboot.Exceptions.ExceptionResponse;
import com.curso.springboot.Exceptions.UnsuportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllEceptions(Exception e, WebRequest request) {

    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
        request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UnsuportedMathOperationException.class)
  public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception e, WebRequest request) {

    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(),
        request.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
