package restaurant.building_blocks.kitchen.storage;


import restaurant.Restaurant;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.kitchen.storage.shaft.EnumerableShaft;
import restaurant.building_blocks.kitchen.storage.shaft.Shaft;
import restaurant.building_blocks.kitchen.storage.shaft.ShaftPerKilogram;
import restaurant.building_blocks.kitchen.storage.shaft.ShaftPerLiter;

import java.util.HashMap;
import java.util.Map;

public class ProductStorage {
    //The parameters of this HashMap is the name of the product and the shaft containing
    //the quantity of the product.

    public final HashMap<String, Shaft> container;

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

        if (container.containsKey(product.getName()) && productsCount > 0) {
            EnumerableShaft shaft = (EnumerableShaft) container.get(product.getName());
            shaft.add(productsCount);
        } else {
            EnumerableShaft enumShaft = new EnumerableShaft();
            enumShaft.add(productsCount);
            container.put(product.getName(), enumShaft);
        }
        updateRestaurantTurnover(product, productsCount);
    }

    public void addProductPerKilogram(Product product, double weightInKilogram) {

        if (container.containsKey(product.getName()) && weightInKilogram > 0) {
            ShaftPerKilogram shaft = (ShaftPerKilogram) container.get(product.getName());
            shaft.add(weightInKilogram);
        } else {
            ShaftPerKilogram enumShaft = new ShaftPerKilogram();
            enumShaft.add(weightInKilogram);
            container.put(product.getName(), enumShaft);
        }
        updateRestaurantTurnover(product, weightInKilogram);
    }

    public void addProductPerLiter(Product product, double volumeInLitres) {

        if (container.containsKey(product.getName()) && volumeInLitres > 0) {
            ShaftPerLiter shaft = (ShaftPerLiter) container.get(product.getName());
            shaft.add(volumeInLitres);
        } else {
            ShaftPerLiter enumShaft = new ShaftPerLiter();
            enumShaft.add(volumeInLitres);
            container.put(product.getName(), enumShaft);
        }
        updateRestaurantTurnover(product, volumeInLitres);
    }

    public void getEnumerableProduct(Product product, int productsCount) throws ProductOutOfStockException {
        if (productsCount > 0) {
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
    }

    public void getProductPerGram(Product product, double weightInGrams) throws ProductOutOfStockException {
        if (weightInGrams > 0) {
            if (container.containsKey(product.getName())) {
                ShaftPerKilogram shaft = (ShaftPerKilogram) container.get(product.getName());
                double grams = weightInGrams / 1000;
                if (shaft.getQuantity() >= grams) {
                    shaft.get(grams);
                } else {
                    throw new ProductOutOfStockException(product.getName() + " is out of Stock");
                }
            } else {
                throw new ProductOutOfStockException(product.getName() + " is out of Stock");
            }
        }
    }

    public void getProductPerMilliliter(Product product, double volumeInMillilitres) throws ProductOutOfStockException {
        if (volumeInMillilitres > 0) {
            if (container.containsKey(product.getName())) {
                ShaftPerLiter shaft = (ShaftPerLiter) container.get(product.getName());
                double millilitres = volumeInMillilitres / 1000;
                if (shaft.getQuantity() >= millilitres) {
                    shaft.get(millilitres);
                } else {
                    throw new ProductOutOfStockException(product.getName() + " is out of Stock");
                }
            } else {
                throw new ProductOutOfStockException(product.getName() + " is out of Stock");
            }
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

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Map.Entry<String, Shaft> record : container.entrySet()) {
            if (record.getValue() instanceof EnumerableShaft) {
                data.append(String.format("%-10s | %-5d pieces\n", record.getKey(), record.getValue().getQuantity()));
            } else if (record.getValue() instanceof ShaftPerKilogram) {
                data.append(String.format("%-10s | %-5.2f kilos\n", record.getKey(), record.getValue().getQuantity()));
            } else if (record.getValue() instanceof ShaftPerLiter) {
                data.append(String.format("%-10s | %-5.2f litres\n", record.getKey(), record.getValue().getQuantity()));
            }
        }
        data.append("Count of products = ").append(container.size());
        return String.valueOf(data);
    }

    private void updateRestaurantTurnover(Product product, double quantity) {
        double spentMoney = quantity * product.getPrice();
        Restaurant.turnover -= spentMoney;
    }

    private void updateRestaurantTurnover(Product product, int quantity) {
        double spentMoney = quantity * product.getPrice();
        Restaurant.turnover -= spentMoney;
    }

    public void emptying() {
        this.container.clear();
    }

}