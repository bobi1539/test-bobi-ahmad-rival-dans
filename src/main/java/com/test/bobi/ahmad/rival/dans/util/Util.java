package com.test.bobi.ahmad.rival.dans.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {
    public static Timestamp timestampNow(){
        Calendar calendar = new GregorianCalendar();
        return Timestamp.from(calendar.toInstant());
    }

    public static Date addHours(Date date, int hours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}
