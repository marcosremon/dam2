package Practica1.Ejercicio5.Modelo;

public class Product {
    int id;
    String name;
    double price;
    int quantity;
    int daysToExpire;

    public Product(int id, String name, double price, int quantity, int daysToExpire) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.daysToExpire = daysToExpire;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", daysToExpire=" + daysToExpire +
                '}';
    }
}