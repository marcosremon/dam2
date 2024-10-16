package com.example.exercises.Exercise3.Service;

import com.example.exercises.Exercise3.Model.Person;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class SaveUserFileService {
    private final String FILE_NAME = "userFile.txt";

    public Person saveInFile(Person person) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(person.toString());
            return person;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}