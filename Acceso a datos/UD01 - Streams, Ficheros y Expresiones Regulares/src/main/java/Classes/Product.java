package Classes;

public class Product {
    private int id;
    private String name;
    private double price;
    private boolean discount;
    private char tipe;

    public Product() {
    }

    public Product(int id, String name, double price, boolean discount, char tipe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.tipe = tipe;
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

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public char getTipe() {
        return tipe;
    }

    public void setTipe(char tipe) {
        this.tipe = tipe;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", tipe=" + tipe +
                '}';
    }
}