package com.sayonara.ThermometerRestAPI.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "sensors_measurements", schema = "sensor_data")
@Getter
@Setter
@RequiredArgsConstructor
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @Min(value = -100, message = "Cannot be less than -100")
    @Max(value = 100, message = "Cannot be more than 100")
    @NotNull(message = "Value cant be Null")
    private double value;

    @Column(name = "raining")
    @NotNull(message = "Cannot be Null")
    private boolean raining;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;
}
