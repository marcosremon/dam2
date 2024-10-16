package Practica2.Models;

public class User implements Runnable{
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public synchronized void run() {
        try {
            Shop.comprar(name);
            Shop.stock--;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}