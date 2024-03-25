package restaurant.building_blocks.kitchen.storage.shaft;

public abstract  class Shaft<T> {
    T quantity;

    public abstract void add(T value);

    public abstract void get(T value);

    public abstract T getQuantity();

}