package restaurant.test.test_rooms.test_kitchen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.Product;
import restaurant.building_blocks.room.kitchen.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.ProductStorage;

public class Test_ProductStorage {

    public ProductStorage storage;

    @Before
    public void setup() {
        storage = new ProductStorage();
    }

    @Test
    public void test_getStock() throws ProductOutOfStockException {
        Assert.assertEquals(0, storage.getStock("Картофи"), 0);

        Product лук = new Product("лук", Product.Unit.Грам, 3.60);
        storage.addProduct(лук, Product.Unit.Грам, 1000, 10);
        Assert.assertEquals(1000, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Брой, 1);
        Assert.assertEquals(900, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Грам, 100);
        Assert.assertEquals(800, storage.getStock("лук"), 0);

        storage.printStock();
        storage.getProduct(лук, Product.Unit.Брой, 1);
        Assert.assertEquals(700, storage.getStock("лук"), 0);

    }

    @Test
    public void test_addProducts() {
        Product лук = new Product("лук", Product.Unit.Грам, 4);
        storage.addProduct(лук, Product.Unit.Грам, 5000, 10);


        Assert.assertEquals(5000, storage.getStock("лук"), 1);
        double productStock = storage.getStock("лук");
        Assert.assertEquals(5000, productStock, 1);
    }

    @Test
    public void test_getProducts() throws ProductOutOfStockException {
        Product лук = new Product("лук", Product.Unit.Грам, 4);

        storage.addProduct(лук, Product.Unit.Грам, 1000, 10);
        storage.getProduct(лук, Product.Unit.Брой, 1);
        storage.printStock();
        Assert.assertEquals(900, storage.getStock("лук"), 0);


        storage.getProduct(лук, Product.Unit.Грам, 100);
        Assert.assertEquals(800, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Брой, 1);
        Assert.assertEquals(700, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Грам, 250);
        storage.printStock();
        Assert.assertEquals(450, storage.getStock("лук"), 0);

        storage.getProduct(лук, Product.Unit.Брой, 1);
        Assert.assertEquals(350, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Килограм, 0.100);
        Assert.assertEquals(250, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Кафена_чаша, 1);
        Assert.assertEquals(150, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Чаена_лъжица, 1);
        Assert.assertEquals(130, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Супена_лъжица, 1);
        Assert.assertEquals(100, storage.getStock("лук"), 0);
        storage.printStock();
    }

    @Test
    public void test_ProductOutOfStockException() throws ProductOutOfStockException {
        Product potatoes = new Product("Картофи", Product.Unit.Грам, 43);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProduct(potatoes, Product.Unit.Брой, 1);
        });

        storage.addProduct(potatoes, Product.Unit.Грам, 1, 5);
        storage.getProduct(potatoes, Product.Unit.Брой, 1000);

        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProduct(potatoes, Product.Unit.Брой, 1);
        });
    }
}
