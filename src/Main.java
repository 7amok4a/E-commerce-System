import java.time.LocalDate;

import model.Customer;
import model.ExpirableProduct;
import model.ExpirableShippableProduct;
import model.NonExpirableProduct;
import model.ShippableProduct;
import service.ShippingService;

public class Main {
    public static void main(String[] args) { 
        try {
            ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 10,  5.99,  LocalDate.of(2025, 8, 1), 1.5);
            ExpirableProduct biscuits = new ExpirableProduct(
                "Biscuits",  20, 3.99, LocalDate.of(2025, 9, 1));
            ShippableProduct tv = new ShippableProduct("TV",  5, 299.99, 15.0);
            NonExpirableProduct mobileCard = new NonExpirableProduct("Mobile Scratch Card", 100 , 10.0);

            Customer customer = new Customer(500.0);

            customer.addToCart(cheese, 2);
            customer.addToCart(biscuits, 3);
            customer.addToCart(tv, 1);
            customer.addToCart(mobileCard, 5);

            ShippingService shippingService = new ShippingService();
            customer.checkout(shippingService);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
