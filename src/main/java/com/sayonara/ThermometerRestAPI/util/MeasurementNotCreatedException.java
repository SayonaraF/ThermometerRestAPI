package com.sayonara.ThermometerRestAPI.util;

public class MeasurementNotCreatedException extends RuntimeException {
    public MeasurementNotCreatedException(String mes) {
        super(mes);
    }
}
