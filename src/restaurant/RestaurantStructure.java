package restaurant;

import restaurant.building_blocks.room.kitchen.Kitchen;

public class RestaurantStructure {
    public static final Kitchen KITCHEN = new Kitchen();
    public static double turnover;
    public static String name;
    public static RestaurantStructure restaurant;

    public RestaurantStructure() {

    }

    public synchronized static RestaurantStructure getInstance() {
        if (restaurant == null) {
            restaurant = new RestaurantStructure();
        }
        return restaurant;
    }

    public static void printTurnover() {

    }

    public void printEmployeesEarnedTyp() {

    }

    public void printKitchenStorageStock() {

    }
}
