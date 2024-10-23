package Practica1.Ejercicio4;

import Methods.Methods;
import Practica1.Ejercicio4.Modelo.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Path inputPath = Paths.get(Methods.importFiles("employees.txt"));
        Path outputPath = Paths.get(Methods.importFiles("filtred_emplyees.txt"));

        try (BufferedWriter bw = Files.newBufferedWriter(outputPath)) {
            List<Employee> employees = Files.readAllLines(inputPath).stream().skip(1).map(line -> {
                String[] parts = line.split(",");
                String completeName = parts[0];
                String[] completeNameParts = completeName.split("\s");

                String name = completeNameParts[0];
                String lastName = completeNameParts[1];
                int age = Integer.parseInt(parts[1]);
                double salary = Double.parseDouble(parts[2]);
                return new Employee(name, lastName, age, salary);
             }).toList();

            List<Employee> filterEmployees = employees.stream().filter(employee -> employee.getAge() >= 20 &&
                            employee.getAge() <= 40 && employee.getSalary() >= 50000.0)
                    .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();

            for (Employee employee : filterEmployees) {
                System.out.println(employee);
                bw.write(employee.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}