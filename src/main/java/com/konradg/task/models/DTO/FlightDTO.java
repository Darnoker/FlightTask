package com.konradg.task.models.DTO;

import java.util.Date;

public class FlightDTO {
    private Long flightNumber;
    private Date date ;

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
