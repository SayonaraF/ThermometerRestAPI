package com.sayonara.ThermometerRestAPI.repositories;

import com.sayonara.ThermometerRestAPI.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    long countAllByRainingIsTrue();
}
