package restaurant;

import restaurant.building_blocks.Table;
import restaurant.building_blocks.room.kitchen.Kitchen;

public class Restaurant {
    public static final Kitchen KITCHEN = new Kitchen();
    public static double turnover;
    public static String name;
    public static Restaurant restaurant;

    public int getTableNumber() {
        return tableNumber;
    }

    private final int tableNumber;
    private final int tableCapacity;

    public Restaurant(int tableNumber, int tableCapacity) {
        this.tableNumber = tableNumber;
        this.tableCapacity = tableCapacity;
    }

    public synchronized static Restaurant getInstance() {
        if (restaurant == null) {
            restaurant = new Restaurant(10,4);
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
