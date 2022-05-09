package com.konradg.task.errorHandling;

import com.konradg.task.errorHandling.exceptions.IATANotFound;
import com.konradg.task.errorHandling.exceptions.IdNotFoundFlightNumberException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }
    @ExceptionHandler(value = {IdNotFoundFlightNumberException.class})
    protected ResponseEntity<Object> handleIdNotFound(IdNotFoundFlightNumberException ex) {
        String error = "Id not found for flight number: " + ex.getFlightNumber() + " and date "+ ex.getDate();
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
    }

    @ExceptionHandler(value = {IATANotFound.class})
    protected ResponseEntity<Object> handleIdNotFound(IATANotFound ex) {
        String error = "Couldn't find departures or arrivals for IATA code: " + ex.getIATACode() +
                " and date: " + ex.getDate();
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
