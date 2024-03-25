
package restaurant.building_blocks.person.employee;

import restaurant.building_blocks.order.OrderStatus;
import restaurant.simulation.WorkDay;
import restaurant.building_blocks.order.Order;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.order.TableOrder;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.recipe.Recipe;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.kitchen.storage.ProductStorage;

import java.util.ArrayList;
import java.util.Map;

public class Cook extends Employee implements Runnable {

    private final TableOrder tableOrder;
    private final ProductStorage storage;

    public Cook(TableOrder tableOrder, ProductStorage storage, double salary) {
        this.tableOrder = tableOrder;
        this.storage = storage;
        this.salary = salary;
    }

    public ArrayList<Meal> cookMeals(Order order) {

        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        ArrayList<Meal> result = new ArrayList<>();
        for (Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()) {
            for (int i = 0; i < meal.getValue(); i++) {
                Meal newMeal = null;
                try {
                    newMeal = cookSingleMeal(meal.getKey().getRecipe(), storage);
                    order.setOrderStatus(OrderStatus.COMPLETED);
                } catch (ProductOutOfStockException e) {
                    order.setOrderStatus(OrderStatus.REVOKE_BY_KITCHEN);
                    //throw new RuntimeException(e);
                }
                result.add(newMeal);
            }
        }
        return result;
    }

    public Meal cookSingleMeal(Recipe recipe, ProductStorage storage) throws ProductOutOfStockException {
        for (Map.Entry<Product, Integer> entry : recipe.getIngredients().entrySet()) {

            if (entry.getKey() instanceof ProductPerKilogram) {
                try {
                    storage.getProductPerGram(entry.getKey(), entry.getValue());
                } catch (ProductOutOfStockException e) {
                    throw new ProductOutOfStockException("Product out of stock! " + entry.getKey().getName());
                }
            } else if (entry.getKey() instanceof ProductPerLitre) {
                try {
                    storage.getProductPerMilliliter(entry.getKey(), entry.getValue());
                } catch (ProductOutOfStockException e) {
                    throw new ProductOutOfStockException("Product out of stock! " + entry.getKey().getName());
                }
            } else if (entry.getKey() instanceof EnumerableProduct) {
                try {
                    storage.getEnumerableProduct(entry.getKey(), entry.getValue());
                } catch (ProductOutOfStockException e) {
                    throw new ProductOutOfStockException("Product out of stock! " + entry.getKey().getName());
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
            cookMeals(order);
        }

        //here must delay using the meal with maximum cook time
        try {
            Thread.sleep(WorkDay.minutesToLocalMinutes(tableOrder.getTotalCookTime()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tableOrder.setStatus(OrderStatus.COMPLETED);
        synchronized (tableOrder) {
            tableOrder.notify();
        }
    }
}