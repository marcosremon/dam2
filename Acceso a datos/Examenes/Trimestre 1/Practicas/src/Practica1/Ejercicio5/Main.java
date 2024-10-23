package Practica1.Ejercicio5;

import Methods.Methods;
import Practica1.Ejercicio5.Modelo.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Path inputPath = Paths.get(Methods.importFiles("products.txt"));
        Path updatedInventoryPath = Paths.get(Methods.importFiles("updated_inventory.txt"));

        try (BufferedWriter bw = Files.newBufferedWriter(updatedInventoryPath)) {
            List<Product> products = Files.readAllLines(inputPath).stream().skip(1).map(line -> {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                int daysToExpire = Integer.parseInt(parts[4]);
                return new Product(id, name, price, quantity, daysToExpire);
            }).toList();

            List<Product> updateInventory = new ArrayList<>();
            for (Product product : products) {
                int quantity = product.getQuantity();
                if (product.getDaysToExpire() < 7) {
                    quantity = (int) Math.round(quantity * 0.80);
                    product.setQuantity(quantity);
                }
                updateInventory.add(product);
                System.out.println(product.toString());
                bw.write(product.toString() + System.lineSeparator());
            }

            System.out.println("\n---------------------------------------------------------------------------------\n");

            double totalValue = updateInventory.stream().mapToDouble(product ->
                    product.getQuantity() * product.getPrice()).sum();
            System.out.println(totalValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}