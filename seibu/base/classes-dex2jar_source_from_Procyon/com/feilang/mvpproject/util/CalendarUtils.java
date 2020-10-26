// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.text.TextUtils;
import java.util.Date;
import java.util.TimeZone;
import java.util.Calendar;

public class CalendarUtils
{
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_TIME_FORMAT_DILIVERRY_MONTH = "yyyy\u5e74MM\u6708\u767a\u9001";
    public static final String DATE_TIME_FORMAT_EVENT_DATE = "yyyy\u5e74M\u6708d\u65e5H\u6642";
    public static final String DATE_TIME_FORMAT_FULL_TIME = "yyyy-MM-dd HH:mm:ss Z";
    public static final String DATE_TIME_FORMAT_HOUR = "H\u6642";
    public static final String DATE_TIME_FORMAT_MAIN = "yyyyMMddHHmmssZ";
    public static final String DATE_TIME_FORMAT_NEW_ITEM = "yyyyMMddHHmmssZZZ";
    public static final String DATE_TIME_FORMAT_NEW_ITEM_DAY = "M\u6708d\u65e5H\u6642";
    public static final String DATE_TIME_FORMAT_SEND_DATE = "yyyy\u5e74M\u6708d\u65e5 H:mm";
    public static final String DATE_TIME_FORMAT_SLASH = "yyyy\u5e74M\u6708d\u65e5";
    public static final String DATE_TIME_FORMAT_TIME = "H:mm";
    public static final long MILLIS_IN_DAY = 86400000L;
    public static String TIMEZONE;
    
    static {
        CalendarUtils.TIMEZONE = "GMT+9:00";
    }
    
    public static void clearDate(final Calendar calendar) {
        if (calendar == null) {
            return;
        }
        calendar.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }
    
    public static Calendar createNewCalendar(final int year, final int n, final int date) {
        final Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(year, n - 1, date);
        return instance;
    }
    
    public static Calendar createNewCalendar(final int year, final int n, final int date, final int value, final int value2, final int value3, final int value4) {
        final Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.set(year, n - 1, date);
        instance.set(11, value);
        instance.set(12, value2);
        instance.set(13, value3);
        instance.set(14, value4);
        return instance;
    }
    
    public static Calendar createNewCalendar(Calendar calendar, final int value, final int value2, final int value3, final int value4) {
        if (calendar == null) {
            calendar = null;
        }
        else {
            final Calendar calendar2 = (Calendar)calendar.clone();
            if ((calendar = calendar2) != null) {
                calendar2.set(11, value);
                calendar2.set(12, value2);
                calendar2.set(13, value3);
                calendar2.set(14, value4);
                return calendar2;
            }
        }
        return calendar;
    }
    
    public static long getDaysBetweenDates(Calendar newCalendar, final Calendar calendar) {
        if (newCalendar == null || calendar == null) {
            return -1L;
        }
        newCalendar = createNewCalendar(newCalendar, 0, 0, 0, 0);
        return (createNewCalendar(calendar, 0, 0, 0, 0).getTimeInMillis() - newCalendar.getTimeInMillis()) / 86400000L;
    }
    
    public static Calendar getFirstDateOfMonth(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        calendar = (Calendar)calendar.clone();
        calendar.add(5, calendar.get(5) * -1 + 1);
        return calendar;
    }
    
    public static Calendar getFirstDateOfWeek(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        calendar = (Calendar)calendar.clone();
        calendar.add(5, calendar.get(7) * -1 + 1);
        return calendar;
    }
    
    public static Calendar getLastDateOfMonth(Calendar firstDateOfMonth) {
        if (firstDateOfMonth == null) {
            return null;
        }
        firstDateOfMonth = getFirstDateOfMonth((Calendar)firstDateOfMonth.clone());
        firstDateOfMonth.add(2, 1);
        firstDateOfMonth.add(6, -1);
        return firstDateOfMonth;
    }
    
    public static Calendar getLastDateOfWeek(Calendar firstDateOfWeek) {
        if (firstDateOfWeek == null) {
            return null;
        }
        firstDateOfWeek = getFirstDateOfWeek(firstDateOfWeek);
        firstDateOfWeek.add(6, 6);
        return firstDateOfWeek;
    }
    
    public static Calendar getNextSunday(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        calendar = (Calendar)calendar.clone();
        calendar.add(6, calendar.get(7) * -1 + 8);
        return calendar;
    }
    
    public static String getWeekName(final Calendar calendar) {
        if (calendar == null) {
            return "";
        }
        return (new String[] { "\u65e5", "\u6708", "\u706b", "\u6c34", "\u6728", "\u91d1", "\u571f" })[calendar.get(7) - 1];
    }
    
    public static boolean isBefore(final Calendar calendar, final int value, final int n, final int value2) {
        if (calendar != null) {
            final Calendar calendar2 = (Calendar)calendar.clone();
            calendar2.set(1, value);
            calendar2.set(2, n - 1);
            calendar2.set(5, value2);
            return isBefore(calendar, calendar2);
        }
        return false;
    }
    
