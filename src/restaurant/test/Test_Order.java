package restaurant.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.Order;

import java.util.Optional;

public class Test_Order {
    public Order order;
    public ProductStorage storage;
    public Recipe recipe1;
    public Recipe recipe2;

    public Beverage drink1;
    public Beverage drink2;

    public Meal meal1;
    public Meal meal2;
    public Recipe.SingleRecipe ingredients1 = new Recipe.SingleRecipe();
    public Recipe.SingleRecipe ingredients2 = new Recipe.SingleRecipe();

    public Product yogurt = new ProductPerKilogram("Yogurt", 5);
    public Product eggs = new EnumerableProduct("Egg", 0.5);
    public Product milk = new ProductPerLitre("Milk", 3);
    public Product cucumber = new ProductPerKilogram("Cucmber", 1);
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
        recipe1.addIngredient(yogurt, 500);
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

    @Before
    public void drinkSetup() {
        drink1 = new Beverage("Juice", 2.5);
        drink2 = new Beverage("Cofee", 3);
    }

    @Test
    public void testNewBlankOrder() {
        order = new Order();
        Assert.assertEquals(10001, order.getOrderID());
    }

    @Test
    public void testAddMeal() {
        order = new Order();
        order.addMeal(meal1, 2);
        Assert.assertTrue(order.getMeals().containsKey(meal1));

        Integer count = 2;
        Assert.assertEquals(count, order.getMeals().get(meal1));
    }

    @Test
    public void testAddDrink() {
        order = new Order();
        order.addDrink(drink1, 1);
        order.addDrink(drink2, 2);
        Assert.assertTrue(order.getDrinks().containsKey(drink1));
        Assert.assertTrue(order.getDrinks().containsKey(drink2));

        Integer value1 = 1;
        Integer value2 = 2;
        Assert.assertEquals(value1, order.getDrinks().get(drink1));
        Assert.assertEquals(value2, order.getDrinks().get(drink2));
    }

    @Test
    public void testAdjustMealAmount() {
        order = new Order();
        order.addMeal(meal1, 2);
        order.adjustMealAmount(meal1, 5);

        Integer count = 5;
        Assert.assertEquals(count, order.getMeals().get(meal1));
    }

    @Test
    public void testAdjustDrinkAmount() {
        order = new Order();
        order.addDrink(drink1, 2);
        order.adjustDrinkAmount(drink1, 5);

        Integer count = 5;
        Assert.assertEquals(count, order.getDrinks().get(drink1));
    }

    @Test
    public void testCalculateTotalPrice() {
        order = new Order();
        order.addMeal(meal1, 2);
        order.addMeal(meal2, 1);
        order.addDrink(drink1, 4);
        order.addDrink(drink2, 2);

        double priceMeal = (meal1.getPrice() * 2) + meal2.getPrice();
        double priceDrink = (drink1.getPrice() * 4) + (drink2.getPrice() * 2);

        Assert.assertEquals((priceMeal + priceDrink), order.calculateTotalPrice(), 0.0003f);

    }

}