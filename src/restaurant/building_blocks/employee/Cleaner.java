package restaurant.building_blocks.employee;

import restaurant.Restaurant;
import restaurant.WorkDay;

public class Cleaner extends Employee {
    int trigger;

    public void cleanRestaurant() {
        if (trigger == 0) {
            Restaurant.history.addData("Clean restaurant time =" + WorkDay.getTime());
        }
        trigger = 1;
    }
}
