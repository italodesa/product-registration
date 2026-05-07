package entities;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(Scanner sc){
        System.out.println("=====" + "WEB MARKET" + "=====" );
        System.out.println("[1] View products\n[2] Create product\n[3] Exit");
        byte choice = sc.nextByte();
    }
}
