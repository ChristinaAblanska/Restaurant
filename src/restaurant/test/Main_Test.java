package restaurant.test;

import restaurant.Restaurant;
import restaurant.building_blocks.StorageGenerator;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;
import restaurant.interaction.RestaurantMenuInteraction;
import restaurant.simulation.RestaurantSimulator;
import restaurant.simulation.SimulatorParameters;
import restaurant.simulation.Time;

import java.util.Scanner;

public class Main_Test {

//    public void testInteraction() {
public static void main(String[] args) {
        ProductStorage storage = new StorageGenerator().storageGenerator();

        Time cleaningTime = new Time(SimulatorParameters.WORK_DAY_HOURS
                + SimulatorParameters.WORK_DAY_START_HOUR - 1
                , SimulatorParameters.CLEANING_START_TIME_MINUTES_BEFORE_CLOSE);

        Restaurant shipka = new Restaurant("Shipka", 10, 4, cleaningTime);
        shipka.getKitchen().setStorage(storage);


        RestaurantSimulator simulator = new RestaurantSimulator(shipka);
        simulator.startSimulation();;

        // Menu Interaction
        Scanner scan = new Scanner(System.in);
        RestaurantMenuInteraction interaction = new RestaurantMenuInteraction(shipka, scan);
        interaction.go();
    }
}
