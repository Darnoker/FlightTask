package com.konradg.task.errorHandling.exceptions;

import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.Date;

public class IdNotFoundFlightNumberException extends InvalidDataAccessApiUsageException {
    private Long flightNumber;
    private Date date;

    public IdNotFoundFlightNumberException(String msg, Long flightNumber, Date date) {
        super(msg);
        this.flightNumber = flightNumber;
        this.date = date;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public Date getDate() {
        return date;
    }
}
