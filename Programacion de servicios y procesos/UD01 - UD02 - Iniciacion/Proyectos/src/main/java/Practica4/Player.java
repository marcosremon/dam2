package Practica4;

import java.util.*;
import java.util.random.RandomGenerator;

public class Player {

    String name;
    int cash;
    String tipoApuestaa;
    int apuesta;

    public Player() {
    }

    public Player(String name, int cash, String tipoApuestaa, int apuesta) {
        this.name = name;
        this.cash = cash;
        this.tipoApuestaa = tipoApuestaa;
        this.apuesta = apuesta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getTipoApuestaa() {
        return tipoApuestaa;
    }

    public void setTipoApuestaa(String tipoApuestaa) {
        this.tipoApuestaa = tipoApuestaa;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cash=" + cash +
                ", tipoApuestaa='" + tipoApuestaa + '\'' +
                ", apuesta=" + apuesta +
                '}';
    }

    public int apuestaca() {
        int randomNumber = 0;
        if (tipoApuestaa.equalsIgnoreCase("numero")) {
            randomNumber = RandomGenerator.getDefault().nextInt(1,36);
        }
        return randomNumber;
    }

//    public Integer numberBet() {
//        int randomNumber = RandomGenerator.getDefault().nextInt(1,36);
//        tipoApuesta = "numero";
//        return randomNumber;
//    }
//
//    public List<Integer> pairBet() {
//        List<Integer> evenNumbers = new ArrayList<>();
//        for (int i = 1; i <= 36; i++) {
//            if (i % 2 == 0) {
//                evenNumbers.add(i);
//            }
//        }
//        tipoApuesta = "par";
//        return evenNumbers;
//    }
//
//    public List<Integer> oddBet() {
//        List<Integer> oddNumbers = new ArrayList<>();
//        for (int i = 1; i <= 36; i++) {
//            if (i % 2 != 0) {
//                oddNumbers.add(i);
//            }
//        }
//        tipoApuesta = "impar";
//        return oddNumbers;
//    }
}