package restaurant.building_blocks.room.kitchen;

import restaurant.building_blocks.TableOrder;
import restaurant.building_blocks.employee.Cook;
import restaurant.building_blocks.room.Room;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;

public class Kitchen extends Room {
    private ProductStorage storage;

    public Kitchen() {
        storage = new ProductStorage();
    }

    public synchronized void completeAnOrder(TableOrder order) {
        //System.out.println("add order")
        Cook cook = new Cook(order,storage);
        Thread t = new Thread(cook);
        t.start();
    }
}
