package restaurant.building_blocks;

public class Product {
    private final String name;
    private final Unit unit;
    private final double pricePerUnit;

    public enum Unit {
        Грам(1), Килограм(1000), Брой(1), Милилитър(1), Кафена_чаша(100), Чаена_лъжица(20), Супена_лъжица(30);

        public int getValue() {
            return value;
        }

        private final int value;

        Unit(int value) {
            this.value = value;
        }
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

    public Unit getUnit() {
        return unit;
    }
}