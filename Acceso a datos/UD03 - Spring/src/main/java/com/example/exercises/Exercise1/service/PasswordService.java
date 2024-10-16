package com.example.exercises.Exercise1.service;

import com.example.exercises.Exercise1.Model.Pass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordService {
    @GetMapping("/generaLetras")
    public Pass generaLetras() {
        StringBuilder sb = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        Random random = new Random();
        Pass pass;

        try {
            List<Character> characters = new ArrayList<>();
            for (char i = 'a'; i <= 'z'; i++) {
                characters.add(Character.toUpperCase(i));
                characters.add(i);
            }

            for (int i = 0; i < 8; i++) {
                char character = characters.get(random.nextInt(0, characters.size()));
                sb.append(character);
            }

            String json = objectMapper.writeValueAsString(String.valueOf(sb));
            pass = new Pass(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return pass;
    }
}