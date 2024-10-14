package com.example.demo.controller;

import com.example.demo.Modelo.Pass;
import com.example.demo.service.PasswordService;
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