package com.konradg.task.controllers;

import com.konradg.task.models.DTO.WeightDTO;
import com.konradg.task.models.Cargo;
import com.konradg.task.models.DTO.FlightDTO;
import com.konradg.task.services.CargoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping("/getAll")
    public Iterable<Cargo> getAll() {
        return cargoService.findAll();
    }

    @GetMapping("/weight")
    public WeightDTO getWeight(@RequestBody FlightDTO flightDTO) throws Exception {
        return cargoService.getWeights(flightDTO);
    }
}

