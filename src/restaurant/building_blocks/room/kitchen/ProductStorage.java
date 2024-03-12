package restaurant.building_blocks.room.kitchen;


import restaurant.building_blocks.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductStorage {

    private final HashMap<String, ProductStorage.Shaft> container;

    public ProductStorage() {
        container = new HashMap<>();
    }

    public double getStock(String productName) {
        if (container.containsKey(productName)) {
            Shaft shaft = container.get(productName);
            return shaft.getQuantity();
        }
        return 0;
    }

    public void addProduct(Product product, Product.Unit unit, double quantityPerUnit, int productsCount) {
        double quantity = quantityPerUnit * unit.getValue();
        if (container.containsKey(product.getName())) {
            Shaft shaft = container.get(product.getName());
            shaft.add(quantity, productsCount);
        } else {
            Shaft newShaft = new Shaft(unit);
            newShaft.add(quantity, productsCount);
            container.put(product.getName(), newShaft);
        }
    }

    public void getProduct(Product product, Product.Unit unit, double quantity) throws ProductOutOfStockException {
        if (quantity > 0) {
            if (container.containsKey(product.getName())) {
                Shaft shaft = container.get(product.getName());
                double totalQuantity = quantity * unit.getValue();
                double shaftQuantity = shaft.getQuantity();

                if (unit.equals(Product.Unit.Брой)) {

                    if (shaft.getProductsCount() >= totalQuantity) {
                        shaft.getPiece(totalQuantity);
                    } else {
                        throw new ProductOutOfStockException("Продукта е изчерпан");
                    }
                } else {
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
    }

    public void printStock() {
        for (Map.Entry<String, Shaft> record : container.entrySet()) {
            Shaft s = record.getValue();
            System.out.println(record.getKey() + " | " + s.quantity + " " +
                    s.quantityUnit + "  " + s.getProductsCount());
        }
    }

    public static class Shaft {
        private double quantity;

        public Shaft(Product.Unit quantityUnit) {
            this.quantityUnit = quantityUnit;
        }

        public Product.Unit getQuantityUnit() {
            return quantityUnit;
        }


        private Product.Unit quantityUnit;

        public double getProductsCount() {
            return productsCount;
        }

        private double productsCount;

        public double getQuantity() {
            return quantity;
        }

        public void add(double quantity, double productsCount) {
            this.productsCount += productsCount;
            this.quantity += quantity;
        }

        public void get(double quantity) {
            double quantityForSingleProduct = (this.quantity / productsCount);
            this.quantity -= quantity;

            double productCountForGivenQuantity = quantity / quantityForSingleProduct;

            productsCount -= productCountForGivenQuantity;
        }

        public void getPiece(double count) {
            double quantityForSingleProduct = quantity / productsCount;
            this.quantity -= quantityForSingleProduct * count;
            String formatted = String.format("%.1f", quantity);
            quantity = Double.parseDouble(formatted.replaceAll(",", "."));
            productsCount -= count;
        }
    }
}