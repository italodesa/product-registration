package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity, AllProducts products){
        this.id = products.generateId();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        products.addProduct(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public static void createProduct(Scanner sc, AllProducts allProducts){
        System.out.println("Digite o nome do produto: ");
        String name = sc.nextLine();
        System.out.println("Digite o valor do produto: ");
        double price = sc.nextDouble();
        System.out.println("Digite a quantidade do produto: ");
        int quantity = sc.nextInt();
        Product product = new Product(name, price, quantity, allProducts);

    }
}
