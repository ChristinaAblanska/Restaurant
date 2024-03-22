package restaurant.simulation;

public class WorkDay extends Thread {
    public static HistoryLog history = new HistoryLog();
    private final int workTimeInMilliseconds;
    private long workTimeStart;
    private static Time time;
    private static double localTimeInMillis;

    public WorkDay() {
        workTimeInMilliseconds = (((SimulatorParameters.WORK_DAY_HOURS * 3600) / SimulatorParameters.WORK_DAY_SPEEDUP_VALUE)) * 1000;
        time = new Time();
        time.set(millisToHour(localTimeInMillis) + SimulatorParameters.WORK_DAY_START_HOUR,
                millisToMinutes(localTimeInMillis),
                millisToSeconds(localTimeInMillis));
    }

    public static int minutesToLocalTime(int minutes) {
        return (minutes * 60000) / SimulatorParameters.WORK_DAY_SPEEDUP_VALUE;
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
        time.set(millisToHour(localTimeInMillis) + SimulatorParameters.WORK_DAY_START_HOUR,
                millisToMinutes(localTimeInMillis),
                millisToSeconds(localTimeInMillis));
        return true;
    }

    private int millisToHour(double localTimeInMillis) {
        return (int) ((localTimeInMillis * SimulatorParameters.WORK_DAY_SPEEDUP_VALUE) / (1000 * 60 * 60)) % 24;
    }

    private int millisToMinutes(double localTimeInMillis) {
        return (int) (localTimeInMillis * SimulatorParameters.WORK_DAY_SPEEDUP_VALUE) / (1000 * 60) % 60;
    }

    private int millisToSeconds(double localTimeInMillis) {
        return (int) (((localTimeInMillis * SimulatorParameters.WORK_DAY_SPEEDUP_VALUE) / 1000) % 60);
    }

    public int getHourlyLoad() {
        return SimulatorParameters.DAILY_WORKLOAD_HOURS[millisToHour(localTimeInMillis)];
    }

    public static Time getTime() {
        return time;
    }
}

