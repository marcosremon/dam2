package com.example.exercises.Exercise1.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pass {
    String password;

    public Pass(String password) {
        this.password = password;
    }

    public Pass() {
    }
}