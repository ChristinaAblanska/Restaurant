package restaurant.building_blocks.room.kitchen;

import restaurant.building_blocks.TableOrder;
import restaurant.building_blocks.employee.Cook;
import restaurant.building_blocks.employee.Employee;
import restaurant.building_blocks.room.Room;
import restaurant.building_blocks.room.kitchen.storage.ProductStorage;
import restaurant.simulation.Time;

public class Kitchen extends Room {

    Cook cook;
    private ProductStorage storage;

    public Kitchen() {
        storage = new ProductStorage();
    }

    public synchronized void completeAnOrder(TableOrder order) {
        //System.out.println("add order")
        cook = new Cook(order, storage, 2300);
        Thread t = new Thread(cook);
        t.start();
    }

    public void setStorage(ProductStorage storage) {
        this.storage = storage;
    }

    public ProductStorage getStorage() {
        return storage;
    }

    public Employee getCook() {
        return cook;
    }
}
