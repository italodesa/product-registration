package entities;

import java.util.Scanner;

public class User {
    String name;
    String password;
    String userType;

    public User(String name, String password, String userType) {
        this.name = name;
        this.password = password;
        this.userType = userType;
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

    public static void createUser(Scanner sc) {
        String userType = "";
        System.out.println("Digite o nome do usuario:");
        String name = sc.nextLine();
        System.out.println("Digite a senha do seu usuario:");
        String password = sc.nextLine();
        System.out.println("Digite o tipo de usuario:");
        System.out.println("[1] Cliente\n[2] Vendedor");
        int choice = sc.nextInt();

        if (choice == 1) {
            userType = "seller";
        } else if (choice == 2) {
            userType = "client";
        } else {
            System.out.println("Digite um tipo valido");
            return;
        }
        User user = new User(name, password, userType);
    }
}
