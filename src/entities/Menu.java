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
                    Menu.buyMenu(sc, allProducts);
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
            allProducts.listProducts();
            System.out.println("Deseja comprar algum produto? (s/n)");
            char choice = sc.next().charAt(0);
            sc.nextLine();
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
                    return;

            }

        }
    }

    public static void loginMenu(Scanner sc, AllUsers users, AllProducts allProducts){
        while (true) {
            System.out.println("=====" + "WEB MARKET" + "=====" );
            System.out.println("[1] Create account\n[2] Login\n[3] Exit");
            byte choice = sc.nextByte();
            sc.nextLine();

            switch(choice){
                case 1:
                    User.createUser(sc,users);
                    break;
                case 2:
                    System.out.println("Digite o nome do usuario: ");
                    String name = sc.nextLine();
                    System.out.println("Digite a senha do usuario: ");
                    String password = sc.nextLine();
                    User user = users.getUser(name,password);
                    if (user != null){
                        if (user.getUserType() == "seller"){
                            Menu.sellerMenu(sc,user,allProducts);
                        } else if (user.getUserType() == "client"){
                            Menu.clientMenu(sc,user,allProducts);
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
            }

        }
    }

    public static void sellerMenu(Scanner sc, User user, AllProducts allProducts){
        while (true) {
            System.out.println("=====" + "WEB MARKET" + "=====" );
            System.out.println("Bem vindo usuario " + user.getName());
            System.out.println("[1] View products\n[2] Create product\n[3] Exit");

            byte choice = sc.nextByte();
            sc.nextLine();
            switch(choice) {
                case 1:
                    Menu.buyMenu(sc, allProducts);
                    break;
                case 2:
                    Product.createProduct(sc, allProducts);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void clientMenu(Scanner sc,User user, AllProducts allProducts){
        while (true) {
            System.out.println("=====" + "WEB MARKET" + "=====" );
            System.out.println("Bem vindo usuario " + user.getName());
            System.out.println("[1] View products\n[2] Exit");

            byte choice = sc.nextByte();
            sc.nextLine();
            switch(choice) {
                case 1:
                    Menu.buyMenu(sc, allProducts);
                    break;
                case 2:
                    return;
            }
        }
    }
}
