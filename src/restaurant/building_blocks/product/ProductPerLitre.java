package restaurant.building_blocks.product;

public class ProductPerLitre extends Product {
    public ProductPerLitre(String name, double pricePer_1_Litre) {
        super(name, pricePer_1_Litre);
    }

    public double getPricePer_1_Litre() {
        return price;
    }

    public double getPricePer_100_Millilitre() {
        return price / 100;
    }
}
