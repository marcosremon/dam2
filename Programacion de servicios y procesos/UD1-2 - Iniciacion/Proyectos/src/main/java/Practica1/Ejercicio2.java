package Practica1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {
        long programSeconds = 32;
        long totalSum = 0;
        Thread th = new Thread();
        String importantInfo[] = { "Programas", "Procesos", "Servicios", "Hilos" };
        List<String> message = new ArrayList<>(Arrays.asList("esperando...", "Todavía esperando...",
                "Todavía esperando...", "Cansado de esperar"));

        th.start();
        for (int i = 0; i < 4; i++) {
            long startTime = System.currentTimeMillis();
            System.out.println(importantInfo[i]);
            extractMessages(message, th);
            totalSum += (System.currentTimeMillis() - startTime);
            programSeconds = programSeconds*1000;
            if (totalSum >= programSeconds) {
                for (int j = i+1; j < importantInfo.length; j++) {
                    System.out.println(importantInfo[j]);
                }
                break;
            }
        }
    }

    private static void extractMessages(List<String> message, Thread th) throws InterruptedException {
        int CONSTANT_SECONDS = 1;
        for (int i = 0; i < 4; i++) {
            th.sleep(CONSTANT_SECONDS * 1000);
            System.out.println(message.get(i));
        }
        System.out.println("---------------------");
    }
}