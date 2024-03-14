package restaurant.test.test_food;

import org.junit.Assert;
import org.junit.Test;
import restaurant.building_blocks.food.Beverage;

public class Test_Beverage {
    public Beverage drink;

    @Test
    public void testDrink() {
        drink = new Beverage("Juice", 2.5);
        Assert.assertEquals("Juice", drink.getName());
        Assert.assertEquals(2.5, drink.getPrice(), 0.0003f);
    }
}
