package restaurant.building_blocks.room.kitchen;


import restaurant.building_blocks.Product;

import java.util.HashMap;

public class ProductStorage {

    private final HashMap<String, ProductStorage.Shaft> container;

    public ProductStorage() {
        container = new HashMap<>();
    }

    public int getStock(String productName) {
        if (container.containsKey(productName)) {
            Shaft shaft = container.get(productName);
            return shaft.getQuantity();
        }
        return 0;
    }

    public void addProduct(Product product, int quantity) {
        if (container.containsKey(product.getName())) {
            Shaft shaft = container.get(product.getName());
            shaft.add(quantity);
        } else {
            Shaft newShaft = new Shaft();
            newShaft.add(quantity);
            container.put(product.getName(), newShaft);
        }
    }

    public void getProduct(Product product, int quantity) throws ProductOutOfStockException {
        if (quantity > 0) {
            if (container.containsKey(product.getName())) {
                Shaft shaft = container.get(product.getName());
                if (quantity <= shaft.getQuantity()) {
                    shaft.get(quantity);
                } else {
                    throw new ProductOutOfStockException("Продукта е изчерпан");
                }
            } else {
                throw new ProductOutOfStockException("Продукта е изчерпан");
            }
        }
    }

    public static class Shaft {
        private int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void add(int quantity) {
            this.quantity += quantity;
        }

        public void get(int quantity) {
            if (this.quantity >= quantity) {
                this.quantity -= quantity;
            }
        }
    }
}