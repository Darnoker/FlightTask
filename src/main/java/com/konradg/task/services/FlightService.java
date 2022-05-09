package com.konradg.task.services;

import com.konradg.task.errorHandling.exceptions.IATANotFound;
import com.konradg.task.models.*;
import com.konradg.task.models.DTO.AirportDateDTO;
import com.konradg.task.models.DTO.AirportInfoDTO;
import com.konradg.task.repositories.CargoRepository;
import com.konradg.task.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private FlightRepository flightRepository;
    private CargoRepository cargoRepository;

    public FlightService(FlightRepository flightRepository, CargoRepository cargoRepository) {
        this.flightRepository = flightRepository;
        this.cargoRepository = cargoRepository;
    }

    public Iterable<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    public Iterable<Flight> saveAll(Iterable<Flight> flights) {
        return flightRepository.saveAll(flights);
    }

    public AirportInfoDTO flightByIATACode(AirportDateDTO airportDTO) {
        List<Long> departures = flightRepository.findByDepartureIATACode(airportDTO.getAirportCode(), airportDTO.getDate());
        List<Long> arrivals = flightRepository.findByArrivalIATACode(airportDTO.getAirportCode(), airportDTO.getDate());
        if(departures.size()==0 && arrivals.size() == 0) {
            throw new IATANotFound("Couldn't find departures or arrivals for IATA code: " + airportDTO.getAirportCode() +
                    " and date: " + airportDTO.getDate(), airportDTO.getAirportCode(), airportDTO.getDate());
        }

        Long countDepartures = (long) departures.size();
        Long countArrivals = (long) arrivals.size();
        Long countBaggageDeparture = 0L;
        Long countBaggageArrival = 0L;

        for (Long flightId : departures) {
            Optional<Cargo> cargo = cargoRepository.findById(flightId);
            if (cargo.isPresent()) {
                List<BaggageObject> baggage = cargo.get().getBaggage();
                System.out.println(baggage.get(0).getWeight());
                countBaggageDeparture += baggage.size();
            }
        }
        for (Long arrival : arrivals) {
            System.out.println(arrival);
            Optional<Cargo> cargo = cargoRepository.findById(arrival);
            if (cargo.isPresent()) {
                List<BaggageObject> baggage = cargo.get().getBaggage();
                System.out.println(baggage.size());
                countBaggageArrival += baggage.size();
            }
        }
        return new AirportInfoDTO(countDepartures, countArrivals, countBaggageDeparture, countBaggageArrival);
    }
}
