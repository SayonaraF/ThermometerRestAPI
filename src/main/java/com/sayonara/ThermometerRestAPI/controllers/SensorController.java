package com.sayonara.ThermometerRestAPI.controllers;

import com.sayonara.ThermometerRestAPI.models.Sensor;
import com.sayonara.ThermometerRestAPI.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public List<Sensor> getSensors() {
        return sensorService.getSensors();
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> register(@RequestBody Sensor sensor) {
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
