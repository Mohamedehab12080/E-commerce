package Services;

import Entities.Shippable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {

    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        Map<String, Integer> productCount = new LinkedHashMap<>();

        for (Shippable item : items) {
            productCount.put(item.getName(), productCount.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
