package restaurant.building_blocks;


import restaurant.OrderStatus;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

import java.util.HashMap;
import java.util.Map;

public class Order {
    OrderStatus orderStatus;
    private HashMap<Meal, Integer> meals;
    private HashMap<Beverage, Integer> beverages;
    private int orderID;

    private static int orderIDcount = 10_000;
    private String acceptTime;

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    private String completeTime;

    public double getAcceptTimeMillis() {
        return acceptTimeMillis;
    }

    private double acceptTimeMillis;

    public Order() {
        this.orderStatus = OrderStatus.BLANK;
        this.meals = null;
        this.beverages = null;
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

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public String getAcceptTime() {
        return acceptTime;
    }
}
