package com.example.exercises.Exercise4.Controler;

import com.example.exercises.Exercise4.Model.Operation;
import com.example.exercises.Exercise4.Service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculadoraController {

    @Autowired
    CalculadoraService calculadoraService;

    @PostMapping("/sum")
    public Operation sum(@RequestBody Operation operation) {
        return calculadoraService.sum(operation);
    }

    @PostMapping("/minus")
    public Operation minus(@RequestBody Operation operation) {
        return calculadoraService.minus(operation);
    }

    @PostMapping("/product")
    public Operation product(@RequestBody Operation operation) {
        return calculadoraService.product(operation);
    }

    @PostMapping("/division")
    public Operation division(@RequestBody Operation operation) {
        return calculadoraService.division(operation);
    }
}