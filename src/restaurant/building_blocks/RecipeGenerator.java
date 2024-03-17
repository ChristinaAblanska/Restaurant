package restaurant.building_blocks;

import restaurant.building_blocks.Recipe;
import restaurant.building_blocks.Recipe.SingleRecipe;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeGenerator {
    public SingleRecipe ingredients;

    // Generating meals

    public ArrayList<Meal> generateRecipes() {
        ArrayList<Meal> result = new ArrayList<>();

        Meal beansStew = new Meal("Боб", generateBeansStew());
        Meal musaka = new Meal("Мусака", generateMusaka());
        Meal kapama = new Meal("Капама", generateKapama());
        Meal friedEggs = new Meal("Яйца по Панагюрски", generateFriedEggs());
        Meal potatoeCake = new Meal("Пататник", generatePotatoCake());
        Meal chickenRice = new Meal("Пиле с ориз", generateChickenRice());
        Meal bakedCheese = new Meal("Сирене по Шопски", generateBakedCheese());
        Meal stuffedPeppersInSause = new Meal("Пълнени чушки с бял сос", generateStuffedPeppers());
        Meal beefSoup = new Meal("Шкембе чорба", generateBeefSoup());
        Meal lentilSoup = new Meal("Леща чорба", generateLentilSoup());
        Meal chickenSoup = new Meal("Пилешка супа", generateChickenSoup());
        Meal shopskaSalad = new Meal("Шопска Салата", generateShopskaSalad());
        Meal shepardsSalad = new Meal("Овчарска Салата", generateShepardSalad());
        Meal cabbageAndCarrotsSalad = new Meal("Салата Зеле и моркови", generateCabbageCarrotSalad());
        Meal greenSalad = new Meal("Зелена Салата", generateGreenSalad());
        Meal tarator = new Meal("Таратор", generateTarator());
        Meal tolumbichki = new Meal("Толумбички", generateTolumbichki());
        Meal baklava = new Meal("Баклава", generateBaklava());
        Meal pancake = new Meal("Палачинка с банан и шоколад", generatePancake());
        Meal cookieCake = new Meal("Бисквитена торта", generateCookieCake());

        result.add(beansStew);
        result.add(musaka);
        result.add(kapama);
        result.add(friedEggs);
        result.add(potatoeCake);
        result.add(chickenRice);
        result.add(bakedCheese);
        result.add(stuffedPeppersInSause);
        result.add(beefSoup);
        result.add(lentilSoup);
        result.add(chickenSoup);
        result.add(shopskaSalad);
        result.add(shepardsSalad);
        result.add(cabbageAndCarrotsSalad);
        result.add(greenSalad);
        result.add(tarator);
        result.add(tolumbichki);
        result.add(baklava);
        result.add(pancake);
        result.add(cookieCake);

        return result;
    }

    // Adding products to the recipes
    public Recipe generateBeansStew() {
        ingredients = new SingleRecipe();
        ingredients.put(beans, 100);
        ingredients.put(bacon, 88);
        ingredients.put(onion, 38);
        ingredients.put(carrots, 50);
        ingredients.put(tomatoes, 50);
        ingredients.put(flour, 7);
        ingredients.put(chilliePepper, 7);
        ingredients.put(mint, 3);
        ingredients.put(savory, 2);
        ingredients.put(salt, 1);
        ingredients.put(blackPepper, 1);

        return new Recipe(ingredients, 35);
    }

    public Recipe generateBakedCheese() {
        ingredients = new SingleRecipe();

        ingredients.put(cheese, 150);
        ingredients.put(eggs, 1);
        ingredients.put(oil, 25);
        ingredients.put(tomatoes, 163);
        ingredients.put(chilliePepper, 20);
        ingredients.put(savory, 3);
        ingredients.put(redPepper, 5);

        return new Recipe(ingredients, 15);
    }

    public Recipe generateBaklava() {
        ingredients = new SingleRecipe();

        ingredients.put(filoDough, 100);
        ingredients.put(pistachio, 75);
        ingredients.put(milk, 188);
        ingredients.put(sugar, 188);
        ingredients.put(butter, 13);
        ingredients.put(cocoa, 13);
        ingredients.put(chocolate, 25);

        return new Recipe(ingredients, 25);
    }

    public Recipe generateBeefSoup() {
        ingredients = new SingleRecipe();

        ingredients.put(beefStomach, 250);
        ingredients.put(milk, 250);
        ingredients.put(oil, 8);
        ingredients.put(butter, 8);
        ingredients.put(redPepper, 2);
        ingredients.put(salt, 1);
        ingredients.put(garlic, 13);
        ingredients.put(vinegar, 25);
        ingredients.put(redPepper, 3);

        return new Recipe(ingredients, 15);
    }

    public Recipe generateCabbageCarrotSalad() {
        ingredients = new SingleRecipe();

        ingredients.put(cabbage, 125);
        ingredients.put(carrots, 63);
        ingredients.put(cucumber, 75);
        ingredients.put(olives, 13);
        ingredients.put(salt, 1);
        ingredients.put(vinegar, 3);
        ingredients.put(oil, 4);

        return new Recipe(ingredients, 10);
    }

    public Recipe generateChickenRice() {
        ingredients = new SingleRecipe();

        ingredients.put(rice, 125);
        ingredients.put(chicken, 150);
        ingredients.put(butter, 15);
        ingredients.put(broth, 250);
        ingredients.put(carrots, 50);
        ingredients.put(onion, 38);

        return new Recipe(ingredients, 25);
    }

    public Recipe generateChickenSoup() {
        ingredients = new SingleRecipe();

        ingredients.put(chicken, 75);
        ingredients.put(onion, 38);
        ingredients.put(carrots, 38);
        ingredients.put(noodles, 25);
        ingredients.put(salt, 1);
        ingredients.put(blackPepper, 1);
        ingredients.put(parsley, 5);
        ingredients.put(bread, 50);

        return new Recipe(ingredients, 15);
    }

    public Recipe generateCookieCake() {
        ingredients = new SingleRecipe();

        ingredients.put(cookies, 225);
        ingredients.put(eggs, 2);
        ingredients.put(milk, 250);
        ingredients.put(flour, 23);
        ingredients.put(sugar, 50);
        ingredients.put(vanilla, 2);
        ingredients.put(butter, 25);
        ingredients.put(chocolate, 75);

        return new Recipe(ingredients, 25);
    }

    public Recipe generateFriedEggs() {
        ingredients = new SingleRecipe();

        ingredients.put(eggs, 2);
        ingredients.put(cheese, 50);
        ingredients.put(yogurt, 100);
        ingredients.put(garlic, 15);
        ingredients.put(oil, 19);
        ingredients.put(redPepper, 4);
        ingredients.put(vinegar, 4);

        return new Recipe(ingredients, 15);
    }

    public Recipe generateGreenSalad() {
        ingredients = new SingleRecipe();

        ingredients.put(lettuce, 1);
        ingredients.put(cucumber, 63);
        ingredients.put(tomatoes, 38);
        ingredients.put(broccoli, 75);
        ingredients.put(olives, 13);
        ingredients.put(oliveOil, 12);
        ingredients.put(vinegar, 8);
        ingredients.put(salt, 1);

        return new Recipe(ingredients, 10);
    }

    public Recipe generateKapama() {
        ingredients = new SingleRecipe();

        ingredients.put(pickledCabbage, 375);
        ingredients.put(pork, 250);
        ingredients.put(beef, 150);
        ingredients.put(bacon, 50);
        ingredients.put(sausage, 100);
        ingredients.put(chicken, 150);
        ingredients.put(rice, 175);
        ingredients.put(bayLeaf, 1);
        ingredients.put(blackPepper, 2);
        ingredients.put(beetRoot, 100);

        return new Recipe(ingredients, 45);
    }

    public Recipe generateLentilSoup() {
        ingredients = new SingleRecipe();

        ingredients.put(lentil, 63);
        ingredients.put(peppers, 50);
        ingredients.put(carrots, 75);
        ingredients.put(onion, 38);
        ingredients.put(garlic, 8);
        ingredients.put(tomatoes, 75);
        ingredients.put(sugar, 1);
        ingredients.put(salt, 2);
        ingredients.put(savory, 2);
        ingredients.put(redPepper, 4);
        ingredients.put(oil, 2);

        return new Recipe(ingredients, 15);
    }

    public Recipe generateMusaka() {
        ingredients = new SingleRecipe();

        ingredients.put(potatoes, 250);
        ingredients.put(onion, 38);
        ingredients.put(mincedMeat, 125);
        ingredients.put(tomatoes, 100);
        ingredients.put(eggs, 1);
        ingredients.put(yogurt, 100);
        ingredients.put(flour, 8);
        ingredients.put(oil, 8);
        ingredients.put(salt, 2);

        return new Recipe(ingredients, 35);
    }

    public Recipe generatePancake() {
        ingredients = new SingleRecipe();

        ingredients.put(eggs, 1);
        ingredients.put(bananas, 50);
        ingredients.put(sugar, 8);
        ingredients.put(flour, 5);
        ingredients.put(butter, 3);
        ingredients.put(milk, 5);
        ingredients.put(chocolate, 13);

        return new Recipe(ingredients, 15);
    }

    public Recipe generatePotatoCake() {
        ingredients = new SingleRecipe();

        ingredients.put(potatoes, 375);
        ingredients.put(butter, 32);
        ingredients.put(onion, 50);
        ingredients.put(blackPepper, 1);
        ingredients.put(salt, 1);
        ingredients.put(eggs, 1);
        ingredients.put(cheese, 50);
        ingredients.put(yogurt, 50);

        return new Recipe(ingredients, 20);
    }

    public Recipe generateShepardSalad() {
        ingredients = new SingleRecipe();

        ingredients.put(cucumber, 75);
        ingredients.put(tomatoes, 38);
        ingredients.put(ham, 13);
        ingredients.put(onion, 13);
        ingredients.put(mushrooms, 50);
        ingredients.put(corn, 13);
        ingredients.put(peppers, 13);
        ingredients.put(yellowCheese, 13);
        ingredients.put(eggs, 1);
        ingredients.put(olives, 10);
        ingredients.put(cheese, 13);

        return new Recipe(ingredients, 10);
    }

    public Recipe generateShopskaSalad() {
        ingredients = new SingleRecipe();

        ingredients.put(tomatoes, 75);
        ingredients.put(cucumber, 75);
        ingredients.put(mushrooms, 175);
        ingredients.put(sesame, 8);
        ingredients.put(oliveOil, 4);
        ingredients.put(vinegar, 3);
        ingredients.put(soySause, 3);

        return new Recipe(ingredients, 5);
    }

    public Recipe generateStuffedPeppers() {
        ingredients = new SingleRecipe();

        ingredients.put(mincedMeat, 150);
        ingredients.put(peppers, 200);
        ingredients.put(rice, 63);
        ingredients.put(onion, 80);
        ingredients.put(greenOnion, 30);
        ingredients.put(mushrooms, 100);
        ingredients.put(tomatoes, 75);
        ingredients.put(oil, 38);
        ingredients.put(blackPepper, 1);
        ingredients.put(parsley, 25);
        ingredients.put(salt, 1);
        ingredients.put(eggs, 1);
        ingredients.put(flour, 15);
        ingredients.put(yogurt, 25);

        return new Recipe(ingredients, 25);
    }

    public Recipe generateTarator() {
        ingredients = new SingleRecipe();

        ingredients.put(yogurt, 100);
        ingredients.put(water, 50);
        ingredients.put(cucumber, 75);
        ingredients.put(garlic, 12);
        ingredients.put(salt, 1);
        ingredients.put(walnuts, 8);
        ingredients.put(oil, 8);
        ingredients.put(dill, 8);

        return new Recipe(ingredients, 10);
    }

    public Recipe generateTolumbichki() {
        ingredients = new SingleRecipe();

        ingredients.put(cottageCheese, 50);
        ingredients.put(eggs, 1);
        ingredients.put(oil, 50);
        ingredients.put(backingPowder, 3);
        ingredients.put(flour, 50);
        ingredients.put(water, 125);
        ingredients.put(sugar, 125);
        ingredients.put(lemonZest, 3);

        return new Recipe(ingredients, 30);
    }



// Products
    public Product backingPowder = new ProductPerKilogram("backingPowder", 22.3);
    public Product bananas = new ProductPerKilogram("bananas", 4.7);
    public Product cookies = new ProductPerKilogram("cookies", 18.2);
    public Product beans = new ProductPerKilogram("beans", 5.4);
    public Product flour = new ProductPerKilogram("flour", 2.5);
    public Product broccoli = new ProductPerKilogram("broccoli", 3.6);
    public Product broth = new ProductPerLitre("broth", 5);
    public Product vanilla = new ProductPerKilogram("vanilla", 15.4);
    public Product water = new ProductPerLitre("water", 0.7);
    public Product mushrooms = new ProductPerKilogram("mushrooms", 6.4);
    public Product bayLeaf = new ProductPerKilogram("bayLeaf", 32.5);
    public Product mint = new ProductPerKilogram("mint", 25);
    public Product tomatoes = new ProductPerKilogram("tomatoes", 5.5);
    public Product sugar = new ProductPerKilogram("sugar", 3.5);
    public Product cabbage = new ProductPerKilogram("cabbage", 4);
    public Product oliveOil = new ProductPerLitre("oliveOil", 22.6);
    public Product cottageCheese = new ProductPerKilogram("cottageCheese", 7.9);
    public Product mincedMeat = new ProductPerKilogram("mincedMeat", 16.4);
    public Product cocoa = new ProductPerKilogram("cocoa", 19);
    public Product potatoes = new ProductPerKilogram("potatoes", 4.7);
    public Product yellowCheese = new ProductPerKilogram("yellowCheese", 21.3);
    public Product pickledCabbage = new ProductPerKilogram("pickledCabbage", 12);
    public Product yogurt = new ProductPerKilogram("yogurt", 5);
    public Product dill = new ProductPerKilogram("dill", 12);
    public Product filoDough = new ProductPerKilogram("filoDough", 8.6);
    public Product cucumber = new ProductPerKilogram("cucumber", 6.5);
    public Product bread = new ProductPerKilogram("bread", 1.7);
    public Product lentil = new ProductPerKilogram("lentil", 5.8);
    public Product lemonZest = new ProductPerKilogram("lemonZest", 14);
    public Product onion = new ProductPerKilogram("onion", 2.8);
    public Product chilliePepper = new ProductPerKilogram("chilliePepper", 6);
    public Product parsley = new ProductPerKilogram("parsley", 9.8);
    public Product lettuce = new EnumerableProduct("lettuce", 2.5);
    public Product olives = new ProductPerKilogram("olives", 7.9);
    public Product butter = new ProductPerKilogram("butter", 23);
    public Product carrots = new ProductPerKilogram("carrots", 4.8);
    public Product oil = new ProductPerLitre("oil", 5.2);
    public Product walnuts = new ProductPerKilogram("walnuts", 28.9);
    public Product rice = new ProductPerKilogram("rice", 7.5);
    public Product vinegar = new ProductPerLitre("vinegar", 4.6);
    public Product chicken = new ProductPerKilogram("chicken", 16.9);
    public Product greenOnion = new ProductPerKilogram("greenOnion", 7.2);
    public Product milk = new ProductPerLitre("milk", 3.8);
    public Product pork = new ProductPerKilogram("pork", 17.5);
    public Product cheese = new ProductPerKilogram("cheese", 18.6);
    public Product bacon = new ProductPerKilogram("bacon", 17.1);
    public Product soySause = new ProductPerLitre("soySause", 12.7);
    public Product salt = new ProductPerKilogram("salt", 2.8);
    public Product sausage = new ProductPerKilogram("sausage", 21.6);
    public Product sesame = new ProductPerKilogram("sesame", 26.4);
    public Product beef = new ProductPerKilogram("beef", 27.2);
    public Product beefStomach = new ProductPerKilogram("beefStomach", 18.7);
    public Product noodles = new ProductPerKilogram("noodles", 6);
    public Product corn = new ProductPerKilogram("corn", 6.9);
    public Product blackPepper = new ProductPerKilogram("blackPepper", 14.6);
    public Product beetRoot = new ProductPerKilogram("beetRoot", 5.2);
    public Product redPepper = new ProductPerKilogram("redPepper", 16);
    public Product garlic = new ProductPerKilogram("garlic", 14.8);
    public Product savory = new ProductPerKilogram("savory", 15);
    public Product peppers = new ProductPerKilogram("peppers", 6.4);
    public Product pistachio = new ProductPerKilogram("pistachio", 32.4);
    public Product chocolate = new ProductPerKilogram("chocolate", 15.7);
    public Product ham = new ProductPerKilogram("ham", 18.9);
    public Product eggs = new EnumerableProduct("eggs", 0.5);

}
