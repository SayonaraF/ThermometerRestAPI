package com.sayonara.ThermometerRestAPI.dto;

import com.sayonara.ThermometerRestAPI.models.Sensor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class MeasurementDTO {
    @Min(value = -100, message = "Cannot be less than -100")
    @Max(value = 100, message = "Cannot be more than 100")
    @NotNull(message = "Value cant be Null")
    private double value;

    @NotNull(message = "Cannot be Null")
    private boolean raining;

    private Sensor sensor;
}
