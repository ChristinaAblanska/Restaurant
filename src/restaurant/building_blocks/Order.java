package restaurant.building_blocks;


import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    public HashMap<Meal, Integer> meals;
    public HashMap<Beverage, Integer> beverages;
    public int orderID;

    public static int orderIDcount = 10_000;

    public Order() {
        this.meals = new HashMap<>();
        this.beverages = new HashMap<>();
        this.orderID = orderIDcount++;
    }

//    public Order(HashMap<Meal, Integer> meals, HashMap<Beverage, Integer> beverages) {
//        this.meals = meals;
//        this.beverages = beverages;
//        this.orderID = orderIDcount++;
//    }

    public HashMap<Meal, Integer> getMeals() {
        return meals;
    }

    public HashMap<Beverage, Integer> getDrinks() {
        return beverages;
    }

    public int getOrderID() {
        return orderIDcount;
    }

    public void addMeal(Meal meal, int count) {
        if (count == 0) return;
        meals.put(meal, count);
    }

    public void addDrink(Beverage beverage, int count) {
        if (count == 0) return;
        beverages.put(beverage, count);
    }

    public void adjustMealAmount(Meal meal, int count) {
        if (meals.containsKey(meal)) {
            meals.put(meal, count);
        } else return;
    }

    public void adjustDrinkAmount(Beverage drink, int count) {
        if (beverages.containsKey(drink)) {
            beverages.put(drink, count);
        } else return;
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
