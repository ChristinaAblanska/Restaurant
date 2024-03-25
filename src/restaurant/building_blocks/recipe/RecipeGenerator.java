package restaurant.building_blocks.recipe;

import restaurant.building_blocks.recipe.Recipe;
import restaurant.building_blocks.recipe.Recipe.Ingredients;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;

public class RecipeGenerator {
    public Ingredients ingredients;

    // Adding products to the recipes
    public Recipe generateBeansStew() {
        ingredients = new Ingredients();
        ingredients.put(beans, 100);
        ingredients.put(bacon, 100);
        ingredients.put(onion, 50);
        ingredients.put(carrots, 50);
        ingredients.put(tomatoes, 50);
        ingredients.put(flour, 7);
        ingredients.put(chilliePepper, 7);
        ingredients.put(mint, 3);
        ingredients.put(savory, 2);
        ingredients.put(salt, 1);
        ingredients.put(blackPepper, 1);

        return new Recipe(ingredients, 35, "BeansSte");
    }

    public Recipe generateBakedCheese() {
        ingredients = new Ingredients();

        ingredients.put(cheese, 150);
        ingredients.put(eggs, 1);
        ingredients.put(oil, 25);
        ingredients.put(tomatoes, 163);
        ingredients.put(chilliePepper, 20);
        ingredients.put(savory, 3);
        ingredients.put(redPepper, 5);

        return new Recipe(ingredients, 15, "BakedCheese");
    }

    public Recipe generateBaklava() {
        ingredients = new Ingredients();

        ingredients.put(filoDough, 100);
        ingredients.put(pistachio, 50);
        ingredients.put(milk, 120);
        ingredients.put(sugar, 150);
        ingredients.put(butter, 13);
        ingredients.put(cocoa, 13);
        ingredients.put(chocolate, 25);

        return new Recipe(ingredients, 25, "Baklava");
    }

    public Recipe generateBeefSoup() {
        ingredients = new Ingredients();

        ingredients.put(beefStomach, 150);
        ingredients.put(milk, 150);
        ingredients.put(oil, 8);
        ingredients.put(butter, 8);
        ingredients.put(redPepper, 2);
        ingredients.put(salt, 1);
        ingredients.put(garlic, 13);
        ingredients.put(vinegar, 25);
        ingredients.put(redPepper, 3);

        return new Recipe(ingredients, 15, "BeefSoup");
    }

    public Recipe generateCabbageCarrotSalad() {
        ingredients = new Ingredients();

        ingredients.put(cabbage, 200);
        ingredients.put(carrots, 100);
        ingredients.put(cucumber, 90);
        ingredients.put(olives, 20);
        ingredients.put(salt, 1);
        ingredients.put(vinegar, 3);
        ingredients.put(oil, 4);

        return new Recipe(ingredients, 10, "CarrotSalad");
    }

    public Recipe generateChickenRice() {
        ingredients = new Ingredients();

        ingredients.put(rice, 125);
        ingredients.put(chicken, 150);
        ingredients.put(butter, 15);
        ingredients.put(broth, 250);
        ingredients.put(carrots, 50);
        ingredients.put(onion, 38);

        return new Recipe(ingredients, 25, "ChickenRice");
    }

    public Recipe generateChickenSoup() {
        ingredients = new Ingredients();

        ingredients.put(chicken, 150);
        ingredients.put(onion, 38);
        ingredients.put(carrots, 38);
        ingredients.put(noodles, 25);
        ingredients.put(salt, 1);
        ingredients.put(blackPepper, 1);
        ingredients.put(parsley, 5);
        ingredients.put(bread, 50);

        return new Recipe(ingredients, 15, "ChickenSoup");
    }

    public Recipe generateCookieCake() {
        ingredients = new Ingredients();

        ingredients.put(cookies, 100);
        ingredients.put(eggs, 2);
        ingredients.put(milk, 50);
        ingredients.put(flour, 23);
        ingredients.put(sugar, 20);
        ingredients.put(vanilla, 2);
        ingredients.put(butter, 25);
        ingredients.put(chocolate, 50);

        return new Recipe(ingredients, 25, "CookieCake");
    }

    public Recipe generateFriedEggs() {
        ingredients = new Ingredients();

        ingredients.put(eggs, 3);
        ingredients.put(cheese, 50);
        ingredients.put(yogurt, 150);
        ingredients.put(garlic, 15);
        ingredients.put(oil, 19);
        ingredients.put(redPepper, 4);
        ingredients.put(vinegar, 4);

        return new Recipe(ingredients, 15, "FriedEggs");
    }

    public Recipe generateGreenSalad() {
        ingredients = new Ingredients();

        ingredients.put(lettuce, 1);
        ingredients.put(cucumber, 50);
        ingredients.put(tomatoes, 30);
        ingredients.put(broccoli, 50);
        ingredients.put(olives, 20);
        ingredients.put(oliveOil, 12);
        ingredients.put(vinegar, 8);
        ingredients.put(salt, 1);

        return new Recipe(ingredients, 10, "GreenSalad");
    }

