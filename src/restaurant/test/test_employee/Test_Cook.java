package restaurant.test.test_employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.employee.Employee;
import restaurant.building_blocks.room.kitchen.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.ProductStorage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.employee.Cook;
import restaurant.building_blocks.Order;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.HashMap;

public class Test_Cook {
    public ProductStorage storage;
    public Recipe recipe;

    public Meal meal;
    public Beverage drink;
    public Order order;

    public Cook cook = new Cook();


    public Product yogurt = new Product("Кисело мляко", Product.Unit.Грам, 3);
    public Product cucumber = new Product("Краставица", Product.Unit.Грам, 1);
    public Product walnuts = new Product("Орехи", Product.Unit.Грам, 2);
    public Product garlic = new Product("Чесън", Product.Unit.Грам, 1);

    @Before
    public void storageSetup() {
        storage = new ProductStorage();

        storage.addProduct(yogurt, 1000);
        storage.addProduct(cucumber, 2000);
        storage.addProduct(walnuts, 1000);
        storage.addProduct(garlic, 500);
    }

    @Before
    public void recipeSetup() {
        Recipe.SingleRecipe ingredients = new Recipe.SingleRecipe();
        ingredients.put(yogurt, 100);
        ingredients.put(cucumber, 50);
        ingredients.put(walnuts, 20);
        ingredients.put(garlic, 10);

        recipe = new Recipe(ingredients, 0.2);
    }

    @Before
    public void mealSetup() {
        meal = new Meal("Таратор", recipe);
    }

    @Before
    public void beverageSetup() {
        drink = new Beverage("Сок", 2.5);
    }

    @Before
    public void orderSetup() {
        order = new Order();
        order.addMeal(meal, 3);
        order.addDrink(drink, 2);
    }

    @Test
    public void testCookSingleMeal() throws ProductOutOfStockException {
        Meal result = new Meal(recipe);
        Assert.assertEquals(result, cook.cookSingleMeal(recipe, storage));
    }








}
