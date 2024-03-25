package restaurant.building_blocks.food;

import restaurant.Main;
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
        this.recipe = new Recipe(new Recipe.Ingredients(), 0,"");
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

    public double calculatePriceProfit() {
        double ingredientPrice = recipe.calculatePrice();
        double profit = ingredientPrice * Main.PROFIT; // Constant profit
//        double tips = (ingredientPrice + profit) * Main.TIPS; // Constant tips
        return ingredientPrice + profit; // + tips;
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" - ").append(String.format("%.2f",price)+" lv.");
        return result.toString();
    }
}