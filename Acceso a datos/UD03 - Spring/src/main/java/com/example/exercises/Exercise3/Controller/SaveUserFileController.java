package com.example.exercises.Exercise3.Controller;

import com.example.exercises.Exercise3.Model.Person;
import com.example.exercises.Exercise3.Service.SaveUserFileService;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveUserFileController {
    @Autowired
    SaveUserFileService saveUserFileService;

    @PostMapping("/saveUser")
    public Person saveUser(@RequestBody Person person) {
        return saveUserFileService.saveInFile(person);
    }
}