package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.table.Table;
import restaurant.building_blocks.room.kitchen.Kitchen;
import restaurant.simulation.WorkDay;

import java.util.Map;

public class Waiter extends Employee implements Runnable {
    private final Table[] tables;

    public int getWaiterNumber() {
        return waiterNumber;
    }

    private final int reactionTimeInMinutes;

    private final int waiterNumber;
    private double tip = 0.0;

    public Table[] getTables() {
        return tables;
    }

    // private final TablesGroup tableGroup;
    private final Kitchen kitchen;


    public Waiter(Kitchen kitchen, Table[] tables, int waiterNumber, double salary, int reactionTimeInMinutes) {
        this.tables = tables;
        this.kitchen = kitchen;
        this.waiterNumber = waiterNumber;
        this.salary = salary;
        this.reactionTimeInMinutes = reactionTimeInMinutes;
    }

    public void run() {
        while (true) {

            servesDinnerTables();

            try {
                Thread.sleep(WorkDay.minutesToLocalMinutes(reactionTimeInMinutes));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void servesDinnerTables() {
        //Deliver orders to the kitchen
        for (Table table : tables) {
            if (table.getTableOrder().getStatus().equals(OrderStatus.ACTIVE)) {
                table.getTableOrder().setStatus(OrderStatus.IN_PROGRESS);
                table.getTableOrder().setWaiter(this);
                //Deliver beverages
               /* for (Order ord : table.getTableOrder()) {
                    for (Map.Entry<Beverage, Integer> beverage : ord.getBeverages().entrySet()) {

                }*/
                synchronized (table.getTableOrder()) {
                    table.getTableOrder().notify();
                }
                kitchen.completeAnOrder(table.getTableOrder());
            }
        }
    }

    public void updateTips(double tips) {
        this.tip += tips;
    }
}
