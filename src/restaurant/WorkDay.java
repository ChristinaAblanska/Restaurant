package restaurant;

import restaurant.building_blocks.Client;

import java.util.ArrayList;
import java.util.List;

public class WorkDay extends Thread {

    private final int workTimeInMilliseconds;
    private final int workDayInHours;
    private final Restaurant restaurant;
    private long workTimeStart;
    private double localTimeInMillis;
    int[] dailyWorkload;

    public WorkDay(Restaurant restaurant, int workDayInHours, int speedUpValue) {
        if (speedUpValue < 1) {
            speedUpValue = 1;
        }
        this.workDayInHours = workDayInHours;
        workTimeInMilliseconds = (((workDayInHours * 3600) / speedUpValue)) * 1000;
        dailyWorkload = new int[workDayInHours];
        this.restaurant = restaurant;
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

    public int getHour() {
        return (int) (localTimeInMillis / 3600) + 1;
    }

    public void setDailyWorkload(int... workLoadValuesPerDay) {
        if (workLoadValuesPerDay.length == workDayInHours) {
            for (int i = 0; i < workLoadValuesPerDay.length; i++) {
                if (workLoadValuesPerDay[i] <= restaurant.getTableNumber()) {
                    dailyWorkload[i] = workLoadValuesPerDay[i];
                } else {
                    //throw ...
                }
            }
        } else {
            //throw ...
        }
    }

    public int getHourlyLoad(int hour) {
        return dailyWorkload[hour];
    }

    public List<Client> generateClients() {
        List<Client> clients = new ArrayList<>();
        int load = dailyWorkload[getHour()-1];
        for (int i = 0; i <load; i++) {
            System.out.println("generate"+load+" clients");
        }
        return clients;
    }
}

