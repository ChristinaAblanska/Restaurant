package restaurant.building_blocks.room.kitchen.storage.shaft;

public class ShaftPerKilogram extends Shaft<Double> {
    public ShaftPerKilogram() {
        super.value = 0.0;
    }

    @Override
    public void add(Double weightInKilogram) {
        super.value += weightInKilogram;
    }

    @Override
    public void get(Double weightInKilogram) {
        super.value -= weightInKilogram;
    }

    @Override
    public Double getValue() {
        return super.value;
    }
}