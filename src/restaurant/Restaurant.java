package restaurant;

import restaurant.building_blocks.Table;
import restaurant.building_blocks.employee.Cleaner;
import restaurant.building_blocks.employee.Waiter;
import restaurant.building_blocks.room.kitchen.Kitchen;

public class Restaurant {
    public static HistoryLog history = new HistoryLog();
    private final int tableNumber;
    private final Table[] tables;
    private Cleaner cleaner;

    private final int singleTableCapacity;
    public static double turnover;
    public static String name;
    private Time cleaningTime;

    public Restaurant(int tablesNumber, int singleTableCapacity, int waitersNumber, Time cleaningTime) {
        this.tableNumber = tablesNumber;
        this.singleTableCapacity = singleTableCapacity;
        this.tables = new Table[tablesNumber];
        this.cleaningTime = cleaningTime;

        for (int i = 0; i < tablesNumber; i++) {
            tables[i] = new Table(singleTableCapacity, i + 1);
        }
        Kitchen kitchen = new Kitchen();

        Thread[] waiters = new Thread[waitersNumber];
        for (int i = 0; i < waitersNumber; i++) {
            Thread t = new Thread(new Waiter(kitchen, tables));
            t.start();
            waiters[i] = t;
        }
        cleaner = new Cleaner();
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
}
