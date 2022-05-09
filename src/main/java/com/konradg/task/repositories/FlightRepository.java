package com.konradg.task.repositories;

import com.konradg.task.models.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight,Long> {
    @Query("SELECT flightId FROM Flight WHERE flightNumber=:flightNumber AND departureDate=:departureDate")
    Long findByFlightNumberDate(Long flightNumber, Date departureDate);

    @Query("SELECT flightId FROM Flight WHERE departureAirportIATACode=:departureAirportIATACode AND to_char(departureDate, 'yyyy-mm-dd')=:date")
    List<Long> findByDepartureIATACode(String departureAirportIATACode, Date date);

    @Query("SELECT flightId FROM Flight WHERE arrivalAirportIATACode=:arrivalAirportIATACode AND to_char(departureDate, 'yyyy-mm-dd')=:date")
    List<Long> findByArrivalIATACode(String arrivalAirportIATACode, Date date);

}
