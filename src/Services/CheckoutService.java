package Services;

import Entities.*;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private static final double SHIPPING_RATE = 10.0; // flat rate per shippable item

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0.0;
        double shippingFee = 0.0;
        List<Shippable> shippingItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (item.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired.");
            }

            if (!product.isAvailable(item.getQuantity())) {
                throw new IllegalStateException(product.getName() + " is out of stock.");
            }

            subtotal += item.getTotalPrice();
            product.reduceQuantity(item.getQuantity());

            if (item.isShippable()) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    if (product instanceof Shippable) {
                        Shippable itemz = (Shippable) product;
                        shippingItems.add(itemz);
                    }
                }
                shippingFee += item.getQuantity() * SHIPPING_RATE;
            }
        }

        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Customer's balance is insufficient.");
        }

        customer.deductBalance(total);

        // Shipment
        if (!shippingItems.isEmpty()) {
            ShippingService.ship(shippingItems);
        }

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shippingFee);
        System.out.printf("Amount %.0f\n", total);
        System.out.println("END.");
    }
}
