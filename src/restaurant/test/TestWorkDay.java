package restaurant.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.Restaurant;
import restaurant.WorkDay;

public class TestWorkDay {

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
    public void test_one_work_day_cycle() {

        workDay.start();
        while (workDay.isRun()) {
        }
        //Assert.assertEquals(8, workDay.getHour());
    }

    @Test
    public void test_one_work_day_hourlyWorkload() {

        workDay.start();
        while (workDay.isRun()) {
/*
            if (workDay.getHour() == 1) {
                Assert.assertEquals(2, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 2) {
                Assert.assertEquals(4, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 3) {
                Assert.assertEquals(6, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 4) {
                Assert.assertEquals(4, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 5) {
                Assert.assertEquals(8, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 6) {
                Assert.assertEquals(7, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 7) {
                Assert.assertEquals(6, workDay.getHourlyLoad());
            }
            if (workDay.getHour() == 8) {
                Assert.assertEquals(8, workDay.getHourlyLoad());
            }*/
        }
    }
}
