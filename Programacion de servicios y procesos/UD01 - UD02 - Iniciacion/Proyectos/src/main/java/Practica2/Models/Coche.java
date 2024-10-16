package Practica2.Models;

public class Coche extends Thread {
    private final Parking parking;
    private final String nombre;

    public Coche(Parking parking, String nombre) {
        this.parking = parking;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            parking.estacionar(nombre);
            parking.salir(nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

