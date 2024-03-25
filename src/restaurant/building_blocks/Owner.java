package restaurant.building_blocks;

import restaurant.Restaurant;

public class Owner {
    private final Restaurant restaurant;

    public Owner(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void payWaitersSalaries() {
        Restaurant.turnover -= restaurant.getWaiter_1().getSalary();
        Restaurant.turnover -= restaurant.getWaiter_2().getSalary();
    }

    public void payCookSalary() {
        Restaurant.turnover -= restaurant.getKitchen().getCook().getSalary();
    }

    public void payManagerSalary() {
        Restaurant.turnover -= restaurant.getManager().getSalary();
    }

    public void payCleanerSalary() {
        Restaurant.turnover -= restaurant.getCleaner().getSalary();;
    }
}
