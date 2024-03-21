package restaurant;

import restaurant.building_blocks.Owner;
import restaurant.building_blocks.Table;
import restaurant.building_blocks.employee.Cleaner;
import restaurant.building_blocks.employee.Waiter;
import restaurant.building_blocks.room.kitchen.Kitchen;

import java.util.Arrays;

public class Restaurant {
    public final String restaurantName;
    public static HistoryLog history = new HistoryLog();
    private final int tableNumber;
    private final Table[] tables;
    private Cleaner cleaner;

    private final int singleTableCapacity;
    public static double turnover = 1000;
    public static String name;
    private Time cleaningTime;


    private boolean isOpenRestaurant;
    private Owner owner;

    public Restaurant(String restaurantName, int tablesNumber, int singleTableCapacity, int waitersNumber, Time cleaningTime) {
        this.restaurantName = restaurantName;
        this.tableNumber = tablesNumber;
        this.singleTableCapacity = singleTableCapacity;
        this.tables = new Table[tablesNumber];
        this.cleaningTime = cleaningTime;

        for (int i = 0; i < tablesNumber; i++) {
            tables[i] = new Table(singleTableCapacity, i + 1);
        }
        Kitchen kitchen = new Kitchen();

        // Thread[] waiters = new Thread[waitersNumber];
        // for (int i = 0; i < waitersNumber; i++) {
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

        // System.out.println(Arrays.toString(tablesGroup1));
        //System.out.println(Arrays.toString(tablesGroup2));
        Thread t = new Thread(new Waiter(kitchen, tablesGroup1, 1));
        t.start();
        // waiters[0] = t;

        Thread t1 = new Thread(new Waiter(kitchen, tablesGroup2, 2));
        t1.start();
        // waiters[1] = t1;
        //}
        cleaner = new Cleaner();
        owner = new Owner(this);
    }

    public static void printTurnover() {

    }

    public void printEmployeesEarnedTyp() {

    }

    public void printKitchenStorageStock() {

    }

    public int getOccupiedTablesNumber() {
        int num = 0;
        for (int i = 0; i < tableNumber; i++) {
            if (tables[i].isOccupied()) {
                num++;
            }
        }
        return num;
    }

    public synchronized int getSingleTableCapacity() {
        return singleTableCapacity;
    }

    public synchronized Table[] getTables() {
        return tables;
    }

    public int getTableNumber() {
        return tableNumber;
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

    @Override
    public String toString() {
        return "Welcome to restaurant "+restaurantName +
                ".We have capacity of "+tableNumber+" dinner tables X "+singleTableCapacity+" seats each.";
    }
}
