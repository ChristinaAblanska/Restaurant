package restaurant;

import restaurant.building_blocks.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkDay extends Thread {
    public static HistoryLog history = new HistoryLog();
    private final int workTimeInMilliseconds;
    private long workTimeStart;
    private static Time time;
    private static double localTimeInMillis;

    public WorkDay() {
        workTimeInMilliseconds = (((Parameters.WORK_DAY_HOURS * 3600) / Parameters.WORK_DAY_SPEEDUP_VALUE)) * 1000;
        time = new Time();
        time.set(millisToHour(localTimeInMillis) + Parameters.WORK_DAY_START_HOUR,
                millisToMinutes(localTimeInMillis),
                millisToSeconds(localTimeInMillis));
    }

    public static int minutesToLocalTime(int minutes) {
        return (minutes * 60000) / Parameters.WORK_DAY_SPEEDUP_VALUE;
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
        time.set(millisToHour(localTimeInMillis) + Parameters.WORK_DAY_START_HOUR,
                millisToMinutes(localTimeInMillis),
                millisToSeconds(localTimeInMillis));
        return true;
    }

    private int millisToHour(double localTimeInMillis) {
        return (int) ((localTimeInMillis * Parameters.WORK_DAY_SPEEDUP_VALUE) / (1000 * 60 * 60)) % 24;
    }

    private int millisToMinutes(double localTimeInMillis) {
        return (int) (localTimeInMillis * Parameters.WORK_DAY_SPEEDUP_VALUE) / (1000 * 60) % 60;
    }

    private int millisToSeconds(double localTimeInMillis) {
        return (int) (((localTimeInMillis * Parameters.WORK_DAY_SPEEDUP_VALUE) / 1000) % 60);
    }

    public int getHourlyLoad() {
        return Parameters.DAILY_WORKLOAD_HOURS[millisToHour(localTimeInMillis)];
    }

    public static Time getTime() {
        return time;
    }
}

