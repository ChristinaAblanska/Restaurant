package restaurant.building_blocks;

import restaurant.OrderStatus;
import restaurant.building_blocks.employee.Waiter;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.room.kitchen.storage.shaft.Shaft;

import java.util.ArrayList;
import java.util.Map;

public class TableOrder extends ArrayList<Order> implements Cloneable {
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

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Order ord : this) {
            for (Map.Entry<Meal, Integer> entry : ord.getMeals().entrySet()) {
                data.append(entry.getKey()).append("\n");
            }
        }
        return String.valueOf(data);
    }

    public void truncate() {
        this.clear();
    }

    public int getTotalCookTime() {
        double maxCookTime = 0.0;
        for (Order ord : this) {
            for (Map.Entry<Meal, Integer> ingredient : ord.getMeals().entrySet()) {
                if (ingredient.getKey().getRecipe().getPrepTime() > maxCookTime) {
                    maxCookTime = ingredient.getKey().getRecipe().getPrepTime();
                }
            }
        }
        return (int) maxCookTime;
    }

    @Override
    public TableOrder clone() {
        TableOrder orders = new TableOrder();

        for (int i = 0; i < size(); i++) {
            Order ord = new Order();

            for (Map.Entry<Meal, Integer> entry : this.get(i).getMeals().entrySet()) {

                ord.getMeals().put(entry.getKey(), entry.getValue());
                ord.setOrderStatus(get(i).getOrderStatus());
            }
            orders.add(ord);
        }
        return orders;
    }
}
