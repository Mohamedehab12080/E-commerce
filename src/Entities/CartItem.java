package Entities;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    public boolean isShippable(){
        return product.needsShipping();
    }
    public Product getProduct() {
        return product;
    }
    public boolean isExpired() {
        return product.isExpired();
    }

    public int getQuantity() {
        return quantity;
    }


}
