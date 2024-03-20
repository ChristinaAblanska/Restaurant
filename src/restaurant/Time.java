package restaurant;

public class Time {

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
        return hour + ":" + min + ":" + sec;
    }
}
