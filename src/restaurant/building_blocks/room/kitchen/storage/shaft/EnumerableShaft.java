package restaurant.building_blocks.room.kitchen.storage.shaft;

public class EnumerableShaft extends Shaft<Integer> {
    public EnumerableShaft() {
        super.value = 0;
    }

    @Override
    public void add(Integer productCount) {
        super.value += productCount;
    }

    @Override
    public void get(Integer productCount) {
        super.value -= productCount;
    }

    @Override
    public Integer getValue() {
        return super.value;
    }
}