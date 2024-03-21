package restaurant;

import restaurant.building_blocks.InterActiveMenu;

import java.util.Scanner;

public class Main {
    public static final double PROFIT = 2.0;
    public static final double TIPS = 0.01;
    public static void main(String[] args) {
        System.out.println("Project 1 - Shipka Restaurant");

        InterActiveMenu interActiveMenu = new InterActiveMenu();
        Scanner scan = new Scanner(System.in);
        interActiveMenu.interactWithTheMenu(scan);
    }


}
