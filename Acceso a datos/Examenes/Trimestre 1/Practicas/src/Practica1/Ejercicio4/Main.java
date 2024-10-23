package Practica1.Ejercicio4;

import Practica1.Ejercicio4.Modelo.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "Files/employees.txt";
        String filtredFile = "Files/filtred_emplyees.txt";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(filtredFile))){
            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String nameAndLastName = parts[0];
                String[] nameAndLastNameParts = nameAndLastName.split("\s");
                String name = nameAndLastNameParts[0];
                String lastname = nameAndLastNameParts[1];
                int age = Integer.parseInt(parts[1]);
                double salary = Double.parseDouble(parts[2]);
                employees.add(new Employee(name, lastname, age, salary));
            }

            System.out.println("primer filtro");
            List<Employee> firstPoint = employees.stream().filter(employee -> employee.getAge() >= 20 &&
                            employee.getAge() <= 40 && employee.getSalary() >= 50000.0)
                    .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();

            firstPoint.forEach(i -> System.out.println(i.toString()));
            for (Employee i : firstPoint) {
                System.out.println(i.toString());
                bw.write(i.toString());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}