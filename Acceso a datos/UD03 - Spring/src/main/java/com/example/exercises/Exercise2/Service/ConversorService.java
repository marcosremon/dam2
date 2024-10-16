package com.example.exercises.Exercise2.Service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {
    private final double CONVERTER_KM_MILES = 1.60934;

    public double kmToMiles(double miles) {
        return miles * CONVERTER_KM_MILES;
    }

    public double milesToKm(double km) {
        return km * CONVERTER_KM_MILES;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }
}