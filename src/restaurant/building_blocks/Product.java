package restaurant.building_blocks;

public class Product {
    private final String name;
    private final Unit unit;
    private final double pricePerUnit;

    public enum Unit {
        Грам, Брой, Милилитър
    }

    public Product(String name, Unit unit, double pricePerUnit) {
        this.name = name;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}