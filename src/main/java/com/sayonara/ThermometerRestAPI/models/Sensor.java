package com.sayonara.ThermometerRestAPI.models;

import lombok.*;

import javax.persistence.*;

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
    private String name;
}
