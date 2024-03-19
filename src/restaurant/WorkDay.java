package restaurant;

import restaurant.building_blocks.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkDay extends Thread {
    private static final int speedUpValue = Parameters.WORK_DAY_SPEEDUP_VALUE;
    Random rand = new Random();
    private final int workTimeInMilliseconds;
    private final int workDayHours = Parameters.WORK_DAY_HOURS;
    private final Restaurant restaurant;
    private long workTimeStart;


    private static double localTimeInMillis;

    public WorkDay(Restaurant restaurant) {

        workTimeInMilliseconds = (((workDayHours * 3600) / speedUpValue)) * 1000;
        this.restaurant = restaurant;
    }

    public static String millisToTime(double timeInMillis) {

        return String.valueOf(millisToHour(timeInMillis)) + ":"
                + String.valueOf(millisToMinutes(timeInMillis)) + ":"
                + String.valueOf(millisToSeconds(timeInMillis));
    }

    @Override
    public void start() {
        workTimeStart = System.currentTimeMillis();
    }

    public boolean isRun() {
        double currentTime = System.currentTimeMillis();
        if ((currentTime - workTimeStart)
                > workTimeInMilliseconds) {
            this.interrupt();
            return false;
        }

        localTimeInMillis = currentTime - workTimeStart;
        return true;
    }

    public static int millisToHour(double localTimeInMillis) {
        // return (int) (localTimeInMillis / 3600) + 1;
        return (int) ((localTimeInMillis * speedUpValue) / (1000 * 60 * 60)) % 24;
    }

    public static int millisToMinutes(double localTimeInMillis) {
        return (int) (localTimeInMillis * speedUpValue) / (1000 * 60) % 60;
    }

    public static double millisToSeconds(double localTimeInMillis) {
        return (int) (((localTimeInMillis * speedUpValue) / 1000) % 60);
    }

    public int getHourlyLoad() {
        return Parameters.DAILY_WORKLOAD_HOURS[millisToHour(localTimeInMillis)];
    }

    public static String getLocalTimeAsString() {
        return millisToTime(localTimeInMillis);
    }

    public double getLocalTimeMillis() {
        return localTimeInMillis;
    }
}

