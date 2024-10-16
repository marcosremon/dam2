package com.example.exercises.Exercise3.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    String name;
    String lastName;
}