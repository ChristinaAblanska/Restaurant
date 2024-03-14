package restaurant.building_blocks.room.kitchen.storage;


import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.storage.shaft.EnumerableShaft;
import restaurant.building_blocks.room.kitchen.storage.shaft.Shaft;
import restaurant.building_blocks.room.kitchen.storage.shaft.ShaftPerKilogram;
import restaurant.building_blocks.room.kitchen.storage.shaft.ShaftPerLiter;

import java.util.HashMap;
import java.util.Map;

public class ProductStorage {

    private final HashMap<String, Shaft> container;

    public ProductStorage() {
        container = new HashMap<>();
    }

    public double getStock(String productName) {

        if (container.containsKey(productName)) {
            Shaft shaft = container.get(productName);
            if (shaft instanceof EnumerableShaft) {
                return ((EnumerableShaft) shaft).getQuantity();
            } else if (shaft instanceof ShaftPerKilogram) {
                return ((ShaftPerKilogram) shaft).getQuantity();
            } else {
                return ((ShaftPerLiter) shaft).getQuantity();
            }
        }
        return 0;
    }

    public void addEnumerableProduct(Product product, int productsCount) {

        if (container.containsKey(product.getName())) {
            EnumerableShaft shaft = (EnumerableShaft) container.get(product.getName());
            shaft.add(productsCount);
        } else {
            EnumerableShaft enumShaft = new EnumerableShaft();
            enumShaft.add(productsCount);
            container.put(product.getName(), enumShaft);
        }
    }

    public void addProductPerKilogram(Product product, double weightInKilogram) {

        if (container.containsKey(product.getName())) {
            ShaftPerKilogram shaft = (ShaftPerKilogram) container.get(product.getName());
            shaft.add(weightInKilogram);
        } else {
            ShaftPerKilogram enumShaft = new ShaftPerKilogram();
            enumShaft.add(weightInKilogram);
            container.put(product.getName(), enumShaft);
        }
    }

    public void addProductPerLiter(Product product, double volumeInLitres) {

        if (container.containsKey(product.getName())) {
            ShaftPerLiter shaft = (ShaftPerLiter) container.get(product.getName());
            shaft.add(volumeInLitres);
        } else {
            ShaftPerLiter enumShaft = new ShaftPerLiter();
            enumShaft.add(volumeInLitres);
            container.put(product.getName(), enumShaft);
        }
    }

    public void printStock() {
        for (Map.Entry<String, Shaft> record : container.entrySet()) {
            if (record.getValue() instanceof EnumerableShaft) {
                System.out.printf("%-10s | %-5d pieces\n", record.getKey(), record.getValue().getQuantity());
            } else if (record.getValue() instanceof ShaftPerKilogram) {
                System.out.printf("%-10s | %-5.2f kilos\n", record.getKey(), record.getValue().getQuantity());
            } else if (record.getValue() instanceof ShaftPerLiter) {
                System.out.printf("%-10s | %-5.2f litres\n", record.getKey(), record.getValue().getQuantity());
            }
        }
    }

    public void emptying() {
        this.container.clear();
    }

    public void getEnumerableProduct(Product product, int productsCount) throws ProductOutOfStockException {
        if (container.containsKey(product.getName())) {
            EnumerableShaft shaft = (EnumerableShaft) container.get(product.getName());
            if (shaft.getQuantity() > 0) {
                shaft.get(productsCount);
            } else {
                throw new ProductOutOfStockException(product.getName() + " is out of Stock");
            }
        } else {
            throw new ProductOutOfStockException(product.getName() + " is out of Stock");
        }
    }

    public void getProductPerKilogram(Product product, double weightInKilogram) throws ProductOutOfStockException {
        if (container.containsKey(product.getName())) {
            ShaftPerKilogram shaft = (ShaftPerKilogram) container.get(product.getName());
            if (shaft.getQuantity() > 0) {
                shaft.get(weightInKilogram);
            } else {
                throw new ProductOutOfStockException(product.getName() + " is out of Stock");
            }
        } else {
            throw new ProductOutOfStockException(product.getName() + " is out of Stock");
        }
    }

    public void getProductPerLiter(Product product, double volumeInLitres) throws ProductOutOfStockException {
        if (container.containsKey(product.getName())) {
            ShaftPerLiter shaft = (ShaftPerLiter) container.get(product.getName());
            if (shaft.getQuantity() > 0) {
                shaft.get(volumeInLitres);
            } else {
                throw new ProductOutOfStockException(product.getName() + " is out of Stock");
            }
        } else {
            throw new ProductOutOfStockException(product.getName() + " is out of Stock");
        }
    }
}