
package restaurant.building_blocks.employee;

import restaurant.building_blocks.Order;
import restaurant.building_blocks.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.room.kitchen.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.ProductStorage;

import java.util.ArrayList;
import java.util.Map;

public class Cook extends Employee {

    public ArrayList<Meal> cookMeal(Order order, ProductStorage storage) throws ProductOutOfStockException {
        ArrayList<Meal> cookedMeals = new ArrayList<>();
        for (Meal meal : order.getMeals()) {
            Meal newMeal = cookMealsmall(meal.getRecipe(), storage);
            newMeal.setName(meal.getName());
            cookedMeals.add(newMeal);
        }
        return cookedMeals;
    }

    private Meal cookMealsmall(Recipe recipe, ProductStorage storage) throws ProductOutOfStockException {
        for (Map.Entry<Product, Integer> entry : recipe.getIngredients().entrySet()) {
            try {
                storage.getProduct(entry.getKey(), entry.getValue());
            } catch (ProductOutOfStockException e) {
                System.out.println("Недостатъчна наличност!");
            }
        }
        return new Meal(recipe);
    }
}