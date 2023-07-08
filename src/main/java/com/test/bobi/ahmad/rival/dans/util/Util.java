package com.test.bobi.ahmad.rival.dans.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {
    public static Timestamp timestampNow(){
        Calendar calendar = new GregorianCalendar();
        return Timestamp.from(calendar.toInstant());
    }
}
