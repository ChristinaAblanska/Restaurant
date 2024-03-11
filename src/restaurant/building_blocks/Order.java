package restaurant.building_blocks;


import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

import java.util.ArrayList;

public class Order {
    private ArrayList<Meal> meals;
    private ArrayList<Beverage> beverages;
    private int orderID;

    private static int orderIDcount = 10_000;

    public Order() {
        this.meals = null;
        this.beverages = null;
        this.orderID = orderIDcount++;
    }

    public Order(ArrayList<Meal> meals, ArrayList<Beverage> beverages) {
        this.meals = meals;
        this.beverages = beverages;
        this.orderID = orderIDcount++;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public ArrayList<Beverage> getDrinks() {
        return beverages;
    }

    public void setDrinks(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    boolean addMeal(Meal meal) {
        return meals.add(meal);
    }

    boolean addDrink(Beverage beverage) {
        return beverages.add(beverage);
    }
}
