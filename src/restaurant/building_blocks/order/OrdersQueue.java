package restaurant.building_blocks.order;

import restaurant.building_blocks.order.Order;

import java.util.*;

public class OrdersQueue {
    private ArrayList<Order> orders;

    public OrdersQueue () {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrderQueue() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean removeOrder(int id) {
        boolean result = false;
        for (Order order : orders) {
            if (order.getOrderID() == id) {
                orders.remove(order);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean containsOrder(int id) {
        boolean result = false;
        for (Order order : orders) {
            if (order.getOrderID() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Order getOrder(int id) {
        Order resultOrder = new Order();
        for (Order order : orders) {
            if (order.getOrderID() == id) {
                resultOrder = order;
                break;
            }
        }
        return resultOrder;
    }

    public int getSze() {
        return orders.size();
    }

    public Order getOrderElement(int i) {
        return orders.get(i);
    }
}
