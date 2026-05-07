package entities;

import java.util.Scanner;

public class Menu {

    public static void mainMenu(Scanner sc, AllProducts allProducts) {
        while (true) {
            System.out.println("=====" + "WEB MARKET" + "=====" );
            System.out.println("[1] View products\n[2] Create product\n[3] Exit");
            byte choice = sc.nextByte();
            sc.nextLine();
            switch(choice){
                case 1:
                    allProducts.listProducts();
                    break;
                case 2:
                    Product.createProduct(sc, allProducts);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
