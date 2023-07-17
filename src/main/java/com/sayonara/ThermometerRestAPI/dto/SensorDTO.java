package com.sayonara.ThermometerRestAPI.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class SensorDTO {
    @Column(name = "name")
    @Size(min = 3, max = 30, message = "Size should be from 3 to 30 symbols")
    @NotBlank
    private String name;
}
