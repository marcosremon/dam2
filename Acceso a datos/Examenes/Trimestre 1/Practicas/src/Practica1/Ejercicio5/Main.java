package Practica1.Ejercicio5;

import Practica1.Ejercicio5.Modelo.Product;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "Files/products.txt";
        String updatedInventoryFile = "Files/updated_inventory.txt";

        List<Product> products = new ArrayList<>();
        List<Product> updateInventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(updatedInventoryFile))) {
            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                int daysToExpire = Integer.parseInt(parts[4]);
                products.add(new Product(id, name, price, quantity, daysToExpire));
            }

            System.out.println("parte 1");
            products.stream().filter(product -> product.getDaysToExpire() < 7 && product.getPrice() > 1.0)
                    .forEach(System.out::println);
            System.out.println("\n--------------------------------------------------------\n");

            System.out.println("parte 2");
            for (Product i : products) {
                int id = i.getId();
                String name = i.getName();
                double price = i.getPrice();
                int cantidad = i.getQuantity();
                int diasParaExpirar = i.getDaysToExpire();
                if (diasParaExpirar < 7) {
                    cantidad -= (cantidad * 20) / 100;
                }

                Product product = new Product(id, name, price, cantidad, diasParaExpirar);
                System.out.println(product);
                updateInventory.add(product);
                bw.write(product.toString());
                bw.newLine();
            }

            System.out.println("\n--------------------------------------------------------\n");

            double totalValue = updateInventory.stream().mapToDouble(product -> (product.getQuantity() * product.getPrice())).sum();
            System.out.println(totalValue);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}