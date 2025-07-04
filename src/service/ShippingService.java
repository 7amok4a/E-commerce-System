package service;

import java.util.List;

import interfaces.Shippable;

public class ShippingService {
    
    public void methodShipping(List<Shippable> products) {
        System.out.println("Methods shipping for Products"); 
        for (Shippable product:products) {
            System.out.println("Name : " + product.getName() + "Weight " + product.getWeight() );
        }
    }
} 

