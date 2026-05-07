package entities;

import java.util.ArrayList;

public class AllProducts {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void listProducts(){
        for(Product product:products){
            System.out.println(product.getId() + " " + product.getName());
        }
    }

    public int generateId(){
        if (products.isEmpty()) {
            return 0;
        }
        return products.size();
    }

    public Product getProduct(int id,String name) {
        for (Product p : this.products) {
            if (p.getId() == id || p.getName() == name) {
                return p;
            }
        }
        return null;
    }
}
