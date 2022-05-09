package com.konradg.task.models.DTO;

import java.sql.Date;

public class AirportDateDTO {
    private String airportCode;
    private Date date;

    public AirportDateDTO() {}

    public AirportDateDTO(String airportCode, Date date) {
        this.airportCode = airportCode;
        this.date = date;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
