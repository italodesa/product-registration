package application;

import entities.AllProducts;
import entities.AllUsers;
import entities.Menu;

import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        AllProducts products =  new AllProducts();
        AllUsers users = new AllUsers();
        Scanner sc = new Scanner(System.in);
        Menu.mainMenu(sc,users,products);

        sc.close();
    }
}
