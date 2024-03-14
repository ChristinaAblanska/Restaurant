package restaurant.test.test_rooms.test_kitchen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLiter;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

public class TestProductStorage {
    public ProductStorage storage;

    @Before
    public void setup() {
        storage = new ProductStorage();
    }

    @Test
    public void test_getStock() {

        Product egg = new EnumerableProduct("egg", 2.4);
        Assert.assertEquals(0, storage.getStock("egg"), 0.0003f);

        storage.addEnumerableProduct(egg, 20);
        Assert.assertEquals(20, storage.getStock("egg"), 0.0003f);

        storage.emptying();
        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProductPerKilogram(potatoes, 10);
        Assert.assertEquals(10, storage.getStock("potatoes"), 0.0003f);

        storage.emptying();
        Product vinegar = new ProductPerLiter("vinegar", 0.7);
        storage.addProductPerLiter(vinegar, 0.7);
        Assert.assertEquals(0.7, storage.getStock("vinegar"), 0.0003f);
    }

    @Test
    public void test_getGetProduct() throws ProductOutOfStockException {

        Product egg = new EnumerableProduct("egg", 2.4);

        storage.addEnumerableProduct(egg, 20);
        Assert.assertEquals(20, storage.getStock("egg"), 0.0003f);
        storage.getEnumerableProduct(egg, 19);
        Assert.assertEquals(1, storage.getStock("egg"), 0.0003f);

        storage.emptying();
        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProductPerKilogram(potatoes, 10);
        Assert.assertEquals(10, storage.getStock("potatoes"), 0.0003f);
        storage.getProductPerKilogram(potatoes, 2);
        Assert.assertEquals(8, storage.getStock("potatoes"), 0.0003f);

        storage.emptying();
        Product vinegar = new ProductPerLiter("vinegar", 2.45);
        storage.addProductPerLiter(vinegar, 0.7);
        Assert.assertEquals(0.7, storage.getStock("vinegar"), 0.0003f);
        storage.getProductPerLiter(vinegar, 0.2);
        Assert.assertEquals(0.5, storage.getStock("vinegar"), 0.0003f);
    }

    @Test
    public void test_ProductOutOfStockException() throws ProductOutOfStockException {

        Product egg = new EnumerableProduct("egg", 2.4);

        storage.addEnumerableProduct(egg, 20);
        storage.getEnumerableProduct(egg, 20);

        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getEnumerableProduct(egg, 1);
        });

        storage.emptying();
        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProductPerKilogram(potatoes, 10);
        storage.getProductPerKilogram(potatoes, 10);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProductPerKilogram(potatoes, 1);
        });

        storage.emptying();
        Product vinegar = new ProductPerLiter("vinegar", 2.45);
        storage.addProductPerLiter(vinegar, 0.7);
        storage.getProductPerLiter(vinegar, 0.7);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProductPerLiter(vinegar, 0.1);
        });
    }
    @Test
    public void test_PrintStock() throws ProductOutOfStockException {

        Product egg = new EnumerableProduct("egg", 2.4);
        storage.addEnumerableProduct(egg, 20);

        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProductPerKilogram(potatoes, 10);

        Product vinegar = new ProductPerLiter("vinegar", 2.45);
        storage.addProductPerLiter(vinegar, 0.7);

        storage.printStock();
    }
}
