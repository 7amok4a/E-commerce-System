package model;

import java.time.LocalDate;

import interfaces.Shippable;

public class ExpirableShippableProduct extends ExpirableProduct implements Shippable{
    private double weight ; 

    public ExpirableShippableProduct(String name, int quantity, double price , LocalDate expiredDate, double weight) {
        super(name, quantity, price , expiredDate);
        this.weight = weight ; 
    }

    @Override
    public double getWeight() {
       return weight ; 
    }

    
}
