
package restaurant.building_blocks.employee;

import restaurant.OrderStatus;
import restaurant.OrderStatus;
import restaurant.WorkDay;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.TableOrder;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
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

    public ArrayList<Meal> cookMeals(Order order) throws ProductOutOfStockException {
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        ArrayList<Meal> result = new ArrayList<>();
        for (Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()) {
            for (int i = 0; i < meal.getValue(); i++) {
                Meal newMeal = cookSingleMeal(meal.getKey().getRecipe(), storage);
                result.add(newMeal);
            }
        }
        order.setOrderStatus(OrderStatus.COMPLETED);
        return result;
    }

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