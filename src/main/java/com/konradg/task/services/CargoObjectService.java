package com.konradg.task.services;

import com.konradg.task.models.CargoObject;
import com.konradg.task.repositories.CargoObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class CargoObjectService {
    private CargoObjectRepository cargoObjectRepository;

    public CargoObjectService(CargoObjectRepository cargoElementRepository) {
        this.cargoObjectRepository = cargoElementRepository;
    }

    public Iterable<CargoObject> findAll() {
        return cargoObjectRepository.findAll();
    }

    public void save(CargoObject cargoObject) {
        cargoObjectRepository.save(cargoObject);
    }

    public Iterable<CargoObject> saveAll(Iterable<CargoObject> cargoObjects){
        return cargoObjectRepository.saveAll(cargoObjects);
    }
}
