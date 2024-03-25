package restaurant.test.test_product;

import org.junit.Assert;
import org.junit.Test;
import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;

public class TestProduct {
    @Test
    public void test_createProduct() {
        Product egg = new EnumerableProduct("egg", 2.4);
        Assert.assertEquals("egg", egg.getName());

        Product potatoes = new ProductPerKilogram("potatoes", 5);
        Assert.assertEquals("potatoes", potatoes.getName());

        Product vinegar = new ProductPerLitre("vinegar", 0.7);
        Assert.assertEquals("vinegar", vinegar.getName());
    }

    @Test
    public void test_getPrice() {
        EnumerableProduct egg = new EnumerableProduct("egg", 0.45);
        Assert.assertEquals(0.45, egg.getPricePer_1_Piece(), 0.0003f);

        ProductPerKilogram potatoes = new ProductPerKilogram("potatoes", 5);
        Assert.assertEquals(5, potatoes.getPricePer_1_Kilogram(), 0.0003f);
        Assert.assertEquals(0.05, potatoes.getPricePer_100_Gram(), 0.0003f);

        ProductPerLitre vinegar = new ProductPerLitre("vinegar", 2.50);
        Assert.assertEquals(2.50, vinegar.getPricePer_1_Litre(), 0.0003f);
        Assert.assertEquals(0.025, vinegar.getPricePer_100_Millilitre(), 0.0003f);
    }
}
