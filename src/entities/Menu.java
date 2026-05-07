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

    public static void buyMenu(Scanner sc, AllProducts allProducts){
        while (true) {
            System.out.println("Deseja comprar algum produto? (s/n)");
            char choice = sc.next().charAt(0);
            switch (choice){
                case 's':
                    System.out.println("Digite o nome do produto: ");
                    String name = sc.nextLine();
                    System.out.println("Digite o id do produto: ");
                    int id = sc.nextInt();
                    System.out.println("Digite a quantidade que você deseja comprar: ");
                    int quantity = sc.nextInt();
                    allProducts.buyProduct(id,name,quantity);
                    break;
                case 'n':
                    System.exit(0);
                    break;

            }

        }
    }
}
