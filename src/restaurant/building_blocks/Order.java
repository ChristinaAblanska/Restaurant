package restaurant.building_blocks;


import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private HashMap<Meal, Integer> meals;
    private HashMap<Beverage, Integer> beverages;
    private int orderID;

    private static int orderIDcount = 10_000;

    public Order() {
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
        for(Map.Entry<Meal, Integer> meal : meals.entrySet()){
            price += (meal.getKey().getPrice() * meal.getValue());
        }
        for(Map.Entry<Beverage, Integer> drink : beverages.entrySet()){
            price += (drink.getKey().getPrice() * drink.getValue());
        }
        return price;
    }

}