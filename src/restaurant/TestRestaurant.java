package restaurant;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestRestaurant {

    private WorkDay workDay;
    private Restaurant shipka;

    Time cleaningTime = new Time(Parameters.WORK_DAY_HOURS + Parameters.WORK_DAY_START_HOUR - 1
            , Parameters.CLEANING_START_TIME_MINUTES_BEFORE_CLOSE);

    @Before
    public void setup() throws InterruptedException {
        shipka = new Restaurant("Shipka", 10, 4, 2, cleaningTime);
        //Here speed up the work day 1000 times.
        //In other words we set the work time per day to 28,8 seconds.
        workDay = new WorkDay();
    }

    @Test
    public void test_restaurant_invite_clients() {

        workDay.start();
        try {
            workDay.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ArrayList<ClientsGroup> groupsArray = new ArrayList<>();
        int groupNumber = 1;

         Restaurant.history.addData(shipka.toString());

        shipka.getOwner().openRestaurant();
        Restaurant.history.addData("Open restaurant time =" + WorkDay.getTime());
        Restaurant.history.addData("Turnover in the beginning =" + Restaurant.turnover);
        while (workDay.isRun()) {

            if (shipka.isOpenRestaurant()) {
                //clean the restaurant
                if (shipka.isCleaningTime(WorkDay.getTime())) {
                    shipka.getCleaner().cleanRestaurant();

                } else
                    //invite clients
                    if (shipka.getOccupiedTablesNumber() < workDay.getHourlyLoad()) {

                        ClientsGroup group = new ClientsGroup(groupNumber, shipka);
                        groupsArray.add(group);
                        Thread t = new Thread(group);
                        t.start();
                        groupNumber++;
                    }
            }
        }
        Restaurant.history.addData("Turnover in the end =" + Restaurant.turnover);
        for (ClientsGroup clientsGroup : groupsArray) {
            Restaurant.history.addData(clientsGroup.toString());
        }
        Restaurant.history.print();
    }
}
