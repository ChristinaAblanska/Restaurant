package restaurant;

import restaurant.building_blocks.OrdersQueue;
import restaurant.building_blocks.Owner;
import restaurant.building_blocks.RestaurantMenu;
import restaurant.building_blocks.table.Table;
import restaurant.building_blocks.employee.Cleaner;
import restaurant.building_blocks.employee.Waiter;
import restaurant.building_blocks.room.kitchen.Kitchen;
import restaurant.simulation.Time;

/**
 * This class represent a restaurant.We have fixed number of two waiters.
 * The number of the dinner tables is passed as a parameter in the constructor and these
 * dinner tables are arranged between the two waiters.
 */
public class Restaurant {
    public final String restaurantName;
    private final Table[] tables;
    private final Cleaner cleaner;
    private final Owner owner;
    public static double turnover = 100000;
    private final Time cleaningTime;
    private boolean isOpenRestaurant;
    private final Kitchen kitchen;

    public Restaurant(String restaurantName, int tablesNumber, int singleTableCapacity, Time cleaningTime) {
        this.restaurantName = restaurantName;
        this.tables = new Table[tablesNumber];
        this.cleaningTime = cleaningTime;
        cleaner = new Cleaner();
        owner = new Owner(this);
        kitchen = new Kitchen();

        for (int i = 0; i < tablesNumber; i++) {
            tables[i] = new Table(new RestaurantMenu(), singleTableCapacity, i + 1);
        }


        Table[] tablesGroup1 = new Table[tables.length / 2];
        Table[] tablesGroup2 = new Table[tables.length / 2];

        int c1 = 0;
        int c2 = 0;
        while (c1 < tables.length) {

            if (c1 < tablesGroup1.length) {
                tablesGroup1[c1] = tables[c1];
            } else {
                tablesGroup2[c2] = tables[c1];
                c2++;
            }
            c1++;
        }
        Thread t = new Thread(new Waiter(kitchen, tablesGroup1, 1));
        t.start();

        Thread t1 = new Thread(new Waiter(kitchen, tablesGroup2, 2));
        t1.start();
    }

    public static void printTurnover() {

    }

    public void printEmployeesEarnedTyp() {

    }

    public String getKitchenStorageStock() {
        return kitchen.getStorage().toString();
    }

    public int getOccupiedTablesNumber() {
        int num = 0;
        for (int i = 0; i < tables.length; i++) {
            if (tables[i].isOccupied()) {
                num++;
            }
        }
        return num;
    }

    public synchronized Table[] getTables() {
        return tables;
    }

    public boolean isCleaningTime(Time time) {
        return time.getHour() == cleaningTime.getHour()
                && time.getMin() >= cleaningTime.getMin();
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public boolean isOpenRestaurant() {
        return isOpenRestaurant;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOpenRestaurant(boolean openRestaurant) {
        isOpenRestaurant = openRestaurant;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    @Override
    public String toString() {
        return "Welcome to restaurant " + restaurantName +
                ".We have capacity of " + tables.length + " dinner tables X " + tables[0].getCapacity() + " seats each.";
    }

    public void updateTurnover(OrdersQueue ordersQueue) {
        for (int i = 0; i < ordersQueue.getSze(); i++) {
            this.turnover += ordersQueue.getOrderElement(i).calculateTotalPrice();
        }
    }

    public double getTurnover() {
        return this.turnover;
    }
}
