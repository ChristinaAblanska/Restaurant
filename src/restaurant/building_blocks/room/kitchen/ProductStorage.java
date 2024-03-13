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
            String formatted = String.format("%.1f", shaft.getQuantity());
            return Double.parseDouble(formatted.replaceAll(",", "."));
        }
        return 0;
    }

    /** When we add  by Product.Unit.Брой we must initialize @param weight with
     * value in unit of gram.
     * @param product
     * @param unit
     * @param weight
     * @param count   We put here a number > 1 if the Product that we want to add
     *                        to the ProductStorage is composite.
     * @implNote Example of composite product: addProduct(onion, Product.Unit.Kilogram, 1,20)-
     * Here we have 1 Kilogram of onion composed of 20 pcs.
     */
    public void addProduct(Product product, Product.Unit unit, double weight, int count) {
        double quantity = weight * unit.getValue() / product.getUnit().getValue();
        if (container.containsKey(product.getName())) {
            Shaft shaft = container.get(product.getName());
            shaft.add(quantity, count);
        } else {
            Shaft newShaft = new Shaft(product.getUnit());
            newShaft.add(quantity, count);
            container.put(product.getName(), newShaft);
        }
    }

    public void getProduct(Product product, Product.Unit unit, double quantity) throws ProductOutOfStockException {

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
    }

    public void printStock() {
        for (Map.Entry<String, Shaft> record : container.entrySet()) {
            Shaft s = record.getValue();
            System.out.println(record.getKey() + " | тегло: "
                    + getStock(record.getKey()) + " " + "  Брой: "
                    + String.format("%.2f", s.getProductsCount()));
        }
    }

    public void emptying() {
        this.container.clear();
    }

    private static class Shaft {
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