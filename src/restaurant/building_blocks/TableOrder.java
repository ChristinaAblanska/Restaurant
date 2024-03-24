package restaurant.building_blocks;

import restaurant.OrderStatus;
import restaurant.building_blocks.employee.Waiter;

import java.util.ArrayList;

public class TableOrder extends ArrayList<Order> {
    private OrderStatus orderStatus;
    private Waiter waiter;

    public void setStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getStatus() {
        return orderStatus;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Waiter getWaiter() {
        return waiter;
    }

}