    public Recipe generateKapama() {
        ingredients = new Ingredients();

        ingredients.put(pickledCabbage, 200);
        ingredients.put(pork, 100);
        ingredients.put(beef, 100);
        ingredients.put(bacon, 50);
        ingredients.put(sausage, 100);
        ingredients.put(chicken, 100);
        ingredients.put(rice, 100);
        ingredients.put(bayLeaf, 1);
        ingredients.put(blackPepper, 2);
        ingredients.put(beetRoot, 100);

        return new Recipe(ingredients, 45, "Kapama");
    }

    public Recipe generateLentilSoup() {
        ingredients = new Ingredients();

        ingredients.put(lentil, 100);
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

        return new Recipe(ingredients, 15, "LentilSoup");
    }

    public Recipe generateMusaka() {
        ingredients = new Ingredients();

        ingredients.put(potatoes, 250);
        ingredients.put(onion, 38);
        ingredients.put(mincedMeat, 125);
        ingredients.put(tomatoes, 100);
        ingredients.put(eggs, 1);
        ingredients.put(yogurt, 100);
        ingredients.put(flour, 8);
        ingredients.put(oil, 8);
        ingredients.put(salt, 2);

        return new Recipe(ingredients, 35, "Musaka");
    }

    public Recipe generatePancake() {
        ingredients = new Ingredients();

        ingredients.put(eggs, 1);
        ingredients.put(bananas, 100);
        ingredients.put(sugar, 20);
        ingredients.put(flour, 50);
        ingredients.put(butter, 10);
        ingredients.put(milk, 20);
        ingredients.put(chocolate, 50);

        return new Recipe(ingredients, 15, "Pancake");
    }


    public Recipe generatePotatoCake() {
        ingredients = new Ingredients();

        ingredients.put(potatoes, 200);
        ingredients.put(butter, 32);
        ingredients.put(onion, 50);
        ingredients.put(blackPepper, 1);
        ingredients.put(salt, 1);
        ingredients.put(eggs, 1);
        ingredients.put(cheese, 50);
        ingredients.put(yogurt, 50);

        return new Recipe(ingredients, 20, "PotatoCake");
    }

    public Recipe generateShepardSalad() {
        ingredients = new Ingredients();

        ingredients.put(cucumber, 90);
        ingredients.put(tomatoes, 90);
        ingredients.put(ham, 40);
        ingredients.put(onion, 13);
        ingredients.put(mushrooms, 50);
        ingredients.put(corn, 13);
        ingredients.put(peppers, 13);
        ingredients.put(yellowCheese, 50);
        ingredients.put(eggs, 1);
        ingredients.put(olives, 10);
        ingredients.put(cheese, 13);

        return new Recipe(ingredients, 10, "ShepardSalad");
    }

    public Recipe generateShopskaSalad() {
        ingredients = new Ingredients();

        ingredients.put(tomatoes, 75);
        ingredients.put(cucumber, 75);
        ingredients.put(mushrooms, 175);
        ingredients.put(sesame, 8);
        ingredients.put(oliveOil, 4);
        ingredients.put(vinegar, 3);
        ingredients.put(soySause, 3);

        return new Recipe(ingredients, 5, "ShopskaSalad");
    }

    public Recipe generateStuffedPeppers() {
        ingredients = new Ingredients();

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

        return new Recipe(ingredients, 25, "StuffedPeppers");
    }


    public Recipe generateTarator() {
        ingredients = new Ingredients();

        Product yogurt1 = yogurt;
        ingredients.put(yogurt1, 100);
        ingredients.put(water, 50);
        ingredients.put(cucumber, 75);
        ingredients.put(garlic, 12);
        ingredients.put(salt, 1);
        ingredients.put(walnuts, 8);
        ingredients.put(oil, 8);
        ingredients.put(dill, 8);

        return new Recipe(ingredients, 10, "Tarator");
    }

    public Recipe generateTolumbichki() {
        ingredients = new Ingredients();

        ingredients.put(cottageCheese, 150);
        ingredients.put(eggs, 1);
        ingredients.put(oil, 50);
        ingredients.put(backingPowder, 3);
        ingredients.put(flour, 50);
        ingredients.put(water, 125);
        ingredients.put(sugar, 125);
        ingredients.put(lemonZest, 3);

        return new Recipe(ingredients, 30, "Tolumbichki");
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


    // Compliment from the restaurant when there are no available products to prepare a certain meal
    public Recipe generateCompliment_RaspberryBites() {
        ingredients = new Ingredients();

        ingredients.put(raspberries, 100);
        ingredients.put(sugar, 20);
        ingredients.put(flour, 50);
        ingredients.put(butter, 10);
        ingredients.put(milk, 20);
        ingredients.put(whiteChocolate, 50);

        return new Recipe(ingredients, 15, "Compliment_RaspberryBites");
    }


    // for Compliment ONLY
    public Product raspberries = new ProductPerKilogram("Raspberries", 21.2);
    public Product whiteChocolate = new ProductPerKilogram("White Chocolate", 12.7);

}
