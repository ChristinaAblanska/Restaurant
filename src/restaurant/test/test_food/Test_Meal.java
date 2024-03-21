package restaurant.test.test_food;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;
import restaurant.building_blocks.food.Meal;

public class Test_Meal {
    public ProductStorage storage;
    public Recipe recipe;

    Meal meal;
    public Recipe.SingleRecipe ingredients = new Recipe.SingleRecipe();

    public Product yogurt = new ProductPerKilogram("Yogurt", 5);
    public Product cucumber = new ProductPerKilogram("Cucmber", 1);
    public Product walnuts = new ProductPerKilogram("Walnuts", 20);
    public Product eggs = new EnumerableProduct("Egg", 0.5);
    public Product milk = new ProductPerLitre("Milk", 3);

    public Product rosemary = new ProductPerKilogram("Rosemary", 20);

    @Before
    public void storageSetup() {
        storage = new ProductStorage();

        storage.addProductPerKilogram(yogurt, 15);
        storage.addProductPerKilogram(cucumber, 20);
        storage.addProductPerKilogram(walnuts, 5);
        storage.addEnumerableProduct(eggs, 50);
    }



    @Before
    public void recipeSetup() {
        recipe = new Recipe(ingredients, 15);
        recipe.addIngredient(yogurt, 500);
        recipe.addIngredient(eggs, 3);
        recipe.addIngredient(milk, 700);
    }

    @Test
    public void testNewBlankMeal() {
        meal = new Meal();
        Assert.assertEquals("", meal.getName());
        Assert.assertEquals(0.0, meal.getPrice(), 0.0003f);
    }

    @Test
    public void testNoNameRecipeMeal() {
        meal = new Meal(recipe);
        Assert.assertEquals(recipe, meal.getRecipe());
    }

    @Test
    public void testCalculatePriceProfit() {
        meal = new Meal(recipe);
        double price = (recipe.calculatePrice() * 0.5) + recipe.calculatePrice();
        Assert.assertEquals(9.15, meal.getPrice(), 0.0003f);
    }

    @Test
    public void testName() {
        meal = new Meal(recipe);
        Assert.assertEquals("", meal.getName());
        meal.setName("Test Meal");
        Assert.assertEquals("Test Meal", meal.getName());
    }


}