package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.Table;
import restaurant.building_blocks.room.kitchen.Kitchen;

public class Waiter implements Runnable {
    private final Table[] tables;
    private int tip;

    // private final TablesGroup tableGroup;
    private Kitchen kitchen;


    public Waiter(Kitchen kitchen, Table[] tables) {
        this.tables = tables;
        // for (int i = 0; i < tables.length; i++) {
        //   System.out.println(tables[i]);
        // }
        this.kitchen = kitchen;
    }

    public void run() {
        while (true) {
            deliverOrdersToKitchen();
        }
    }

    private void deliverOrdersToKitchen() {

        for (Table table : tables) {
            if (table.getOrder().getOrderStatus().equals(OrderStatus.ACTIVE)) {
                //System.out.println("deliver");

                 kitchen.completeAnOrder(table.getOrder());
            }
        }
    }
}
