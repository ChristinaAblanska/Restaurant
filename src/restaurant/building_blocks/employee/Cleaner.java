package restaurant.building_blocks.employee;

import restaurant.simulation.WorkDay;

public class Cleaner extends Employee {
    int trigger;

    public Cleaner(double salary) {
        this.salary = salary;
    }

    public void cleanRestaurant() {
        if (trigger == 0) {
            WorkDay.historyAsString.addData("Cleaning restaurant time =" + WorkDay.getTime());
        }
        trigger = 1;
    }
}
