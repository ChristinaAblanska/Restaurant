package restaurant;

import restaurant.building_blocks.InterActiveMenu;
import restaurant.building_blocks.RecipeGenerator;
import restaurant.building_blocks.RestaurantMenu;
import restaurant.building_blocks.StorageGenerator;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;
import restaurant.simulation.RestaurantSimulator;
import restaurant.simulation.SimulatorParameters;
import restaurant.simulation.Time;

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

        Time cleaningTime = new Time(SimulatorParameters.WORK_DAY_HOURS
                + SimulatorParameters.WORK_DAY_START_HOUR - 1
                , SimulatorParameters.CLEANING_START_TIME_MINUTES_BEFORE_CLOSE);

        Restaurant shipka = new Restaurant("Shipka", 10, 4, cleaningTime);
        shipka.getKitchen().setStorage(storage);


        RestaurantSimulator simulator = new RestaurantSimulator(shipka);
        simulator.startSimulation();

    }


}
