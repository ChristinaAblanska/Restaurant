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
    private static int workDayStartHour = Parameters.WORK_DAY_START_HOUR;
    private long workTimeStart;
    private static Time time;

    private static double localTimeInMillis;

    public WorkDay() {
        workTimeInMilliseconds = (((workDayHours * 3600) / speedUpValue)) * 1000;
        time = new Time();
    }

    public static int minutesToLocalTime(int minutes) {

        return (minutes * 60000) / speedUpValue;
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

        time.set(millisToHour(localTimeInMillis) + workDayStartHour,
                millisToMinutes(localTimeInMillis),
                millisToSeconds(localTimeInMillis));

        return true;
    }

    private int millisToHour(double localTimeInMillis) {
        // return (int) (localTimeInMillis / 3600) + 1;
        return (int) ((localTimeInMillis * speedUpValue) / (1000 * 60 * 60)) % 24;
    }

    private int millisToMinutes(double localTimeInMillis) {
        return (int) (localTimeInMillis * speedUpValue) / (1000 * 60) % 60;
    }

    private int millisToSeconds(double localTimeInMillis) {
        return (int) (((localTimeInMillis * speedUpValue) / 1000) % 60);
    }

    public int getHourlyLoad() {
        return Parameters.DAILY_WORKLOAD_HOURS[millisToHour(localTimeInMillis)];
    }

    public static Time getTime() {
        return time;
    }
}

