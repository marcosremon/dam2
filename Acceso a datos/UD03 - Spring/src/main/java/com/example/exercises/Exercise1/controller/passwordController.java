package com.example.exercises.Exercise1.controller;

import com.example.exercises.Exercise1.Model.Pass;
import com.example.exercises.Exercise1.service.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class passwordController {
    PasswordService passwordService = new PasswordService();
    @GetMapping("/generaLetras")
    public Pass generaLetras() {
        return passwordService.generaLetras();
    }
}