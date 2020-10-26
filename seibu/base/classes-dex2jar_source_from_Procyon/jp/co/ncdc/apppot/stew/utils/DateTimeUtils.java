// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import android.util.Log;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class DateTimeUtils
{
    private static final String TAG = "DateTimeUtils";
    private static SimpleDateFormat dateFormat;
    public static final String yyyyMMdd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMdd_T_HH_mm_ssSSSZ = "yyyy-MM-dd'T'HH:mm:ss.sssZ";
    
    static {
        DateTimeUtils.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }
    
    public static final Date addSecond(final long n, final int n2) {
        return addSecond(new Date(1000L * n), n2);
    }
    
    public static final Date addSecond(final Date time, final int n) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        instance.add(13, n);
        return instance.getTime();
    }
    
    public static final boolean compareExpiredDate(final long n, final int n2) {
        return compareExpiredDate(new Date(1000L * n), n2);
    }
    
    public static final boolean compareExpiredDate(final Date obj, final int n) {
        final Date addSecond = addSecond(obj, n);
        final Date obj2 = new Date();
        Log.d("DateTimeUtils", "[compareExpiredDate] now=" + obj2 + ", target=" + obj + ", expiredDate=" + addSecond);
        return obj2.after(addSecond);
    }
    
    public static final Date convertToUnixDate(final Date date) {
        if (date == null) {
            return date;
        }
        return new Date(date.getTime() / 1000L * 1000L);
    }
    
    public static final String currentDateString() {
        return dateToString(new Date(System.currentTimeMillis()));
    }
    
    public static final long currentTimeSecondsUnit() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long seconds = TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis);
        Log.d("DateTimeUtils", "secondDate=" + seconds + ", currentTimeMillis=" + currentTimeMillis);
        return seconds;
    }
    
    public static final Date currentTimeSecondsUnitDate() {
        return new Date(currentTimeSecondsUnit() * 1000L);
    }
    
    public static final String dateToString(final Date date) {
        return DateTimeUtils.dateFormat.format(date);
    }
    
    public static final Date stringToDate(final String source) {
        try {
            return DateTimeUtils.dateFormat.parse(source);
        }
        catch (ParseException ex) {
            return null;
        }
    }
}