    public static boolean isBefore(final Calendar when, final Calendar calendar) {
        boolean b2;
        final boolean b = b2 = false;
        if (when != null) {
            b2 = b;
            if (calendar != null) {
                if (!isSameDate(when, calendar)) {
                    b2 = b;
                    if (!calendar.before(when)) {
                        return b2;
                    }
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    public static boolean isInRange(final Calendar calendar, final Calendar when, final Calendar when2) {
        return calendar != null && when != null && when2 != null && !calendar.before(when) && !calendar.after(when2);
    }
    
    public static boolean isInTerm(final Calendar calendar, final Calendar when, final Calendar when2) {
        boolean b2;
        final boolean b = b2 = false;
        if (calendar != null) {
            b2 = b;
            if (when != null) {
                b2 = b;
                if (when2 != null) {
                    if ((!calendar.after(when) || !calendar.before(when2)) && !isSameDate(calendar, when.get(1), when.get(2) + 1, when.get(5))) {
                        b2 = b;
                        if (!isSameDate(calendar, when2.get(1), when2.get(2) + 1, when2.get(5))) {
                            return b2;
                        }
                    }
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public static boolean isNowInRange(final Calendar calendar, final Calendar calendar2) {
        return isInRange(Calendar.getInstance(), calendar, calendar2);
    }
    
    public static boolean isOverOneHour(final Date date) {
        return date == null || (Calendar.getInstance().getTimeInMillis() - date.getTime()) / 1000L / 60L / 60L > 0L;
    }
    
    public static boolean isSameDate(final Calendar calendar, final int n, final int n2, final int n3) {
        return calendar != null && (calendar.get(1) == n && calendar.get(2) == n2 - 1 && calendar.get(5) == n3);
    }
    
    public static boolean isSameDate(final Calendar calendar, final Calendar calendar2) {
        return calendar != null && calendar2 != null && (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5));
    }
    
    public static boolean isSameDateTime(final Calendar calendar, final Calendar calendar2) {
        return calendar != null && calendar2 != null && (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5) && calendar.get(11) == calendar2.get(11) && calendar.get(12) == calendar2.get(12) && calendar.get(13) == calendar2.get(13));
    }
    
    public static boolean isSameDateTimeWithoutSecond(final Calendar calendar, final Calendar calendar2) {
        return calendar != null && calendar2 != null && (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5) && calendar.get(11) == calendar2.get(11) && calendar.get(12) == calendar2.get(12));
    }
    
    public static boolean isSameMonth(final Calendar calendar, final int n, final int n2) {
        return calendar != null && (calendar.get(1) == n && calendar.get(2) == n2 - 1);
    }
    
    public static boolean isSameMonth(final Calendar calendar, final Calendar calendar2) {
        return calendar2 != null && isSameMonth(calendar, calendar2.get(1), calendar2.get(2) + 1);
    }
    
    public static boolean isToday(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s) && s.length() >= 8) {
            final Calendar yyyyMMddToCalendar = yyyyMMddToCalendar(s);
            if (yyyyMMddToCalendar != null) {
                return s.substring(0, 8).equals(new SimpleDateFormat("yyyyMMddHHmmssZ").format(Calendar.getInstance(yyyyMMddToCalendar.getTimeZone()).getTime()).substring(0, 8));
            }
        }
        return false;
    }
    
    public static boolean isToday(final Calendar calendar) {
        return calendar != null && isToday(new SimpleDateFormat("yyyyMMddHHmmssZ").format(calendar.getTime()));
    }
    
    public static Calendar setMaxTimeInDate(final Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar;
    }
    
    public static Calendar setMinTimeInDate(final Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }
    
    public static String toDateString(final Calendar calendar, final String pattern) {
        if (calendar == null) {
            return null;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        return simpleDateFormat.format(calendar.getTime());
    }
    
    public static String toEventDateString(final Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5H\u6642");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        return simpleDateFormat.format(calendar.getTime());
    }
    
    public static String toHHmmssString(final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        return simpleDateFormat.format(date);
    }
    
    public static String toMdHHmmString(final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M\u6708d\u65e5 HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        return simpleDateFormat.format(date);
    }
    
    public static String toSendDateString(final Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5 H:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        return simpleDateFormat.format(calendar.getTime());
    }
    
    public static String todEString(final Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return String.format("%d(%s)", calendar.get(5), getWeekName(calendar));
    }
    
    public static Date today() {
        final Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }
    
    public static String toyyyyMMddHHmmssZZZString(final String source) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssZZZ");
        final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("M\u6708d\u65e5H\u6642");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        final Date date = null;
        try {
            final Date parse = simpleDateFormat.parse(source);
            return simpleDateFormat2.format(parse);
        }
        catch (ParseException ex) {
            ex.printStackTrace();
            final Date parse = date;
            return simpleDateFormat2.format(parse);
        }
    }
    
    public static String toyyyyMMddString(final Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssZ");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
        return simpleDateFormat.format(calendar.getTime());
    }
    
    public static Calendar yyyyMMddFullTimeToCalendar(final String source) {
        if (TextUtils.isEmpty((CharSequence)source)) {
            return null;
        }
        try {
            final Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
            instance.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(source));
            return instance;
        }
        catch (ParseException ex) {
            LogUtils.outputLog(6, "parse targetDate failed.", ex);
            return null;
        }
    }
    
    public static Calendar yyyyMMddToCalendar(final String source) {
        if (TextUtils.isEmpty((CharSequence)source)) {
            return null;
        }
        try {
            final Calendar instance = Calendar.getInstance(TimeZone.getTimeZone(CalendarUtils.TIMEZONE));
            instance.setTime(new SimpleDateFormat("yyyyMMddHHmmssZ").parse(source));
            return instance;
        }
        catch (ParseException ex) {
            LogUtils.outputLog(6, "parse targetDate failed.", ex);
            return null;
        }
    }
}
