package restaurant.building_blocks.kitchen.storage.shaft;

public class ShaftPerLiter extends Shaft<Double> {
    public ShaftPerLiter() {
        super.quantity = 0.0;
    }

    @Override
    public void add(Double volumeInLitres) {
        super.quantity += volumeInLitres;
    }

    @Override
    public void get(Double volumeInLitres) {
        super.quantity -= volumeInLitres;
    }

    @Override
    public Double getQuantity() {
        return super.quantity;
    }
}