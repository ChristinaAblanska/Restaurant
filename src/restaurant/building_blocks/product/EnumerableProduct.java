package restaurant.building_blocks.product;

public class EnumerableProduct extends Product {
    private final double pricePerPiece;

    public EnumerableProduct(String name, double pricePerPiece) {
        super(name);
        this.pricePerPiece = pricePerPiece;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }
}
