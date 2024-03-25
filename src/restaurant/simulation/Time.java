package restaurant.simulation;

public class Time implements Comparable {

    private int hour;
    private int min;
    private int sec;

    public Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public Time() {
    }

    public void set(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    @Override
    public String toString() {
        return hour + ":" + min;
    }

    @Override
    public int compareTo(Object o) {
        Time time = (Time) o;
        if (time.getHour() == this.hour && time.getMin() == this.min) {
            return 0;
        }
        if (time.getHour() > this.hour && time.getMin() > this.min) {
            return 1;
        } else {
            return -1;
        }
    }
}
