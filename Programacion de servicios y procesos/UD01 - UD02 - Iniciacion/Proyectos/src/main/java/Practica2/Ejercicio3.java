package Practica2;

import Practica2.Models.Coche;
import Practica2.Models.Parking;

public class Ejercicio3 {
    public static void main(String[] args) {
        Parking parking = new Parking(3);

        Coche coche1 = new Coche(parking, "Coche 1");
        Coche coche2 = new Coche(parking, "Coche 2");
        Coche coche3 = new Coche(parking, "Coche 3");
        Coche coche4 = new Coche(parking, "Coche 4");
        Coche coche5 = new Coche(parking, "Coche 5");

        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        coche5.start();

        System.out.println("Simulación de estacionamiento finalizada.");
    }
}