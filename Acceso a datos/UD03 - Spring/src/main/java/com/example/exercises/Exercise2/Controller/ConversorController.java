package com.example.exercises.Exercise2.Controller;

import com.example.exercises.Exercise2.Service.ConversorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversorController {
    @Autowired
    ConversorService serviceConversor;

    @GetMapping("/kmToMiles/{km}")
    public Map<String, Double> kmConverter(@PathVariable double km) {
        Map<String, Double> returnMap = new HashMap<>();
        double miles = serviceConversor.kmToMiles(km);
        returnMap.put("la conversion a millas es", miles);
        return returnMap;
    }

    @GetMapping("/milesToKm/{miles}")
    public Map<String, Double> milesConverter(@PathVariable double miles) {
        Map<String, Double> returnMap = new HashMap<>();
        double km = serviceConversor.kmToMiles(miles);
        returnMap.put("la conversion a km es", km);
        return returnMap;
    }

    @GetMapping("/celsiusToFahrenheit/{celsius}")
    public Map<String, Double> celsiusConverser(@PathVariable double celsius) {
        Map<String, Double> returnMap = new HashMap<>();
        double fahrenheit = serviceConversor.celsiusToFahrenheit(celsius);
        returnMap.put("la conversion a fahrenheit es", fahrenheit);
        return returnMap;
    }

    @GetMapping("/fahrenheitToCelsius/{fahrenheit}")
    public Map<String, Double> fahrenheitConverser(@PathVariable double fahrenheit) {
        Map<String, Double> returnMap = new HashMap<>();
        double celsius = serviceConversor.fahrenheitToCelsius(fahrenheit);
        returnMap.put("la conversion a celsius es", celsius);
        return returnMap;
    }
}