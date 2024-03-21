package restaurant.test.test_employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.employee.Cook;

import java.util.ArrayList;
public class Test_Cook {
    public Cook cook;
    public Order order;
    public ProductStorage storage;
    public Recipe recipe1;
    public Recipe recipe2;

    public Meal meal1;
    public Meal meal2;
    public Recipe.SingleRecipe ingredients1 = new Recipe.SingleRecipe();
    public Recipe.SingleRecipe ingredients2 = new Recipe.SingleRecipe();

    public Product yogurt = new ProductPerKilogram("Yogurt", 5);
    public Product eggs = new EnumerableProduct("Egg", 0.5);
    public Product milk = new ProductPerLitre("Milk", 3);
    public Product cucumber = new ProductPerKilogram("Cucumber", 1);
    public Product walnuts = new ProductPerKilogram("Walnuts", 20);

    public Product rosemary = new ProductPerKilogram("Rosemary", 20);


    @Before
    public void storageSetup() {
        storage = new ProductStorage();

        storage.addProductPerKilogram(yogurt, 15);
        storage.addEnumerableProduct(eggs, 50);
        storage.addProductPerLiter(milk, 50);
        storage.addProductPerKilogram(cucumber, 20);
        storage.addProductPerKilogram(walnuts, 5);
    }

    @Before
    public void recipeSetup() {
        recipe1 = new Recipe(ingredients1, 15);
        recipe1.addIngredient(yogurt, 300);
        recipe1.addIngredient(eggs, 3);
        recipe1.addIngredient(milk, 700);

        recipe2 = new Recipe(ingredients2, 10);
        recipe2.addIngredient(cucumber, 300);
        recipe2.addIngredient(walnuts, 100);
    }

    @Before
    public void mealSetup() {
        meal1 = new Meal(recipe1);
        meal2 = new Meal(recipe2);
    }

    @Test
    public void testCookSingleMealReturn() throws ProductOutOfStockException {
        Order order = new Order();
        cook = new Cook(order, storage);
        order.addMeal(meal1, 1);
        Meal newMeal = cook.cookSingleMeal(meal1.getRecipe(), storage);
        Assert.assertEquals(meal1.getRecipe(), newMeal.getRecipe());
    }

    @Test
    public void testCookSingleMealStorageUpdate() throws ProductOutOfStockException {
        Order order = new Order();
        order.addMeal(meal1, 1);
        cook = new Cook(order, storage);
        cook.cookSingleMeal(meal1.getRecipe(), storage);
        Assert.assertEquals(14.7, storage.getStock("Yogurt"), 0.0003f);
        Assert.assertEquals(47, storage.getStock("Egg"),0.0003f);
        Assert.assertEquals(49.3, storage.getStock("Milk"), 0.0003f);
    }

    @Test
    public void testCookMealStorageUpdate() throws ProductOutOfStockException {
        Order order = new Order();
        cook = new Cook(order, storage);
        order.addMeal(meal1, 2);
        order.addMeal(meal2, 2);
        cook.cookMeals();

        Assert.assertEquals(14.4, storage.getStock("Yogurt"), 0.0003f);
        Assert.assertEquals(44, storage.getStock("Egg"),0.0003f);
        Assert.assertEquals(48.6, storage.getStock("Milk"), 0.0003f);
        Assert.assertEquals(19.4, storage.getStock("Cucumber"), 0.0003f);
        Assert.assertEquals(4.8, storage.getStock("Walnuts"), 0.0003f);
    }

    @Test
    public void testCookMealReturnValue() throws ProductOutOfStockException {
        Order order = new Order();
        System.out.println(order.getOrderStatus());
        cook = new Cook(order, storage);
        order.addMeal(meal1, 2);
        order.addMeal(meal2, 2);
        System.out.println(order.getOrderStatus());
        ArrayList<Meal> testResult = cook.cookMeals();
        System.out.println(order.getOrderStatus());

        Assert.assertEquals(4, testResult.size());
        Assert.assertEquals(recipe1, testResult.get(0).getRecipe());
        Assert.assertEquals(meal1.getRecipe(), testResult.get(1).getRecipe());
        Assert.assertEquals(meal2.getRecipe(), testResult.get(2).getRecipe());
        Assert.assertEquals(meal2.getRecipe(), testResult.get(3).getRecipe());
    }

}