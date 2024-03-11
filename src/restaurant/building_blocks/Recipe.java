package restaurant.building_blocks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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
        Iterator<Map.Entry<Product, Integer>> iterator = ingredients.entrySet().iterator();
        while (iterator.hasNext()) {
            double  pricePerUnit = iterator.next().getKey().getPricePerUnit();
            price += iterator.next().getValue() *  pricePerUnit;
        }
        return price;
    }

    void addIngredient(Product product, int quantity) {
        ingredients.put(product, quantity);
    }

    public HashMap<Product, Integer> getIngredients() {
        return ingredients;
    }

    public double getPrepTime() {
        return prepTime;
    }
}