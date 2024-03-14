package restaurant.building_blocks.product;

public class ProductPerKilogram extends Product {
    private final double pricePerOneKilogram;

    public ProductPerKilogram(String name, double pricePerKilogram) {
        super(name);
        this.pricePerOneKilogram = pricePerKilogram;
    }

    public double getPricePerOneKilogram() {
        return pricePerOneKilogram;
    }
}
