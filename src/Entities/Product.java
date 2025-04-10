package Entities;

public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable(int requiredQuantity) {
        return quantity >= requiredQuantity;
    }
    public void reduceQuantity(int requiredQuantity) {
        this.quantity -= requiredQuantity;
    }
    public abstract boolean isExpired();
    public abstract boolean needsShipping();

}
