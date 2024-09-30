package Classes;

public class Car {
    String make;
    String color;
    String carLicense;

    public Car() {
    }

    public Car(String make, String color, String carLicense) {
        this.make = make;
        this.color = color;
        this.carLicense = carLicense;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", color='" + color + '\'' +
                ", carLicense='" + carLicense + '\'' +
                '}';
    }
}