package restaurant.building_blocks.room.kitchen;

import org.junit.experimental.theories.Theories;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.employee.Cook;
import restaurant.building_blocks.room.Room;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

public class Kitchen extends Room {
    private ProductStorage storage;

    private Cook cook;

    public Kitchen() {
        storage = new ProductStorage();
    }

    public synchronized void completeAnOrder(Order order) {
        //System.out.println("add order")
        cook = new Cook(order,storage);
        Thread t = new Thread(cook);
        t.start();
    }
}
