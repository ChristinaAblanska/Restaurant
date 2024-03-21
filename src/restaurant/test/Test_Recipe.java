package restaurant.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

import java.util.HashMap;

public class Test_Recipe {
    public ProductStorage storage;
    public Recipe recipe;

    public Recipe.SingleRecipe ingredients;

    public Product yogurt = new ProductPerKilogram("Yogurt",5);
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
    public void singleRecipeSetup() {
        ingredients = new Recipe.SingleRecipe();
    }

    @Before
    public void recipeSetup() {
        recipe = new Recipe(ingredients, 15);
    }

    @Test
    public void testSingleMealEmpty() {
        Assert.assertEquals(0, ingredients.size());
    }

    @Test
    public void testSingleMealSize() {
        ingredients.put(yogurt, 200);
        ingredients.put(cucumber, 50);
        ingredients.put(walnuts, 20);
        ingredients.put(eggs, 10);
        Assert.assertEquals(4, ingredients.size());
    }

    @Test
    public void testRecipeGetters(){
        recipe = new Recipe(ingredients, 15);
        recipe.getIngredients().put(yogurt, 200);
        ingredients.put(yogurt, 200);
        Assert.assertEquals(ingredients, recipe.getIngredients());
        Assert.assertEquals(15.0, recipe.getPrepTime(), 0.0003f);
    }

    @Test
    public void testCalculatePrice() {
        recipe = new Recipe(ingredients, 15);
        recipe.getIngredients().put(eggs, 2); // per piece
        recipe.getIngredients().put(yogurt, 200); // per gram/ml
        recipe.getIngredients().put(milk, 50); // per gram/ml
        recipe.getIngredients().put(rosemary, 1);
        Assert.assertEquals(2.17, recipe.calculatePrice(), 0.0003f);
    }

    @Test
    public void testAddIngredientToRecipe() {
        recipe = new Recipe(ingredients, 15);
        ingredients.put(yogurt, 200);
        recipe.addIngredient(yogurt, 200);
        Assert.assertEquals(ingredients, recipe.getIngredients());
    }
}