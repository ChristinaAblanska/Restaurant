package restaurant;

import restaurant.building_blocks.Owner;
import restaurant.building_blocks.RestaurantMenu;
import restaurant.building_blocks.employee.Manager;
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
    private final Waiter waiter_1;
    private final Thread waiter_1Thread;
    private final Waiter waiter_2;
    private final Thread waiter_2Thread;
    public final String restaurantName;
    private final Table[] tables;
    private final Cleaner cleaner;
    private final Owner owner;
    public static double turnover = 40000;
    private final Time cleaningTime;
    private boolean isOpenRestaurant;
    private final Kitchen kitchen;
    private final Manager manager;

    public Restaurant(String restaurantName, int tablesNumber, int singleTableCapacity, Time cleaningTime) {
        this.restaurantName = restaurantName;
        this.tables = new Table[tablesNumber];
        this.cleaningTime = cleaningTime;
        cleaner = new Cleaner(1050);
        owner = new Owner(this);
        manager = new Manager(this, 3000);
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
        waiter_1 = new Waiter(kitchen, tablesGroup1, 1, 1200, 1);
        waiter_1Thread = new Thread(waiter_1);

        waiter_2 = new Waiter(kitchen, tablesGroup2, 2, 1200, 1);
        waiter_2Thread = new Thread(waiter_2);
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

    public Thread getWaiter_1Thread() {
        return waiter_1Thread;
    }

    public Thread getWaiter_2Thread() {
        return waiter_2Thread;
    }

    public Waiter getWaiter_1() {
        return waiter_1;
    }

    public Waiter getWaiter_2() {
        return waiter_2;
    }

    @Override
    public String toString() {
        return "Welcome to restaurant " + restaurantName +
                ".We have capacity of " + tables.length + " dinner tables X " + tables[0].getCapacity() + " seats each.";
    }

    public Manager getManager() {
        return manager;
    }
}
