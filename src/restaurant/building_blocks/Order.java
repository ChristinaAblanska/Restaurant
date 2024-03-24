package restaurant.building_blocks;

import restaurant.OrderStatus;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {
    OrderStatus orderStatus;
    private final HashMap<Meal, Integer> meals;
    private final HashMap<Beverage, Integer> beverages;
    private final int orderID;

    private static int orderIDcount = 10_000;

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    private String completeTime;

    public Order() {
        this.orderStatus = OrderStatus.BLANK;
        this.meals = new HashMap<>();
        this.beverages = new HashMap<>();
        orderID = orderIDcount++;
    }

    public Order(HashMap<Meal, Integer> meals, HashMap<Beverage, Integer> beverages) {
        this.meals = meals;
        this.beverages = beverages;
        this.orderID = orderIDcount++;
    }

    public HashMap<Meal, Integer> getMeals() {
        return meals;
    }

    public boolean containsMeal (String name) {
        boolean result = false;

        for (Map.Entry<Meal, Integer> entry : meals.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Meal getMeal(String name) {
        Meal meal = new Meal();

        for (Map.Entry<Meal, Integer> entry : meals.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                meal = entry.getKey();
                break;
            }
        }

        return meal;
    }

    public Beverage getBeverage(String name) {
        Beverage beverage = new Beverage(name, 0.0);

        for (Map.Entry<Beverage, Integer> entry : beverages.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                beverage = entry.getKey();
                break;
            }
        }

        return beverage;
    }

    public boolean containsBeverage (String name) {
        boolean result = false;

        for (Map.Entry<Beverage, Integer> entry : beverages.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                result = true;
                break;
            }
        }
        return result;
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


    public String getCompleteTime() {
        return completeTime;
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

    public String toString1() {
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

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("            Meals:").append("\n");
        for (Map.Entry<Meal, Integer> record : meals.entrySet()) {
            double price = Math.round(record.getKey().getPrice() * 100.0) / 100.0;
            int count1 = 36 - (record.getKey().getName().length());
            int count2 = 10 - String.valueOf(price).length();
            int count3 = 6 - String.valueOf(record.getValue()).length();
            data.append("                 | ")
                    .append(record.getKey().getName()).append(" ".repeat(count1)).append(" | ")
                    .append(" ".repeat(count2)).append(price).append(" lv | ")
                    .append(" ".repeat(count3)).append(record.getValue()).append(" pcs |").append("\n");
        }
        data.append("\n");
        data.append("        Beverages:").append("\n");

        for (Map.Entry<Beverage, Integer> record : beverages.entrySet()) {
            double price = Math.round(record.getKey().getPrice() * 100.0) / 100.0;
            int count1 = 36 - (record.getKey().getName().length());
            int count2 = 10 - String.valueOf(price).length();
            int count3 = 6 - String.valueOf(record.getValue()).length();
            data.append("                 | ")
                    .append(record.getKey().getName()).append(" ".repeat(count1)).append(" | ")
                    .append(" ".repeat(count2)).append(price).append(" lv | ")
                    .append(" ".repeat(count3)).append(record.getValue()).append(" pcs |").append("\n");
        }

        return String.valueOf(data);
    }

    public boolean isEmpty() {
        return meals.isEmpty() && beverages.isEmpty();
    }

    public int getOrderID() {
        return orderID;
    }
}
