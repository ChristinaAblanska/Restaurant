
package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.WorkDay;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.TableOrder;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

import java.util.ArrayList;
import java.util.Map;

public class Cook extends Employee implements Runnable {

    private final TableOrder tableOrder;
    private final ProductStorage storage;

    public Cook(TableOrder tableOrder, ProductStorage storage) {
        this.tableOrder = tableOrder;
        this.storage = storage;
    }

  /*  public ArrayList<Meal> cookMeal() throws ProductOutOfStockException {
        ArrayList<Meal> cookedMeals = new ArrayList<>();
        for (Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()) {
            Meal newMeal = cookMealsmall(meal.getKey().getRecipe(), storage);
            newMeal.setName(meal.getKey().getName());
            cookedMeals.add(newMeal);
        }
        return cookedMeals;
    }*/

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

        synchronized (tableOrder) {
            while (!tableOrder.getStatus().equals(OrderStatus.IN_PROGRESS)) {
                try {
                    tableOrder.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for (Order order : tableOrder) {
            order.setOrderStatus(OrderStatus.COMPLETED);
        }
        //here must delay using the meal with maximum cook time
        try {
            Thread.sleep(WorkDay.minutesToLocalTime(20));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tableOrder.setStatus(OrderStatus.COMPLETED);
        synchronized (tableOrder) {
            tableOrder.notify();
        }
    }
}