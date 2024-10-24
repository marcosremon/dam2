package Practica4;

import java.util.random.RandomGenerator;

public class Roulet {
    private int cash;

    public Roulet() {
    }

    public Roulet(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "LaRule{" +
                "cash=" + cash +
                '}';
    }

    public int rouletNumber() {
        return RandomGenerator.getDefault().nextInt(36);
    }
}