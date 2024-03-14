package restaurant.building_blocks;

import java.util.HashMap;
import java.util.Map;
import restaurant.building_blocks.product.*;


public class Recipe {
    // Type of product / required quantity
    private final SingleRecipe ingredients;
    private final double prepTime;

    public Recipe(SingleRecipe ingredients, double prepTime) {
        this.ingredients = ingredients;
        this.prepTime = prepTime;
    }

    public static class SingleRecipe extends HashMap<Product, Integer>{
        private HashMap<Product, Integer> ingredients;
    }

    public double calculatePrice(){
        double price = 0;
        for (Map.Entry<Product, Integer> ingredient : this.ingredients.entrySet()) {
            double pricePerUnit = 0.0;
            if (ingredient.getKey() instanceof ProductPerKilogram || ingredient.getKey() instanceof ProductPerLitre) {
                pricePerUnit = (ingredient.getKey().getPrice()) / 1000;
            } else pricePerUnit = ingredient.getKey().getPrice();
            price += ingredient.getValue() * pricePerUnit;
        }
        return price;
    }

    public void addIngredient(Product product, int quantity) {
        ingredients.put(product, quantity);
    }

    public SingleRecipe getIngredients() {
        return ingredients;
    }

    public double getPrepTime() {
        return prepTime;
    }
}