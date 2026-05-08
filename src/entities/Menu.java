package entities;

import java.util.Scanner;

public class Menu {

    public static void mainMenu(Scanner sc, AllUsers users, AllProducts allProducts) {
        while (true) {
            Menu.loginMenu(sc,users,allProducts);
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
            System.out.println("[1] View products\n[2] Create product\n[3] Editar produto\n[4] Excluir produto\n[5] Sair");

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
                    Menu.sellerEditMenu(sc,allProducts);
                    break;
                case 4:
                    Menu.sellerDeleteMenu(sc,allProducts);
                    break;
                case 5:
                    return;
            }
        }
    }

    public static void sellerEditMenu(Scanner sc,AllProducts allProducts){
        System.out.println("Digite o id do produto: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do produto: ");
        String name = sc.nextLine();
        Product product = allProducts.getProduct(id,name);

        if (product == null){
            System.out.println("produto não encontrado");
            return;
        }

        while (true) {
            System.out.println("=====" + "EDIT PRODUCT" + "=====" );
            System.out.println("produto: ");
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQuantity());
            System.out.println();
            System.out.println("[1] Nome\n[2] Preço\n[3] Quantidade\n[4] Sair");
            System.out.println("Digite o que deseja editar: ");
            byte choice = sc.nextByte();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Digite o novo nome do produto: ");
                    String newName = sc.nextLine();
                    product.setName(newName);
                    break;
                case 2:
                    System.out.println("Digite o novo preço do produto: ");
                    double newPrice = sc.nextDouble();
                    product.setPrice(newPrice);
                    break;
                case 3:
                    System.out.println("Digite a nova quantidade do produto: ");
                    int newQuantity = sc.nextInt();
                    product.setQuantity(newQuantity);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void sellerDeleteMenu(Scanner sc, AllProducts allProducts){
        System.out.println("Digite o id do produto: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do produto: ");
        String name = sc.nextLine();
        Product product = allProducts.getProduct(id,name);

        if (product == null){
            System.out.println("produto não encontrado");
            return;
        }
        System.out.println("tem certeza que deseja excluir o produto "+product.getName()+"? (s/n");
        char choice = sc.next().charAt(0);
        sc.nextLine();

        if (choice == 's'){
            allProducts.deleteProduct(product);
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
