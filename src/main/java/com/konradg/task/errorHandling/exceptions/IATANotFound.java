package com.konradg.task.errorHandling.exceptions;

import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.sql.Date;

public class IATANotFound extends InvalidDataAccessApiUsageException {
    private Date date;
    private String IATACode;

    public IATANotFound(String msg, String IATACode, Date date) {
        super(msg);
        this.IATACode = IATACode;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }
}
