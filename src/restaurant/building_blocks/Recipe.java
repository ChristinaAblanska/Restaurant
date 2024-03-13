package restaurant.building_blocks;

import java.util.HashMap;
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
        for (Map.Entry<Product, Integer> ingredient : this.ingredients.entrySet()) {
            double  pricePerUnit = ingredient.getKey().getPricePerUnit();
            Product.Unit unit = ingredient.getKey().getUnit();
//            if (Product.Unit.Брой.equals(unit)) {
//                price += ingredient.getValue() * pricePerUnit;
//            } else
            price += ingredient.getValue() * (pricePerUnit * unit.getValue());
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
