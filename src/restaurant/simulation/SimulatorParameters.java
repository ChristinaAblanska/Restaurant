package restaurant.simulation;

public class SimulatorParameters {
    public static final int WORK_DAY_SPEEDUP_VALUE = 2000;
    public static final int WORK_DAY_START_HOUR = 9;
    //Reject to invite clients and start to clean the restaurant.
    //If the value is "30" that mean the restaurant will reject 30
    // minutes before the end of the wok day.
    public static final Time CLEANING_START_TIME = new Time(16, 15);
    public static final int WORK_DAY_HOURS = 8;
    public static final int[] DAILY_WORKLOAD_HOURS = {2, 4, 5, 4, 8, 7, 6, 8};

}
