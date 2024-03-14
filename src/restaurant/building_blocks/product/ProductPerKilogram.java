package restaurant.building_blocks.product;

public class ProductPerKilogram extends Product {

    public ProductPerKilogram(String name, double pricePer_1_Kilogram) {
        super(name, pricePer_1_Kilogram);
    }

    public double getPricePer_1_Kilogram() {
        return price;
    }

    public double getPricePer_100_Gram() {
        return price / 100;
    }
}
