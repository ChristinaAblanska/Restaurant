package restaurant.test.test_rooms.test_kitchen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLiter;
import restaurant.building_blocks.room.kitchen.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.ProductStorage;

public class TestProductStorage {

    public ProductStorage storage;

    @Before
    public void setup() {
        storage = new ProductStorage();
    }

    @Test
    public void test_getStock() {

        Product egg = new EnumerableProduct("egg", 2.4);
        Assert.assertEquals(0, storage.getStock("egg"), 0);

        storage.addEnumerableProduct(egg, 20);
        Assert.assertEquals(20, storage.getStock("egg"), 0);

        storage.emptying();
        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProductPerKilogram(potatoes, 10);
        Assert.assertEquals(10, storage.getStock("potatoes"), 0);

        storage.emptying();
        Product koka_kola = new ProductPerLiter("koka_kola", 0.7);
        storage.addProductPerLiter(koka_kola, 0.7);
        Assert.assertEquals(0.7, storage.getStock("koka_kola"), 0);
    }

    @Test
    public void test_getGetProduct() {

      /*  Product egg = new EnumerableProduct("egg", 20, 2.4);

        storage.addProduct(egg);
        storage.getProduct(egg);

        Assert.assertEquals(20, storage.getStock("egg"), 0);
        //storage.printStock();
        storage.emptying();
        Product potatoes = new ProductPerKilogram("potatoes", 5);
        storage.addProduct(potatoes);
        Assert.assertEquals(5, storage.getStock("potatoes"), 0);
        //storage.printStock();
        storage.emptying();
        Product koka_kola = new ProductPerLiter("koka_kola", 0.7);
        storage.addProduct(koka_kola);
        Assert.assertEquals(0.7, storage.getStock("koka_kola"), 0);*/
    }
}
