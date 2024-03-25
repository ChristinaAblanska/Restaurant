package restaurant;

import restaurant.building_blocks.kitchen.storage.StorageGenerator;
import restaurant.building_blocks.kitchen.storage.ProductStorage;
import restaurant.interaction.RestaurantMenuInteraction;
import restaurant.simulation.RestaurantSimulator;
import restaurant.simulation.SimulatorParameters;

import java.util.Scanner;

public class Main {
    public static final double PROFIT = 2.0;
    public static final double TIPS = 0.01;

    public static void main(String[] args) {
        /*System.out.println("Project 1 - Shipka Restaurant");

        InterActiveMenu interActiveMenu = new InterActiveMenu();
        Scanner scan = new Scanner(System.in);
        interActiveMenu.interactWithTheMenu(scan);*/


        ProductStorage storage = new StorageGenerator().storageGenerator();


        Restaurant shipka = new Restaurant("Shipka",
                10,
                4,
                SimulatorParameters.CLEANING_START_TIME);

        shipka.getKitchen().setStorage(storage);

        RestaurantSimulator simulator = new RestaurantSimulator(shipka);
        simulator.startSimulation();

        // Menu Interaction
        RestaurantMenuInteraction interaction = new RestaurantMenuInteraction(shipka, new Scanner(System.in));
        interaction.go();


    }
}
