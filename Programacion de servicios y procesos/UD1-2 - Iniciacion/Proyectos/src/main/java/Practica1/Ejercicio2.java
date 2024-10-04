package Practica1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {
        long maxWaitTime = 320000000 * 1000;
        long startTime = System.currentTimeMillis();

        Thread th = new Thread(() -> {
            String[] messages = {"Programas", "Procesos", "Servicios", "Hilos"};
            try {
                for (int i = 0; i < messages.length; i++) {
                    System.out.println("hilo: " + Thread.currentThread().getName() + ". " + messages[i]);
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                System.out.println("hilo: " + Thread.currentThread().getName() + " fue interrumpido. Terminando " +
                        "rapido.");
                for (int i = 1; i < messages.length; i++) {
                    System.out.println("hilo: " + Thread.currentThread().getName() + ". " + messages[i]);
                }
            } finally {
                System.out.println("hilo: " + Thread.currentThread().getName() + ". *** finalizado ***");
            }
        });
        th.start();

        System.out.println("hilo: main. Tiempo de espera: " + (maxWaitTime / 1000) + "s");
        while (th.isAlive() && (System.currentTimeMillis() - startTime) < maxWaitTime) {
            System.out.println("Hilo: main. Todavía esperando...");
            Thread.sleep(1000);
        }

        if (th.isAlive()) {
            System.out.println("hilo: main. Cansado de esperar. Interrumpiendo el hilo " + th.getName());
            th.interrupt();
        }
        th.join();

        long endTime = System.currentTimeMillis();
        System.out.println("hilo: main. *** Finalizado. Tiempo de ejecución: " + (endTime - startTime) / 1000 +
                "s. ***");
    }
}