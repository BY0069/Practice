import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDate {
    private int year, month, day;

    public MyDate() {
        Date date = new Date();
        setDate(date.getTime());
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month + 1;
        this.day = day;
    }

    public void setDate(long elapsedTime) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

}
