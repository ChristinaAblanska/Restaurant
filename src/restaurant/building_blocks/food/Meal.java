package restaurant.building_blocks.food;

import restaurant.building_blocks.Recipe;

public class Meal {
    private String name;
    private final Recipe recipe;
    //price plus profit
    private final double price;

    void consume() {
        System.out.println("The meal is consumed!");
    }

    public Meal() {
        this.name = "";
        this.recipe = null;
        this.price = 0;
    }
    public Meal(Recipe recipe) {
        this.name = "";
        this.recipe = recipe;
        this.price = calculatePriceProfit();
    }
    public Meal(String name, Recipe recipe) {
        this.name = name;
        this.recipe = recipe;
        this.price = calculatePriceProfit();
    }

    private double calculatePriceProfit() {
        double ingredientPrice = recipe.calculatePrice();
        double profit = ingredientPrice * 0.5; //Constant
        return ingredientPrice + profit;
    }

    public double getPrice() {
        return price;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}