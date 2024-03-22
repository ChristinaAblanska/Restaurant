package restaurant.building_blocks.employee;

import restaurant.Main;
import restaurant.building_blocks.Order;

public class Waiter {
    public double tip;

    public void addTip(Order order) {
        tip += order.calculateTotalPrice() * Main.TIPS;
    }
}
