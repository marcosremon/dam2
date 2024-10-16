package Practica2;

import Practica2.Models.Shop;
import Practica2.Models.User;

public class Ejercicio2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        User user1 = new User("andres");
        User user2 = new User("manuel");
        User user3 = new User("juan");
        User user4 = new User("luis");

       user1.run();
       user2.run();
       user3.run();
       user4.run();
    }
}