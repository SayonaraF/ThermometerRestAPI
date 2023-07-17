package com.sayonara.ThermometerRestAPI.services;

import com.sayonara.ThermometerRestAPI.models.Measurement;
import com.sayonara.ThermometerRestAPI.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorService sensorService;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        measurement.setSensor(sensorService.getByName(measurement.getSensor().getName()).get());
        measurement.setCreatedAt(LocalDateTime.now());

        measurementRepository.save(measurement);
    }

    public long getRainyDaysCount() {
        return measurementRepository.countAllByRainingIsTrue();
    }
}
