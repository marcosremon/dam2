package Practica2;

import java.util.concurrent.Semaphore;

public class Parking {
    private final Semaphore semaphore;

    public Parking(int plazasDisponibles) {
        this.semaphore = new Semaphore(plazasDisponibles);
    }

    public void estacionar(String coche) throws InterruptedException {
        System.out.println(coche + " está intentando estacionar...");
        semaphore.acquire();
        System.out.println(coche + " ha estacionado. Plazas disponibles: " + semaphore.availablePermits());
        Thread.sleep(2000);
    }

    public void salir(String coche) {
        System.out.println(coche + " ha salido del estacionamiento.");
        semaphore.release();
    }
}

