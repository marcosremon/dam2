package Practica4;

public class Player {

    String name;
    int cash;

    public Player() {
    }

    public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
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

    @Override
    public String toString() {
        return "el jugador: " + name + " tiene: " + cash;
    }
}