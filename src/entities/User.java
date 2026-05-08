package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String name;
    String password;
    String userType;
    ArrayList<Sale> sales = new ArrayList<Sale>();

    public User(String name, String password, String userType, AllUsers users) {
        this.name = name;
        this.password = password;
        this.userType = userType;
        users.addUser(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public static void createUser(Scanner sc, AllUsers users) {
        String userType = "";
        System.out.println("Digite o nome do usuario:");
        String name = sc.nextLine();
        System.out.println("Digite a senha do seu usuario:");
        String password = sc.nextLine();
        System.out.println("Digite o tipo de usuario:");
        System.out.println("[1] Cliente\n[2] Vendedor");
        int choice = sc.nextInt();

        if (choice == 1) {
            userType = "client";
        } else if (choice == 2) {
            userType = "seller";
        } else {
            System.out.println("Digite um tipo valido");
            return;
        }
        User user = new User(name, password, userType, users);
    }

    public void addSale(Product product, int quantity) {
        getSales().add(new Sale(product,quantity));
    }

    public void mySales(){

        System.out.printf(
                "%-12s %-20s %-12s %-10s %-12s%n",
                "DATA",
                "PRODUTO",
                "PREÇO",
                "QTD",
                "TOTAL"
        );

        System.out.println(
                "------------------------------------------------------------------"
        );

        for(Sale sale : getSales()){
            System.out.printf(
                    "%-12s %-20s R$ %-9.2f %-10d R$ %-10.2f%n",
                    sale.date,
                    sale.productName,
                    sale.productPrice,
                    sale.quantity,
                    sale.salePrice
            );
        }
    }
}
