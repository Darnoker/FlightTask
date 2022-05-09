package com.konradg.task.controllers;

import com.konradg.task.models.BaggageObject;
import com.konradg.task.services.BaggageObjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo/baggageObjects")
public class BaggageObjectController {
    private BaggageObjectService baggageObjectService;

    public BaggageObjectController(BaggageObjectService baggageObjectService) {
        this.baggageObjectService = baggageObjectService;
    }

    @GetMapping("/getAll")
    public Iterable<BaggageObject> getAll() {
        return baggageObjectService.findAll();
    }

}
