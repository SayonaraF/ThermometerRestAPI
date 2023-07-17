package com.sayonara.ThermometerRestAPI.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sensors", schema = "sensor_data")
@Setter
@Getter
@RequiredArgsConstructor
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @Size(min = 3, max = 30, message = "Size should be from 3 to 30 symbols")
    @NotBlank
    private String name;
}
