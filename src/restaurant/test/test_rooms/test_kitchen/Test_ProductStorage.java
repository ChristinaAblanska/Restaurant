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
        Assert.assertEquals(0, storage.getStock("Картофи"));
        Product potatoes = new Product("Картофи", Product.Unit.Грам, 23);
        storage.addProduct(potatoes, 1000);
        Assert.assertEquals(1000, storage.getStock("Картофи"));
        storage.getProduct(potatoes, 1000);
        Assert.assertEquals(0, storage.getStock("Картофи"));
    }

    @Test
    public void test_addProducts() {
        Product potatoes = new Product("Картофи", Product.Unit.Грам, 43);
        storage.addProduct(potatoes, 1000);
        storage.addProduct(potatoes, 500);
        int productStock = storage.getStock("Картофи");
        Assert.assertEquals(1500, productStock);
    }

    @Test
    public void test_getProducts() throws ProductOutOfStockException {
        Product potatoes = new Product("Картофи", Product.Unit.Грам, 2);
        storage.addProduct(potatoes, 1000);
        storage.addProduct(potatoes, 1000);
        storage.getProduct(potatoes, 999);
        storage.getProduct(potatoes, 1000);
        int productStock = storage.getStock("Картофи");
        Assert.assertEquals(1, productStock);
    }

    @Test
    public void test_ProductOutOfStockException() throws ProductOutOfStockException {
        Product potatoes = new Product("Картофи", Product.Unit.Грам, 43);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProduct(potatoes, 1);
        });

        storage.addProduct(potatoes, 1000);
        storage.getProduct(potatoes, 1000);

        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProduct(potatoes, 1);
        });
    }
}
