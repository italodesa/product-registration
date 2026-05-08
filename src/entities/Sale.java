package entities;

import java.time.LocalDate;

public class Sale {
    LocalDate date;
    String productName;
    double productPrice;
    int quantity;
    double salePrice;

    public Sale(Product product,int quantity) {
        this.date = LocalDate.now();
        this.productName = product.getName();
        this.productPrice = product.getPrice();
        this.quantity = quantity;
        this.salePrice = product.getPrice() * quantity;
    }
}
