package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.Table;
import restaurant.building_blocks.room.kitchen.Kitchen;

public class Waiter implements Runnable {
    private final Table[] tables;

    public int getWaiterNumber() {
        return waiterNumber;
    }

    private final int waiterNumber;
    private int tip;

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
            if (table.getOrder().getOrderStatus().equals(OrderStatus.ACTIVE)) {
                table.getOrder().setOrderStatus(OrderStatus.IN_PROGRESS);
                table.getOrder().setWaiter(this);
                synchronized (table.getOrder()) {
                    table.getOrder().notify();
                }
                kitchen.completeAnOrder(table.getOrder());
            }
        }
    }
}
