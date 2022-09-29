import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MyDate {
    private int year, month, day;

    public MyDate() {
        LocalDateTime now = LocalDateTime.now();
        year = now.getYear();
        month = now.getMonthValue();
        day = now.getDayOfMonth();
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(long elapsedTime) {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(elapsedTime), ZoneOffset.of("+8"));
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfYear();
    }

}
