package Practica2;

import java.util.random.RandomGenerator;

public class Ejercicio1 {
    public static final int FINAL_TIMER = 5;
    public static void main(String[] args) throws InterruptedException {
        SecondThread secondThread = new SecondThread();
        ThreeThread threeThread = new ThreeThread();
        Thread temperatureThread = new Thread(secondThread);
        Thread humidityThread = new Thread(threeThread);

        temperatureThread.start();
        humidityThread.start();
        for (int i = 0; i < FINAL_TIMER; i++) {
            Thread.sleep(1000);
            if (!temperatureThread.isAlive() && !humidityThread.isAlive()) {
                break;
            }
        }
        temperatureThread.interrupt();
        humidityThread.interrupt();
    }

    static class SecondThread implements Runnable {
        @Override
        public void run() {
            int conuter = 0;
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(5000);
                    long randomTemperature = RandomGenerator.getDefault().nextLong(5, 35);
                    System.out.println(Thread.currentThread().getName() + " Sensor de temperatura " + randomTemperature + "º");
                    conuter++;
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " sensor de temperatura interrumpido");
                    break;
                }
            }
            System.out.println("el sensor de temperatura se imprimio: " + conuter + " segundos");
        }
    }

    static class ThreeThread implements Runnable {
        @Override
        public void run() {
            int conuter = 0;
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(3000);
                    long randomHumidity = RandomGenerator.getDefault().nextLong(30, 70);
                    System.out.println(Thread.currentThread().getName() + " Sensor de humedad " + randomHumidity + "%");
                    conuter++;
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " sensor de humedad interrumpido");
                    break;
                }
            }
            System.out.println("el sensor de humedad se imprimio: " + conuter + " segundos");
        }
    }
}
