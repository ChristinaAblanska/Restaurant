
package restaurant.building_blocks.employee;

import restaurant.building_blocks.Order;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class Cook extends Employee {

    public void cookMeals(Order order, ProductStorage storage) throws ProductOutOfStockException {
        for (Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()) {
            for (int i = 0; i < meal.getValue(); i++) {
                Meal newMeal = cookSingleMeal(meal.getKey().getRecipe(), storage);
            }
        }
    }

    // Not adding correct values to the array
//    public ArrayList<Meal> cookMeals(Order order, ProductStorage storage) throws ProductOutOfStockException {
//        ArrayList<Meal> cookedMeals = new ArrayList<>();
//        int count = 0;
//        for (Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()) {
//            for (int i = 0; i < meal.getValue(); i++) {
//                Meal newMeal = cookSingleMeal(meal.getKey().getRecipe(), storage);
////                newMeal.setName(meal.getKey().getName());
//                cookedMeals.add(newMeal);
//                count++;
//                System.out.println("Meal cooked" + i + "\n");
//            }
//        }
//        System.out.println(count);
//        return cookedMeals;
//    }

    public Meal cookSingleMeal(Recipe recipe, ProductStorage storage) throws ProductOutOfStockException {
        for (Map.Entry<Product, Integer> entry : recipe.getIngredients().entrySet()) {

            if (entry.getKey() instanceof ProductPerKilogram) {
                try {
                    storage.getProductPerGram(entry.getKey(), entry.getValue());
                } catch (ProductOutOfStockException e) {
                    System.out.println("Недостатъчна наличност!");
                }
            } else if (entry.getKey() instanceof ProductPerLitre) {
                try {
                    storage.getProductPerMilliliter(entry.getKey(), entry.getValue());
                } catch (ProductOutOfStockException e) {
                    System.out.println("Недостатъчна наличност!");
                }
            } else if (entry.getKey() instanceof EnumerableProduct) {
                try {
                    storage.getEnumerableProduct(entry.getKey(), entry.getValue());
                } catch (ProductOutOfStockException e) {
                    System.out.println("Недостатъчна наличност!");
                }
            }
        }
        return new Meal(recipe);
    }
}