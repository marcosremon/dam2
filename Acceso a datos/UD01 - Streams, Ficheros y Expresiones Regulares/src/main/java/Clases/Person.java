package Clases;

import java.util.List;

public class Person {
    String name;
    String dni;
    List<Car> cars;

    public Person(String name, String dni, List<Car> cars) {
        this.name = name;
        this.dni = dni;
        this.cars = cars;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", cars=" + cars +
                '}';
    }
}
