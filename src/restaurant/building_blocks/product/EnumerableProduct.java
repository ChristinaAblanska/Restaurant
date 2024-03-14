package restaurant.building_blocks.product;

public class EnumerableProduct extends Product {
    public EnumerableProduct(String name, double pricePer_1_Piece) {
        super(name, pricePer_1_Piece);
    }

    public double getPricePer_1_Piece() {
        return price;
    }
}
