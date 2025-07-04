package model;

public class CartItem {
    private Product product ; 
    private int quantity ; 

    public CartItem(Product product , int quantity) {
        this.product = product ; 
        this.quantity = quantity ; 
    }

    public Product getProduct() {
        return this.product ; 
    }

    public int getQuantity() {
        return this.quantity ; 
    }

    public double getSubtotal() {
        return product.getPrice() * this.quantity ; 
    }


}
