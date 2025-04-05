# E-Commerce System – Fawry N² Internship Challenge
This is a Java-based e-commerce system designed as part of the Fawry Quantum Internship Challenge. The system simulates real-world shopping behavior, covering product definitions, cart management, checkout processing, and shipping logistics.
## Features
### 1- Product Management
    Define products with name, price, and quantity. Products may:

      -Be perishable (e.g., Cheese, Biscuits) or non-perishable (e.g., TV, Mobile).

      -Require shipping (e.g., Cheese, TV) or not (e.g., scratch cards).
### 2- Cart Functionality
    -Customers can add products to the cart with specific quantities.
    
    -Prevent adding more than the available product stock.
    
    -Maintains insertion order using LinkedHashMap.
### 3- Checkout System
Validates cart content and customer's balance.

Prevents checkout if:
    
    -The cart is empty
    
    -A product is out of stock or expired
    
    -The customer has insufficient balance
Calculates:

    -Subtotal
    
    -Shipping fees (based on product weights)
    
    -Final amount paid
    
    -Updated customer balance
### 4- Shipping Service

    -Collects shippable items and prints a shipment notice including item names and total weight.
    
    -Uses an interface (Shippable) with getName() and getWeight() methods for abstraction.


