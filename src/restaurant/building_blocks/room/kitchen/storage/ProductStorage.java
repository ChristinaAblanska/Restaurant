package restaurant.building_blocks.room.kitchen.storage;


import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.exceptions.ProductOutOfStockException;
import restaurant.building_blocks.room.kitchen.storage.shaft.EnumerableShaft;
import restaurant.building_blocks.room.kitchen.storage.shaft.Shaft;
import restaurant.building_blocks.room.kitchen.storage.shaft.ShaftPerKilogram;
import restaurant.building_blocks.room.kitchen.storage.shaft.ShaftPerLiter;

import java.util.HashMap;

public class ProductStorage {

    private final HashMap<String, Shaft> container;

    public ProductStorage() {
        container = new HashMap<>();
    }

    public double getStock(String productName) {

        if (container.containsKey(productName)) {
            Shaft shaft = container.get(productName);
            if (shaft instanceof EnumerableShaft) {
                return ((EnumerableShaft) shaft).getValue();
            } else if (shaft instanceof ShaftPerKilogram) {
                return ((ShaftPerKilogram) shaft).getValue();
            } else {
                return ((ShaftPerLiter) shaft).getValue();
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

/*    public void getProduct(Product product, Product.Unit unit, double quantity) throws ProductOutOfStockException {

        if (quantity > 0) {
            if (container.containsKey(product.getName())) {
                Shaft shaft = container.get(product.getName());
                double shaftQuantity = shaft.getQuantity();
                if (unit.equals(Product.Unit.Брой)) {
                    double totalQuantity = quantity * unit.getValue();
                    if (shaft.getProductsCount() >= totalQuantity) {
                        shaft.getPiece(totalQuantity);
                    } else {
                        throw new ProductOutOfStockException("Продукта е изчерпан");
                    }
                } else {
                    double totalQuantity = quantity * unit.getValue() / product.getUnit().getValue();
                    if (shaftQuantity >= totalQuantity) {

                        shaft.get(totalQuantity);
                    } else {
                        throw new ProductOutOfStockException("Продукта е изчерпан");
                    }
                }
            } else {
                throw new ProductOutOfStockException("Продукта е изчерпан");
            }
        }
    }*/

 /*   public void printStock() {
        for (Map.Entry<String, Shaft> record : container.entrySet()) {
            Shaft s = record.getValue();
            System.out.println(record.getKey() + " | тегло: "
                    + getStock(record.getKey()) + " " + "  Брой: "
                    + String.format("%.2f", s.getProductsCount()));
        }
    }*/

    public void emptying() {
        this.container.clear();
    }

    public void getEnumerableProduct(Product product, int productsCount) throws ProductOutOfStockException {
        if (container.containsKey(product.getName())) {
            EnumerableShaft shaft = (EnumerableShaft) container.get(product.getName());
            if (shaft.getValue() > 0) {
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
            if (shaft.getValue() > 0) {
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
            if (shaft.getValue() > 0) {
                shaft.get(volumeInLitres);
            } else {
                throw new ProductOutOfStockException(product.getName() + " is out of Stock");
            }
        } else {
            throw new ProductOutOfStockException(product.getName() + " is out of Stock");
        }
    }


}