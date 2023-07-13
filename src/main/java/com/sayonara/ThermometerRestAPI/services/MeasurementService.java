package com.sayonara.ThermometerRestAPI.services;

import com.sayonara.ThermometerRestAPI.models.Measurement;
import com.sayonara.ThermometerRestAPI.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    @Transactional
    public void save(Measurement measurement) {
        measurementRepository.save(measurement);
    }
}
