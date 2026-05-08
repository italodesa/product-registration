package entities;

import java.util.ArrayList;

public class AllProducts {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void listProducts() {

        System.out.println("==============================================");
        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "ID", "NOME", "PREÇO", "QUANT.");
        System.out.println("==============================================");

        for (Product product : products) {

            System.out.printf("%-5d %-20s R$ %-7.2f %-10d%n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity());
        }

        System.out.println("==============================================");
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

    public void buyProduct(int id, String name,int quantity){
        Product product = getProduct(id, name);
        if (product == null) {
            System.out.println("Produto não encontrado");
            return;
        }
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity()-quantity);
        }
        if (product.getQuantity() <= 0) {
            products.remove(product);
        }
    }
}
