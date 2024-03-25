package restaurant.building_blocks.kitchen.storage.shaft;

public class EnumerableShaft extends Shaft<Integer> {
    public EnumerableShaft() {
        super.quantity = 0;
    }

    @Override
    public void add(Integer productCount) {
        super.quantity += productCount;
    }

    @Override
    public void get(Integer productCount) {
        super.quantity -= productCount;
    }

    @Override
    public Integer getQuantity() {
        return super.quantity;
    }
}