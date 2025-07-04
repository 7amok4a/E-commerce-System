package model;
import java.time.LocalDate;

public class ExpirableProduct extends Product {
    private LocalDate expiredDate ; 

    public ExpirableProduct(String name, int quantity, double price , LocalDate expiredDate) {
        super(name, quantity, price);
        this.expiredDate = expiredDate ; 
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiredDate) ; 
    }
    
}
