package restaurant.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.building_blocks.Product;
import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.room.kitchen.ProductStorage;

public class Test_Recipe {
    public ProductStorage storage;
    public Recipe recipe;

    public Recipe.SingleRecipe ingredients;

    public Product yogurt = new Product("Кисело мляко", Product.Unit.Грам, 5);
    public Product cucumber = new Product("Краставица", Product.Unit.Грам, 1);
    public Product walnuts = new Product("Орехи", Product.Unit.Грам, 2);
    public Product garlic = new Product("Чесън", Product.Unit.Брой, 10);
    public Product milk = new Product("Мляко", Product.Unit.Милилитър, 10);

    @Before
    public void storageSetup() {
        storage = new ProductStorage();

        storage.addProduct(yogurt, 1);
        storage.addProduct(cucumber, 2000);
        storage.addProduct(walnuts, 1000);
        storage.addProduct(garlic, 500);
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
        ingredients.put(garlic, 10);
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
        recipe.getIngredients().put(garlic, 2); // per piece
        recipe.getIngredients().put(yogurt, 200); // per gram/ml
        recipe.getIngredients().put(milk, 2); // per gram/ml
        Assert.assertEquals(50.0, recipe.calculatePrice(), 0.0003f);
    }

    @Test
    public void testAddIngredientToRecipe() {
        recipe = new Recipe(ingredients, 15);
        ingredients.put(yogurt, 200);
        recipe.addIngredient(yogurt, 200);
        Assert.assertEquals(ingredients, recipe.getIngredients());
    }
}
