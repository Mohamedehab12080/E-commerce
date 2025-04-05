import Entities.*;
import Services.CheckoutService;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Create products
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 2); // valid for 2 more days

        Product cheese = new ExpirableProduct("Cheese 200g", 100, 5, calendar.getTime());
        Product biscuits = new ExpirableProduct("Biscuits 700g", 150, 3, calendar.getTime());
        Product tv = new ShippableProduct("TV", 3000, 3, 10.0);
        Product scratchCard = new DigitalProduct("Scratch Card", 50, 10);

        // Create customer
        Customer customer = new Customer("Mohamed", 5000);

        // Add to cart
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        // Checkout
        CheckoutService.checkout(customer, cart);
    }
}