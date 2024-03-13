//package restaurant.test.test_food;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import restaurant.building_blocks.Product;
//import restaurant.building_blocks.Recipe;
//import restaurant.building_blocks.food.Meal;
//import restaurant.building_blocks.room.kitchen.ProductStorage;
//
//public class Test_Meal {
//    public ProductStorage storage;
//    public Recipe recipe;
//    public Recipe.SingleRecipe ingredients;
//    public Meal meal;
//
//    public Product yogurt = new Product("Кисело мляко", Product.Unit.Грам, 3);
//    public Product cucumber = new Product("Краставица", Product.Unit.Грам, 1);
//    public Product walnuts = new Product("Орехи", Product.Unit.Грам, 2);
//    public Product garlic = new Product("Чесън", Product.Unit.Брой, 10);
//
//    @Before
//    public void storageSetup() {
//        storage = new ProductStorage();
//
//        storage.addProduct(yogurt, 1000);
//        storage.addProduct(cucumber, 2000);
//        storage.addProduct(walnuts, 1000);
//        storage.addProduct(garlic, 500);
//    }
//
//    @Before
//    public void singleRecipeSetup() {
//        ingredients = new Recipe.SingleRecipe();
//        ingredients.put(yogurt, 200);
//        ingredients.put(cucumber, 50);
//        ingredients.put(walnuts, 20);
//        ingredients.put(garlic, 10);
//    }
//
//    @Before
//    public void recipeSetup() {
//        recipe = new Recipe(ingredients, 15);
//    }
//
//    @Test
//    public void testNewBlankMeal() {
//        meal = new Meal();
//        Assert.assertEquals("", meal.getName());
//        Assert.assertEquals(null, meal.getRecipe());
//        Assert.assertEquals(0.0, meal.getPrice(), 0.0003f);
//    }
//
//    @Test
//}
