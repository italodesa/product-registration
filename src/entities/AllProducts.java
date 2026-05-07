package entities;

import java.util.ArrayList;

public class AllProducts {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product){
        products.add(product);
    }
}
