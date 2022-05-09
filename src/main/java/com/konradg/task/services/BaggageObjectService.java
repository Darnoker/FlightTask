package com.konradg.task.services;

import com.konradg.task.models.BaggageObject;
import com.konradg.task.repositories.BaggageObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class BaggageObjectService   {
    private BaggageObjectRepository baggageObjectRepository;

    public BaggageObjectService(BaggageObjectRepository baggageObjectRepository) {
        this.baggageObjectRepository = baggageObjectRepository;
    }

    public Iterable<BaggageObject> findAll() {
        return baggageObjectRepository.findAll();
    }

    public void save(BaggageObject element) {
        baggageObjectRepository.save(element);
    }

    public Iterable<BaggageObject> saveAll(Iterable<BaggageObject> baggageObjects){
        return baggageObjectRepository.saveAll(baggageObjects);
    }
}
