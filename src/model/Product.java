package model;

public class Product {
    private String name ; 
    private int quantity ; 
    private double price ; 

    public Product(String name , int quantity , double price) {
        this.name = name ; 
        this.quantity = quantity ;
        this.price = price ; 
    }

    public String getName() {
        return this.name ; 
    }

    public int getQuantity() {
        return this.quantity ; 
    }

    public double getPrice() {
        return this.price ; 
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount ; 
    }
    boolean isFounded(int orderedQuantity) {
        return quantity >= orderedQuantity ; 
    }


}
