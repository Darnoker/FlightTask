package com.konradg.task.controllers;

import com.konradg.task.models.CargoObject;
import com.konradg.task.services.CargoObjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo/cargoObjects")
public class CargoObjectController {
    private CargoObjectService cargoObjectService;

    public CargoObjectController(CargoObjectService cargoObjectService) {
        this.cargoObjectService = cargoObjectService;
    }
    @GetMapping("/getAll")
    public Iterable<CargoObject> findAll() {
        return cargoObjectService.findAll();
    }
}
