package com.sayonara.ThermometerRestAPI.util;

public class SensorNotCreatedException extends RuntimeException {
    public SensorNotCreatedException(String mes) {
        super(mes);
    }
}
