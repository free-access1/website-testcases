package Examples;

// researching of date format for inserting in DB-field  

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateTimeExample {

    public static void main (String[] args) {
        Date date1 = new Date();
        System.out.println("date1: " + date1.toString());
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        System.out.println("Date1: " + ft.format(date1));

        Date date2 = Calendar.getInstance().getTime();
        System.out.println("Date2: " + ft.format(date2));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(Calendar.DATE, -1);
        calendar.add(Calendar.MINUTE, -1);
        System.out.println("Date2 - 1day - 1min: " + ft.format(calendar.getTime()));
    }
}