package restaurant.building_blocks.menu;

import restaurant.building_blocks.recipe.RecipeGenerator;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    //Задължително меню, което да има поне 10 ястия/напитки.
    //Ястията са с определен грамаж и количествата са ограничени. Напитките също да са ограничени.

    private final List<Meal> meals;
    private final List<Beverage> beverages;

    private static final RecipeGenerator recipeGenerator = new RecipeGenerator();

    public RestaurantMenu() {
        meals = new ArrayList<>();
        meals.add(new Meal("Green Salad", recipeGenerator.generateGreenSalad()));
        meals.add(new Meal("Cabbage and Carrots", recipeGenerator.generateCabbageCarrotSalad()));
        meals.add(new Meal("Shopska Salad", recipeGenerator.generateShopskaSalad()));
        meals.add(new Meal("Shepard's Salad", recipeGenerator.generateShepardSalad()));
        meals.add(new Meal("Tarator", recipeGenerator.generateTarator()));
        meals.add(new Meal("Lentil Soup", recipeGenerator.generateLentilSoup()));
        meals.add(new Meal("Beef Soup", recipeGenerator.generateBeefSoup()));
        meals.add(new Meal("Chicken Soup", recipeGenerator.generateChickenSoup()));
        meals.add(new Meal("Fried Eggs", recipeGenerator.generateFriedEggs()));
        meals.add(new Meal("Beans Stew", recipeGenerator.generateBeansStew()));
        meals.add(new Meal("Baked Cheese", recipeGenerator.generateBakedCheese()));
        meals.add(new Meal("Potato Cake", recipeGenerator.generatePotatoCake()));
        meals.add(new Meal("Musaka", recipeGenerator.generateMusaka()));
        meals.add(new Meal("Kapama", recipeGenerator.generateKapama()));
        meals.add(new Meal("Chicken risotto", recipeGenerator.generateChickenRice()));
        meals.add(new Meal("Stuffed Peppers with sauce", recipeGenerator.generateStuffedPeppers()));
        meals.add(new Meal("Baklava", recipeGenerator.generateBaklava()));
        meals.add(new Meal("Tolumbichki", recipeGenerator.generateTolumbichki()));
        meals.add(new Meal("Cookie Cake", recipeGenerator.generateCookieCake()));
        meals.add(new Meal("Chocolate pancake", recipeGenerator.generatePancake()));
        beverages = new ArrayList<>();
        beverages.add(new Beverage("Juice", 4.40));
        beverages.add(new Beverage("Lemonade", 5.80));
        beverages.add(new Beverage("Soft Drink", 3.20));
        beverages.add(new Beverage("Beer", 6.20));
    }

    public void print() {
        System.out.println("Meals");
        for (int i = 0; i < meals.size(); i++) {
            System.out.println(meals.get(i).toString());
        }
        System.out.println("Beverages");
        for (int i = 0; i < beverages.size(); i++) {
            System.out.println(beverages.get(i).toString());
        }
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }
}
