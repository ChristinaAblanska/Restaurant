package restaurant.building_blocks;


import restaurant.OrderStatus;
import restaurant.building_blocks.employee.Waiter;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.room.kitchen.storage.shaft.EnumerableShaft;
import restaurant.building_blocks.room.kitchen.storage.shaft.Shaft;
import restaurant.building_blocks.room.kitchen.storage.shaft.ShaftPerKilogram;
import restaurant.building_blocks.room.kitchen.storage.shaft.ShaftPerLiter;

import java.util.HashMap;
import java.util.Map;

public class Order {
    OrderStatus orderStatus;
    private final HashMap<Meal, Integer> meals;
    private final HashMap<Beverage, Integer> beverages;
    private int orderID;

    private static int orderIDcount = 10_000;

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    private String completeTime;

    public Order() {
        this.orderStatus = OrderStatus.BLANK;
        this.meals = new HashMap<>();
        this.beverages = new HashMap<>();
        this.orderID = orderIDcount++;
    }

    public Order(HashMap<Meal, Integer> meals, HashMap<Beverage, Integer> beverages) {
        this.meals = meals;
        this.beverages = beverages;
        this.orderID = orderIDcount++;
    }

    public HashMap<Meal, Integer> getMeals() {
        return meals;
    }

    public HashMap<Beverage, Integer> getDrinks() {
        return beverages;
    }

    public boolean addMeal(Meal meal, int count) {
        int size = meals.size();
        meals.put(meal, count);
        return meals.size() == size + 1;
    }

    public boolean addDrink(Beverage beverage, int count) {
        int size = beverages.size();
        beverages.put(beverage, count);
        return beverages.size() == size + 1;
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Map.Entry<Meal, Integer> meal : meals.entrySet()) {
            price += (meal.getKey().getPrice() * meal.getValue());
        }
        for (Map.Entry<Beverage, Integer> drink : beverages.entrySet()) {
            price += (drink.getKey().getPrice() * drink.getValue());
        }
        return price;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("            Meals:").append("\n");
        for (Map.Entry<Meal, Integer> record : meals.entrySet()) {
            data.append("      ").append(record.getKey()).append("-").append(record.getValue()).append(" pcs.").append("\n");
        }
        data.append("            Beverages:").append("\n");
        for (Map.Entry<Beverage, Integer> record : beverages.entrySet()) {
            data.append("      ").append(record.getKey()).append("-").append(record.getValue()).append(" pcs.").append("\n");
        }
        return String.valueOf(data);
    }
}
