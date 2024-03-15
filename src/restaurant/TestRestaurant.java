package restaurant;

import org.junit.Before;
import org.junit.Test;

public class TestRestaurant {

    private WorkDay workDay;
    private Restaurant shipka;

    @Before
    public void setup() {
        shipka = new Restaurant(10, 4);
        //Here speed up the work day 1000 times.
        //In other words we set the work time per day to 28,8 seconds.
        workDay = new WorkDay(shipka, 8, 1000);

        workDay.setDailyWorkload(2, 4, 6, 4, 8, 7, 6, 8);
    }

    @Test
    public void test_restaurant_invite_clients() {

        workDay.start();
        while (workDay.isRun()) {

           // if(workDay.getHourlyLoad() )
            shipka.inviteClients(workDay.generateClients());
           // System.out.println(workDay.getHour());

        }
    }
}
