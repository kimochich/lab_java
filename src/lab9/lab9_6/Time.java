package lab9.lab9_6;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void nextSecond() {
        this.second ++;
        if (this.second >= 60) {
            this.minute ++;
            this.second = 0;
        }
        if (this.minute >= 60) {
            this.hour ++;
            this.minute = 0;
        }
        if (this.hour == 24) {
            this.hour = 0;
        }
    }

    public void previousSecond() {
        this.second --;
        if (this.second < 0) {
            this.minute --;
            this.second = 59;
        }
        if (this.minute < 0) {
            this.hour --;
            this.minute = 59;
        }
        if (this.hour < 0) {
            this.hour = 23;
        }
    }

    void display() {
        String hour = this.hour + "";
        String minute = this.minute + "";
        String second = this.second + "";
        if (hour.length() == 1) hour = "0" + hour;
        if (minute.length() == 1) minute = "0" + minute;
        if (second.length() == 1) second = "0" + second;
        System.out.println(hour + ":" + minute + ":" + second);
    }
}
