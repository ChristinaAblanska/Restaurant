package restaurant.building_blocks.kitchen.storage.shaft;

public class ShaftPerKilogram extends Shaft<Double> {
    public ShaftPerKilogram() {
        super.quantity = 0.0;
    }

    @Override
    public void add(Double weightInKilogram) {
        super.quantity += weightInKilogram;
    }

    @Override
    public void get(Double weightInKilogram) {
        super.quantity -= weightInKilogram;
    }

    @Override
    public Double getQuantity() {
        return super.quantity;
    }
}