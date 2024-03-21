package restaurant.building_blocks;

import restaurant.Restaurant;

public class Owner {
    private final Restaurant restaurant;

    public Owner(Restaurant restaurant) {
        this.restaurant = restaurant;
        restaurant = restaurant;
    }

    public void openRestaurant() {
        restaurant.setOpenRestaurant(true);
    }
}
