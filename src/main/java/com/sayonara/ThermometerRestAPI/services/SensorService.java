package com.sayonara.ThermometerRestAPI.services;

import com.sayonara.ThermometerRestAPI.models.Measurement;
import com.sayonara.ThermometerRestAPI.models.Sensor;
import com.sayonara.ThermometerRestAPI.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public Optional<Sensor> getByName(String name) {
        return sensorRepository.findByName(name);
    }

}
