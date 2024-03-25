package restaurant.test;

import restaurant.Restaurant;
import restaurant.building_blocks.kitchen.storage.StorageGenerator;
import restaurant.building_blocks.kitchen.storage.ProductStorage;
import restaurant.interaction.RestaurantMenuInteraction;
import restaurant.simulation.RestaurantSimulator;
import restaurant.simulation.SimulatorParameters;

import java.util.Scanner;

public class Main_Test {

    //    public void testInteraction() {
    public static void main(String[] args) {
        ProductStorage storage = new StorageGenerator().storageGenerator();


        Restaurant shipka = new Restaurant("Shipka", 10, 4, SimulatorParameters.CLEANING_START_TIME);
        shipka.getKitchen().setStorage(storage);


        RestaurantSimulator simulator = new RestaurantSimulator(shipka);
        simulator.startSimulation();

        // Menu Interaction
        Scanner scan = new Scanner(System.in);
        RestaurantMenuInteraction interaction = new RestaurantMenuInteraction(shipka, scan);
        interaction.go();
    }
}
