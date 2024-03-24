package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.building_blocks.table.Table;
import restaurant.building_blocks.room.kitchen.Kitchen;

public class Waiter implements Runnable {
    private final Table[] tables;

    public int getWaiterNumber() {
        return waiterNumber;
    }

    private final int waiterNumber;
    private double tip = 0.0;

    public Table[] getTables() {
        return tables;
    }

    // private final TablesGroup tableGroup;
    private Kitchen kitchen;


    public Waiter(Kitchen kitchen, Table[] tables, int waiterNumber) {
        this.tables = tables;
        this.kitchen = kitchen;
        this.waiterNumber = waiterNumber;
    }

    public void run() {
        while (true) {
            deliverOrdersToKitchen();
        }
    }

    private void deliverOrdersToKitchen() {

        for (Table table : tables) {
            if (table.getTableOrder().getStatus().equals(OrderStatus.ACTIVE)) {
                table.getTableOrder().setStatus(OrderStatus.IN_PROGRESS);
                table.getTableOrder().setWaiter(this);
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
