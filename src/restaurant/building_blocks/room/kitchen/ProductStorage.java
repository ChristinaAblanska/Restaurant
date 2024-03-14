package restaurant.building_blocks.room.kitchen;


import restaurant.building_blocks.product.EnumerableProduct;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLiter;

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
                return ((EnumerableShaft) shaft).getProductsCount();
            } else if (shaft instanceof ShaftPerKilogram) {
                return ((ShaftPerKilogram) shaft).getWeightInKilogram();
            } else {
                return ((ShaftPerLiter) shaft).getVolumeInLitres();
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

    public abstract static class Shaft<T> {
        private T value;

        void add(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private static class EnumerableShaft extends Shaft<Integer> {
        public EnumerableShaft() {
            super.setValue(0);
        }

        public void add(int productCount) {
            super.setValue(super.getValue() + productCount);
        }

        public int getProductsCount() {
            return super.getValue();
        }
    }

    private static class ShaftPerLiter extends Shaft<Double> {
        public ShaftPerLiter() {
            super.setValue(0.0);
        }

        public void add(double volumeInLitres) {
            super.setValue(super.getValue() + volumeInLitres);
        }

        public double getVolumeInLitres() {
            return super.getValue();
        }
    }

    private static class ShaftPerKilogram extends Shaft<Double> {
        public ShaftPerKilogram() {
            super.setValue(0.0);
        }

        public void add(double weightInKilogram) {
            super.setValue(super.getValue() + weightInKilogram);
        }

        public double getWeightInKilogram() {
            return super.getValue();
        }
    }
}