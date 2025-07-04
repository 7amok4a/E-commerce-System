package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.Shippable;
import service.ShippingService;

public class Customer {
    private double balance ; 
    private List<CartItem> cart ; 


    public Customer(double balance) {
        this.balance = balance ; 
        this.cart =  new ArrayList<>() ;  
    }

    public void addToCart(Product product , int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Product is not available") ; 
        }
        if (!product.isFounded(quantity)) { 
            throw new Exception(product.getName() + " is not Founded now") ; 
        }
        if (product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) {
            throw new Exception(product.getName() + " is Expired") ; 
        }
        cart.add(new CartItem(product, quantity)) ; 
        
    }

    private double calculateShippingCost(List<Shippable> shippablesProducts) {

        double totalWeight = shippablesProducts.stream().mapToDouble(Shippable::getWeight).sum();
        return totalWeight * 0.5 ; 
    }
    public void checkout (ShippingService shippingService) throws Exception {
        double subtotal = 0 ;
        List<Shippable> shippableProducts = new ArrayList<>() ;  
        double shippingCosts = calculateShippingCost(shippableProducts) ; 
        double total = subtotal + shippingCosts ; 

        if (cart.isEmpty()) {
            throw new Exception("Your Cart is Empty") ; 
        }

        for (CartItem item : cart) {
            subtotal += item.getSubtotal(); 
            if (item.getProduct() instanceof Shippable) {
                for (int i = 0 ; i < item.getQuantity() ; ++i) {
                    shippableProducts.add((Shippable) item.getProduct()) ; 
                }
            }
        }

        if ( total > balance ) {
            throw new Exception("Balance not enough to compelete order") ; 
        }

        for (CartItem item : cart) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        balance -= total ; 

        if (!shippableProducts.isEmpty()) {
            shippingService.methodShipping(shippableProducts);
        }

        cart.clear();
    }
}
