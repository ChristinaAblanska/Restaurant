package restaurant;

import restaurant.building_blocks.kitchen.storage.StorageGenerator;
import restaurant.building_blocks.kitchen.storage.ProductStorage;
import restaurant.interaction.RestaurantMenuInteraction;
import restaurant.simulation.RestaurantSimulator;
import restaurant.simulation.SimulatorParameters;

import java.util.Scanner;

public class Main {
    public static final double PROFIT = 2.0;
    public static final double TIPS = 0.1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ProductStorage storage = new StorageGenerator().storageGenerator();


        Restaurant shipka = new Restaurant("Shipka",
                10,
                4,
                SimulatorParameters.CLEANING_START_TIME);

        shipka.getKitchen().setStorage(storage);

        int choice = Console.readInteger(scan, "Choose what to do now?\n 1 - Simulation\n 2 - Interact with the menu\n");

        if (choice == 1) {
            // Simulation
            System.out.println("Simulation starts");
            RestaurantSimulator simulator = new RestaurantSimulator(shipka);
            simulator.startSimulation();
            System.out.println("Simulation completed\n");
        } else if (choice == 2) {
            // Menu Interaction
            RestaurantMenuInteraction interaction = new RestaurantMenuInteraction(shipka, scan);
            interaction.go();
        }

        scan.close();
    }
}
