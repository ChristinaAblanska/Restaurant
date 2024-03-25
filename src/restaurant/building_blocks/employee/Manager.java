package restaurant.building_blocks.employee;

import restaurant.Restaurant;

public class Manager extends Employee {
    private final Restaurant restaurant;

    public Manager(Restaurant restaurant, double salary) {
        super();
        this.restaurant = restaurant;
        this.salary = salary;
    }

    public void openRestaurant() {
        restaurant.setOpenRestaurant(true);
    }

    public void closeRestaurant() {
        restaurant.setOpenRestaurant(false);
    }
}
