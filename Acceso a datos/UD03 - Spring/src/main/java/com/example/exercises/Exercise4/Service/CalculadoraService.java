package com.example.exercises.Exercise4.Service;

import com.example.exercises.Exercise4.Model.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public Operation sum(Operation operation) {
        operation.setOperationResult(operation.getNumber1() + operation.getNumber2());
        return operation;
    }

    public Operation minus(Operation operation) {
        operation.setOperationResult(operation.getNumber1() - operation.getNumber2());
        return operation;
    }

    public Operation product(Operation operation) {
        operation.setOperationResult(operation.getNumber1() * operation.getNumber2());
        return operation;
    }

    public Operation division(Operation operation) {
        operation.setOperationResult(operation.getNumber1() / operation.getNumber2());
        return operation;
    }
}