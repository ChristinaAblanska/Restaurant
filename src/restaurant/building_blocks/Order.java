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

    public int getOrderID() {
        return orderID;
    }

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

    public void addMeal(Meal meal, int count) {
        if (this.orderStatus == OrderStatus.BLANK) {
            this.orderStatus = OrderStatus.ACTIVE;
        }
        if (count == 0) return;
        meals.put(meal, count);
    }

    public void addDrink(Beverage beverage, int count) {
        if (this.orderStatus == OrderStatus.BLANK) {
            this.orderStatus = OrderStatus.ACTIVE;
        }
        if (count == 0) return;
        beverages.put(beverage, count);
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

    public void adjustMealAmount(Meal meal, int count) {
        if (meals.containsKey(meal)) {
            meals.put(meal, count);
        }
    }

    public void adjustDrinkAmount(Beverage drink, int count) {
        if (beverages.containsKey(drink)) {
            beverages.put(drink, count);
        }
    }

    public String toString() {
        // 38
        StringBuilder result = new StringBuilder();
        result.append("--------------- #").append(orderID).append(" ---------------\n")
               .append("                                      \n");

        for (Map.Entry<Meal, Integer> entry : meals.entrySet()) {
            int count = 36 - (entry.getKey().getName().length()) - String.valueOf(entry.getValue()).length();
            result.append(entry.getKey().getName()).append(" ".repeat(count))
                    .append("x ").append(entry.getValue()).append("\n");
        }
        for (Map.Entry<Beverage, Integer> entry : beverages.entrySet()) {
            int count = 36 - (entry.getKey().getName().length()) - String.valueOf(entry.getValue()).length();
            result.append(entry.getKey().getName()).append(" ".repeat(count))
                    .append("x ").append(entry.getValue()).append("\n");
        }
        result.append("\n--------------------------------------\n");
        return result.toString();
    }

    public boolean isEmpty() {
        return meals.isEmpty() && beverages.isEmpty();
    }
}