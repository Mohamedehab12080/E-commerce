package Entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items=new ArrayList<CartItem>();

    public void add(Product product,int quantity) {
        if(product.isAvailable(quantity)) {
            items.add(new CartItem(product,quantity));
        }else {
            throw new IllegalArgumentException("product is not available");
        }
    }

    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
