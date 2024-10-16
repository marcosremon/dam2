package Practica2.Models;

public class Shop {
    public static int stock = 3;


   public static synchronized void comprar(String name) throws InterruptedException {
       if (estadoStock()) {
           System.out.println(name + " ha intentado comprar");
           Thread.sleep(1000);
           System.out.println(name + " ha comprado");
       } else System.out.println(name + " no ha podido comprar por que no hay stock");
   }
    public static Boolean estadoStock()  {
        if (stock > 0) {
            return true;
        } else return false;
    }
}
