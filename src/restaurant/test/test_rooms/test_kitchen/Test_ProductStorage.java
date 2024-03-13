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
    public void test_addSingle_getSingleProduct() throws ProductOutOfStockException {

        Product ананас = new Product("ананас", Product.Unit.Брой, 4.6);
        storage.addProduct(ананас, Product.Unit.Брой, 10, 10);
        storage.printStock();
        Assert.assertEquals(10, storage.getStock("ананас"), 0);
        storage.getProduct(ананас, Product.Unit.Брой, 1);
        storage.printStock();
        Assert.assertEquals(9, storage.getStock("ананас"), 0);
        storage.getProduct(ананас, Product.Unit.Брой, 9);
        storage.printStock();
        Assert.assertEquals(0, storage.getStock("ананас"), 0);
    }

    @Test
    public void test_addComposite_getCompositeProduct() throws ProductOutOfStockException {

        Product кайма = new Product("кайма", Product.Unit.Килограм, 4.6);
        storage.addProduct(кайма, Product.Unit.Килограм, 1, 2);
        Assert.assertEquals(1, storage.getStock("кайма"), 0);
        storage.printStock();

        storage.getProduct(кайма, Product.Unit.Грам, 500);
        storage.printStock();
        Assert.assertEquals(0.5, storage.getStock("кайма"), 0);
        storage.getProduct(кайма, Product.Unit.Грам, 500);
        storage.printStock();
        Assert.assertEquals(0, storage.getStock("кайма"), 0);

        storage.emptying();

        Product олио = new Product("олио", Product.Unit.Литър, 5.6);
        storage.addProduct(олио, Product.Unit.Милилитър, 700, 1);
        storage.printStock();
        Assert.assertEquals(0.7, storage.getStock("олио"), 0);

        storage.getProduct(олио, Product.Unit.Кафена_чаша, 1);
        Assert.assertEquals(0.6, storage.getStock("олио"), 0);
        storage.printStock();
    }

    @Test
    public void test_addComposite_getSingleProduct() throws ProductOutOfStockException {

        Product лук = new Product("лук", Product.Unit.Килограм, 4.6);
        storage.addProduct(лук, Product.Unit.Килограм, 1, 5);
        Assert.assertEquals(1, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Брой, 1);
        storage.printStock();
        Assert.assertEquals(0.8, storage.getStock("лук"), 0);

    }

    @Test
    public void test_addComposite_getSingleAndCompositeProduct() throws ProductOutOfStockException {

        Product лук = new Product("лук", Product.Unit.Килограм, 4.6);
        storage.addProduct(лук, Product.Unit.Килограм, 1, 5);
        Assert.assertEquals(1, storage.getStock("лук"), 0);
        storage.printStock();

        storage.getProduct(лук, Product.Unit.Брой, 1);
        storage.printStock();
        Assert.assertEquals(0.8, storage.getStock("лук"), 0);
        storage.getProduct(лук, Product.Unit.Грам, 500);
        storage.printStock();
        Assert.assertEquals(0.3, storage.getStock("лук"), 0);
    }

    @Test
    public void test_addSingle_getCompositeProduct() throws ProductOutOfStockException {

        Product кисело_мляко = new Product("кисело_мляко", Product.Unit.Брой, 0.85);
        storage.addProduct(кисело_мляко, Product.Unit.Брой, 1000, 2);
        storage.printStock();
        Assert.assertEquals(1000, storage.getStock("кисело_мляко"), 0);

        storage.getProduct(кисело_мляко, Product.Unit.Грам, 500);
        storage.printStock();
        Assert.assertEquals(500, storage.getStock("кисело_мляко"), 0);
        storage.getProduct(кисело_мляко, Product.Unit.Грам, 500);
        storage.printStock();
        Assert.assertEquals(0, storage.getStock("лук"), 0);

        storage.emptying();

        Product чубрица = new Product("чубрица", Product.Unit.Брой, 0.30);
        storage.addProduct(чубрица, Product.Unit.Брой, 200, 1);
        storage.printStock();
        Assert.assertEquals(200, storage.getStock("чубрица"), 0);

        storage.getProduct(чубрица, Product.Unit.Чаена_лъжица, 1);
        Assert.assertEquals(180, storage.getStock("чубрица"), 0);
        storage.printStock();
    }

    @Test
    public void test_ProductOutOfStockException() throws ProductOutOfStockException {
        Product potatoes = new Product("Картофи", Product.Unit.Грам, 43);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProduct(potatoes, Product.Unit.Брой, 1);
        });

        storage.addProduct(potatoes, Product.Unit.Грам, 1000, 10);
        storage.getProduct(potatoes, Product.Unit.Брой, 10);

        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProduct(potatoes, Product.Unit.Брой, 1);
        });
    }
}
