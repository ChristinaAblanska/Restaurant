package restaurant.building_blocks.room.kitchen.storage.shaft;

public class ShaftPerLiter extends Shaft<Double> {
    public ShaftPerLiter() {
        super.value = 0.0;
    }

    @Override
    public void add(Double volumeInLitres) {
        super.value += volumeInLitres;
    }

    @Override
    public void get(Double volumeInLitres) {
        super.value -= volumeInLitres;
    }

    @Override
    public Double getValue() {
        return super.value;
    }
}