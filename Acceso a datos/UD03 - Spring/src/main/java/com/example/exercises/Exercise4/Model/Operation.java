package com.example.exercises.Exercise4.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Operation {

    private double number1;
    private double number2;
    private double operationResult;
}