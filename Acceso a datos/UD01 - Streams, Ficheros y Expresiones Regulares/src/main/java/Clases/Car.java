package Clases;

public class Car {
    String marca;
    String color;
    String matricula;

    public Car() {
    }

    public Car(String marca, String color, String matricula) {
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
