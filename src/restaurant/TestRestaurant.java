package restaurant;

import org.junit.Before;
import org.junit.Test;
import restaurant.building_blocks.Order;


public class TestRestaurant {

    private WorkDay workDay;
    private Restaurant shipka;

    @Before
    public void setup() throws InterruptedException {
        shipka = new Restaurant(10, 4, 1);
        //Here speed up the work day 1000 times.
        //In other words we set the work time per day to 28,8 seconds.
        workDay = new WorkDay(shipka);

    }

    @Test
    public void test_restaurant_invite_clients() {

        workDay.start();
        try {
            workDay.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        int groupNumber = 1;
        while (workDay.isRun()) {
            //System.out.println(workDay.getHourlyLoad());
            if (shipka.getOccupiedTablesNumber() < workDay.getHourlyLoad()) {
                // System.out.println(workDay.getHourlyLoad());

                RestaurantClientsGroup group = new RestaurantClientsGroup(groupNumber, shipka);
                Thread t = new Thread(group);
                t.start();

                groupNumber++;
            }
        }
    }
}
