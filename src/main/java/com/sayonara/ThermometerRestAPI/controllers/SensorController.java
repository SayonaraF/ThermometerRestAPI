package com.sayonara.ThermometerRestAPI.controllers;

import com.sayonara.ThermometerRestAPI.dto.SensorDTO;
import com.sayonara.ThermometerRestAPI.models.Sensor;
import com.sayonara.ThermometerRestAPI.services.SensorService;
import com.sayonara.ThermometerRestAPI.util.ErrorResponse;
import com.sayonara.ThermometerRestAPI.util.SensorNotCreatedException;
import com.sayonara.ThermometerRestAPI.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorValidator sensorValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, SensorValidator sensorValidator, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid SensorDTO sensor, BindingResult bindingResult) {
        sensorValidator.validate(convertToSensor(sensor), bindingResult);
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors) {
                stringBuilder.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
            }

            throw new SensorNotCreatedException(stringBuilder.toString());
        }

        sensorService.save(convertToSensor(sensor));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlerException(SensorNotCreatedException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}
