package restaurant.building_blocks.employee;

import restaurant.simulation.WorkDay;

public class Cleaner extends Employee {
    int trigger;

    public void cleanRestaurant() {
        if (trigger == 0) {
            WorkDay.history.addData("Clean restaurant time =" + WorkDay.getTime());
        }
        trigger = 1;
    }
}
