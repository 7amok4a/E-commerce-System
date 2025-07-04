package model;

import interfaces.Shippable;

public class ShippableProduct  extends Product implements Shippable{ 
    private double weight ; 

    public ShippableProduct(String name, int quantity, double price , double weight) {
        super(name, quantity, price);
        this.weight = weight ; 
    }

    @Override
    public double getWeight() {
       return weight ; 
    }

    
}
