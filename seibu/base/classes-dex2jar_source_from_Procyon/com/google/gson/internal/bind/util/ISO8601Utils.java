// 
// Decompiled by Procyon v0.5.36
// 

package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Date;
import java.util.TimeZone;

public class ISO8601Utils
{
    private static final TimeZone TIMEZONE_UTC;
    private static final String UTC_ID = "UTC";
    
    static {
        TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    }
    
    private static boolean checkOffset(final String s, final int index, final char c) {
        return index < s.length() && s.charAt(index) == c;
    }
    
    public static String format(final Date date) {
        return format(date, false, ISO8601Utils.TIMEZONE_UTC);
    }
    
    public static String format(final Date date, final boolean b) {
        return format(date, b, ISO8601Utils.TIMEZONE_UTC);
    }
    
    public static String format(final Date time, final boolean b, final TimeZone zone) {
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(zone, Locale.US);
        gregorianCalendar.setTime(time);
        final int length = "yyyy-MM-ddThh:mm:ss".length();
        int length2;
        if (b) {
            length2 = ".sss".length();
        }
        else {
            length2 = 0;
        }
        int n;
        if (zone.getRawOffset() == 0) {
            n = "Z".length();
        }
        else {
            n = "+hh:mm".length();
        }
        final StringBuilder sb = new StringBuilder(length + length2 + n);
        padInt(sb, gregorianCalendar.get(1), "yyyy".length());
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, "MM".length());
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), "dd".length());
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), "hh".length());
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), "mm".length());
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), "ss".length());
        if (b) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), "sss".length());
        }
        final int offset = zone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            final int abs = Math.abs(offset / 60000 / 60);
            final int abs2 = Math.abs(offset / 60000 % 60);
            char c;
            if (offset < 0) {
                c = '-';
            }
            else {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, "hh".length());
            sb.append(':');
            padInt(sb, abs2, "mm".length());
        }
        else {
            sb.append('Z');
        }
        return sb.toString();
    }
    
    private static int indexOfNonDigit(final String s, int i) {
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 < '0' || char1 > '9') {
                return i;
            }
            ++i;
        }
        return s.length();
    }
    
    private static void padInt(final StringBuilder sb, int i, final int n) {
        final String string = Integer.toString(i);
        for (i = n - string.length(); i > 0; --i) {
            sb.append('0');
        }
        sb.append(string);
    }
    
    public static Date parse(final String s, final ParsePosition parsePosition) throws ParseException {
        try {
            final int index = parsePosition.getIndex();
            final int n = index + 4;
            final int int1 = parseInt(s, index, n);
            int n2 = n;
            if (checkOffset(s, n, '-')) {
                n2 = n + 1;
            }
            final int n3 = n2 + 2;
            final int int2 = parseInt(s, n2, n3);
            if (!checkOffset(s, n3, '-')) {
                goto Label_0945;
            }
            final int n4 = n3 + 1;
            final int index2 = n4 + 2;
            final int int3 = parseInt(s, n4, index2);
            final boolean checkOffset = checkOffset(s, index2, 'T');
            if (!checkOffset && s.length() <= index2) {
                final GregorianCalendar gregorianCalendar = new GregorianCalendar(int1, int2 - 1, int3);
                parsePosition.setIndex(index2);
                return gregorianCalendar.getTime();
            }
            int index3 = index2;
            if (checkOffset) {
                final int n5 = index2 + 1;
                final int n6 = n5 + 2;
                parseInt(s, n5, n6);
                int n7 = n6;
                if (checkOffset(s, n6, ':')) {
                    n7 = n6 + 1;
                }
                final int n8 = n7 + 2;
                parseInt(s, n7, n8);
                if (!checkOffset(s, n8, ':')) {
                    goto Label_0939;
                }
                index3 = n8 + 1;
                if (s.length() <= index3) {
                    goto Label_0920;
                }
                final char char1 = s.charAt(index3);
                if (char1 == 'Z' || char1 == '+' || char1 == '-') {
                    goto Label_0920;
                }
                final int n9 = index3 + 2;
                int int4;
                final int n10 = int4 = parseInt(s, index3, n9);
                if (n10 > 59 && (int4 = n10) < 63) {}
                index3 = n9;
                if (checkOffset(s, n9, '.')) {
                    final int n11 = n9 + 1;
                    final int min = Math.min(indexOfNonDigit(s, n11 + 1), n11 + 3);
                    parseInt(s, n11, min);
                    switch (min - n11) {
                        case 2: {
                            goto Label_0529;
                            goto Label_0529;
                        }
                        case 1: {
                            goto Label_0537;
                            goto Label_0537;
                        }
                        default: {
                            goto Label_0951;
                        }
                    }
                }
            }
            if (s.length() <= index3) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            goto Label_0545;
        }
        catch (IndexOutOfBoundsException ex) {}
        catch (IllegalArgumentException gregorianCalendar) {
            goto Label_0416;
        }
        catch (NumberFormatException gregorianCalendar) {
            goto Label_0416;
        }
    }
    
    private static int parseInt(final String s, final int beginIndex, final int n) throws NumberFormatException {
        if (beginIndex < 0 || n > s.length() || beginIndex > n) {
            throw new NumberFormatException(s);
        }
        int n2 = 0;
        int i;
        if (beginIndex < n) {
            i = beginIndex + 1;
            final int digit = Character.digit(s.charAt(beginIndex), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + s.substring(beginIndex, n));
            }
            n2 = -digit;
        }
        else {
            i = beginIndex;
        }
        while (i < n) {
            final int digit2 = Character.digit(s.charAt(i), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + s.substring(beginIndex, n));
            }
            n2 = n2 * 10 - digit2;
            ++i;
        }
        return -n2;
    }
}
