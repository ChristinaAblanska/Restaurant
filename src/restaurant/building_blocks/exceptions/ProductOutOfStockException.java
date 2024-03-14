package restaurant.building_blocks.exceptions;

public class ProductOutOfStockException extends Exception {
    public ProductOutOfStockException(String message) {
        super(message);
    }
}
