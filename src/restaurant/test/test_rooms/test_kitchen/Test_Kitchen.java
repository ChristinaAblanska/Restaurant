package restaurant.test.test_rooms.test_kitchen;

import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.Product;
import restaurant.building_blocks.room.kitchen.Kitchen;

public class Test_Kitchen {

    private Kitchen kitchen;

    @Before
    public void setup() {
        kitchen = new Kitchen();
    }

    @Test
    public void test_completeAnOrder()  {
        Product лук = new Product("лук", Product.Unit.Грам,5);


    }
}
