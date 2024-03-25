package restaurant.building_blocks.kitchen;

import restaurant.building_blocks.order.TableOrder;
import restaurant.building_blocks.person.employee.Cook;
import restaurant.building_blocks.person.employee.Employee;
import restaurant.building_blocks.kitchen.storage.ProductStorage;

public class Kitchen  {

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
