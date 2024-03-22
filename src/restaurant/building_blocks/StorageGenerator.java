package restaurant.building_blocks;

import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

import java.util.Random;

public class StorageGenerator {


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

    // for Compliment ONLY
    public Product raspberries = new ProductPerKilogram("Raspberries", 21.2);
    public Product whiteChocolate = new ProductPerKilogram("White Chocolate", 12.7);


    public ProductStorage storageGenerator() {
        ProductStorage storage = new ProductStorage();
        Random generate = new Random();


        storage.addProductPerKilogram(backingPowder, generate.nextDouble( 4) + 1);
        storage.addProductPerKilogram(bananas, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(cookies, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(beans, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(flour, generate.nextDouble(40) + 20);
        storage.addProductPerKilogram(broccoli, generate.nextDouble(40) + 20);
        storage.addProductPerLiter(broth, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(vanilla, generate.nextDouble(5) + 2);
        storage.addProductPerLiter(water, generate.nextDouble(120) + 500);
        storage.addProductPerKilogram(mushrooms, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(bayLeaf, generate.nextDouble(5) + 20);
        storage.addProductPerKilogram(mint, generate.nextDouble(5) + 20);
        storage.addProductPerKilogram(tomatoes, generate.nextDouble(50) + 300);
        storage.addProductPerKilogram(sugar, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(cabbage, generate.nextDouble(40) + 200);
        storage.addProductPerLiter(oliveOil, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(cottageCheese, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(mincedMeat, generate.nextDouble(400) + 200);
        storage.addProductPerKilogram(cocoa, generate.nextDouble(5) + 20);
        storage.addProductPerKilogram(potatoes, generate.nextDouble(50) + 300);
        storage.addProductPerKilogram(yellowCheese, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(pickledCabbage, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(yogurt, generate.nextDouble(40) + 0);
        storage.addProductPerKilogram(dill, generate.nextDouble(5) + 20);
        storage.addProductPerKilogram(filoDough, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(cucumber, generate.nextDouble(50) + 300);
        storage.addProductPerKilogram(bread, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(lentil, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(lemonZest, generate.nextDouble(5) + 20);
        storage.addProductPerKilogram(onion, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(chilliePepper, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(parsley, generate.nextDouble(5) + 20);
        storage.addEnumerableProduct(lettuce, (generate.nextInt(70) + 100));
        storage.addProductPerKilogram(olives, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(butter, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(carrots, generate.nextDouble(40) + 200);
        storage.addProductPerLiter(oil, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(walnuts, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(rice, generate.nextDouble(20) + 100);
        storage.addProductPerLiter(vinegar, generate.nextDouble(5) + 20);
        storage.addProductPerKilogram(chicken, generate.nextDouble(40) + 200);
        storage.addProductPerKilogram(greenOnion, generate.nextDouble(20) + 100);
        storage.addProductPerLiter(milk, generate.nextDouble(20) + 100);
        storage.addProductPerKilogram(pork, generate.nextDouble(40) + 20);
        storage.addProductPerKilogram(cheese, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(bacon, generate.nextDouble(20) + 100);
        storage.addProductPerLiter(soySause, generate.nextDouble(5) + 2);
        storage.addProductPerKilogram(salt, generate.nextDouble(5) + 2);
        storage.addProductPerKilogram(sausage, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(sesame, generate.nextDouble(5) + 2);
        storage.addProductPerKilogram(beef, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(beefStomach, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(noodles, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(corn, generate.nextDouble(40) + 20);
        storage.addProductPerKilogram(blackPepper, generate.nextDouble(5) + 2);
        storage.addProductPerKilogram(beetRoot, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(redPepper, generate.nextDouble(5) + 2);
        storage.addProductPerKilogram(garlic, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(savory, generate.nextDouble(5) + 2);
        storage.addProductPerKilogram(peppers, generate.nextDouble(40) + 20);
        storage.addProductPerKilogram(pistachio, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(chocolate, generate.nextDouble(20) + 10);
        storage.addProductPerKilogram(ham, generate.nextDouble(40) + 20);
        storage.addEnumerableProduct(eggs, (generate.nextInt(300) + 10000));

        // for Compliment ONLY
        storage.addProductPerKilogram(raspberries, 15);
        storage.addProductPerKilogram(whiteChocolate, 10);

        return storage;
    }

}
