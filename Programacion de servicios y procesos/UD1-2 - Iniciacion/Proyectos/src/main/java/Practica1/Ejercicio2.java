package Practica1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {
        long maxWaitTime = 2 * 1000;
        long programDuration = 16 * 1000;
        long startTime = System.currentTimeMillis();

        Thread childThread = new Thread(() -> {
            String[] messages = { "Programas", "Procesos", "Servicios", "Hilos" };
            try {
                for (int i = 0; i < messages.length; i++) {
                    System.out.println("Hilo: " + Thread.currentThread().getName() + ". " + messages[i]);
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                System.out.println("Hilo: " + Thread.currentThread().getName() + " fue interrumpido. Terminando " +
                        "rápido.");
                for (int i = 1; i < messages.length; i++) {
                    System.out.println("Hilo: " + Thread.currentThread().getName() + ". " + messages[i]);
                }
            } finally {
                System.out.println("Hilo: " + Thread.currentThread().getName() + ". *** Finalizado ***");
            }
        });
        childThread.start();

        System.out.println("Hilo: main. Tiempo de espera: " + (maxWaitTime / 1000) + "s");
        while (childThread.isAlive() && (System.currentTimeMillis() - startTime) < maxWaitTime) {
            System.out.println("Hilo: main. Esperando a que el hilo " + childThread.getName() + " termine");
            Thread.sleep(1000);
        }

        if (childThread.isAlive()) {
            System.out.println("Hilo: main. Cansado de esperar. Interrumpiendo el hilo " + childThread.getName());
            childThread.interrupt();
        }
        childThread.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Hilo: main. *** Finalizado. Tiempo de ejecución: " + (endTime - startTime) / 1000 +
                "s ***");
    }
}