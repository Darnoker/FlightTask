package com.konradg.task.services;

import com.konradg.task.errorHandling.exceptions.IdNotFoundFlightNumberException;
import com.konradg.task.models.*;
import com.konradg.task.models.DTO.FlightDTO;
import com.konradg.task.models.DTO.WeightDTO;
import com.konradg.task.repositories.CargoRepository;
import com.konradg.task.repositories.FlightRepository;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoService {
    private CargoRepository cargoRepository;
    private FlightRepository flightRepository;

    public CargoService(CargoRepository cargoRepository, FlightRepository flightRepository) {
        this.cargoRepository = cargoRepository;
        this.flightRepository = flightRepository;
    }

    public WeightDTO getWeights(FlightDTO flightDTO) {
        Long id = flightRepository.findByFlightNumberDate(flightDTO.getFlightNumber(), flightDTO.getDate());
        if(id == null) {
            throw new IdNotFoundFlightNumberException("Id not found for flight number "+ flightDTO.getFlightNumber() + " and " +
                    "date " + flightDTO.getDate(), flightDTO.getFlightNumber(), flightDTO.getDate());
        }
        Optional<Cargo> cargo = cargoRepository.findById(id);
        Long baggageWeight = 0L;
        Long cargoWeight = 0L;
        Long totalWeight = 0L;
        if(cargo.isPresent()) {
            for (BaggageObject element : cargo.get().getBaggage()) {
                baggageWeight += element.getWeight();
            }
            for (CargoObject element : cargo.get().getCargo()) {
                cargoWeight += element.getWeight();
            }
            totalWeight = baggageWeight + cargoWeight;

        }
        return new WeightDTO(baggageWeight, cargoWeight, totalWeight);
    }
    public Iterable<Cargo> findAll() {
        return cargoRepository.findAll();
    }
    public void saveAll(Iterable<Cargo> cargos) {
        cargoRepository.saveAll(cargos);
    }
}
