package com.sayonara.ThermometerRestAPI.controllers;

import com.sayonara.ThermometerRestAPI.models.Measurement;
import com.sayonara.ThermometerRestAPI.services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<Measurement> getMeasurements() {
        return measurementService.getMeasurements();
    }

    @GetMapping("/rainyDaysCount")
    public long getRainyDaysCount() {
        return measurementService.getRainyDaysCount();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> newMeasurement(@RequestBody Measurement measurement) {
        measurementService.save(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
