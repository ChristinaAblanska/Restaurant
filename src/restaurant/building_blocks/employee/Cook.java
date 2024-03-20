
package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.WorkDay;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

import java.util.ArrayList;
import java.util.Map;

public class Cook extends Employee implements Runnable {

    private final Order order;
    private final ProductStorage storage;

    public Cook(Order order, ProductStorage storage) {
        super();
        this.order = order;
        this.storage = storage;
    }

    public ArrayList<Meal> cookMeal() throws ProductOutOfStockException {
        ArrayList<Meal> cookedMeals = new ArrayList<>();
        for (Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()) {
            Meal newMeal = cookMealsmall(meal.getKey().getRecipe(), storage);
            newMeal.setName(meal.getKey().getName());
            cookedMeals.add(newMeal);
        }
        return cookedMeals;
    }

    private Meal cookMealsmall(Recipe recipe, ProductStorage storage) throws ProductOutOfStockException {
        for (Map.Entry<Product, Integer> entry : recipe.getIngredients().entrySet()) {
           /* try {
                storage.getProduct(entry.getKey(), Product.Unit.Брой, entry.getValue());
            } catch (ProductOutOfStockException e) {
                System.out.println("Недостатъчна наличност!");
            }*/
        }
        return new Meal(recipe);
    }

    @Override
    public void run() {

        synchronized (order) {
            while (!order.getOrderStatus().equals(OrderStatus.IN_PROGRESS)) {
                try {
                    order.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        order.setOrderStatus(OrderStatus.COMPLETED);
        order.setCompleteTime(WorkDay.getTime().toString());
        synchronized (order) {
            order.notify();
        }
    }
}