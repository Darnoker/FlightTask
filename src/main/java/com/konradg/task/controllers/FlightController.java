package com.konradg.task.controllers;

import com.konradg.task.models.DTO.AirportDateDTO;
import com.konradg.task.models.DTO.AirportInfoDTO;
import com.konradg.task.models.Flight;
import com.konradg.task.services.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/getAll")
    public Iterable<Flight> getAllFlights() {
        return flightService.findAllFlights();
    }

    @PostMapping("/save")
    public Flight saveFlight(Flight flight) {
        return flightService.save( flight);
    }

    @GetMapping("/airport")
    public AirportInfoDTO info(@RequestBody AirportDateDTO airportDTO) {
        return flightService.flightByIATACode(airportDTO);
    }

}
