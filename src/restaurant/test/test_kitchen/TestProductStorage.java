package restaurant.test.test_kitchen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.kitchen.storage.StorageGenerator;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.kitchen.storage.ProductStorage;

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
        Product vinegar = new ProductPerLitre("vinegar", 0.7);
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
        Product potatoes = new ProductPerKilogram("potatoes", 5.45);
        storage.addProductPerKilogram(potatoes, 10);
        Assert.assertEquals(10, storage.getStock("potatoes"), 0.0003f);
        storage.getProductPerGram(potatoes, 2000);
        Assert.assertEquals(8.0, storage.getStock("potatoes"), 0.0003f);

        storage.emptying();
        Product vinegar = new ProductPerLitre("vinegar", 2.45);
        storage.addProductPerLiter(vinegar, 0.7);
        Assert.assertEquals(0.7, storage.getStock("vinegar"), 0.0003f);
        storage.getProductPerMilliliter(vinegar, 200);
        Assert.assertEquals(0.500, storage.getStock("vinegar"), 0.0003f);
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
        storage.getProductPerGram(potatoes, 10000);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProductPerGram(potatoes, 1);
        });

        storage.emptying();
        Product vinegar = new ProductPerLitre("vinegar", 2.45);
        storage.addProductPerLiter(vinegar, 0.7);
        storage.getProductPerMilliliter(vinegar, 700);
        Assert.assertThrows(ProductOutOfStockException.class, () -> {
            storage.getProductPerMilliliter(vinegar, 0.1);
        });
    }

    @Test
    public void test_PrintStock() {

        Product egg = new EnumerableProduct("egg", 2.4);
        storage.addEnumerableProduct(egg, 20);

        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProductPerKilogram(potatoes, 10);

        Product vinegar = new ProductPerLitre("vinegar", 2.45);
        storage.addProductPerLiter(vinegar, 0.7);

        storage.printStock();
    }

    @Test
    public void testStorageGenerate() {
        StorageGenerator generate = new StorageGenerator();
        ProductStorage storage = generate.storageGenerator();

        System.out.println(storage.getStock("ham"));
        System.out.println(storage.getStock("eggs"));
        System.out.println(storage.getStock("milk"));
        System.out.println(storage.getStock("walnuts"));
    }
}
