package restaurant.building_blocks.product;

public class ProductPerLiter extends Product {
    private final double pricePerOneLiter;

    public ProductPerLiter(String name, double pricePerOneLiter) {
        super(name);
        this.pricePerOneLiter = pricePerOneLiter;
    }

    public double getPricePerOneLiter() {
        return pricePerOneLiter;
    }
}
