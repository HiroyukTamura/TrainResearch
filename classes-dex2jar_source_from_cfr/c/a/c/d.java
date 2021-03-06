/*
 * Decompiled with CFR 0.139.
 */
package c.a.c;

import c.a.c;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class d {
    private static final ThreadLocal<DateFormat> a = new ThreadLocal<DateFormat>(){

        protected DateFormat a() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(c.g);
            return simpleDateFormat;
        }

        @Override
        protected /* synthetic */ Object initialValue() {
            return this.a();
        }
    };
    private static final String[] b = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    private static final DateFormat[] c = new DateFormat[b.length];

    public static String a(Date date) {
        return a.get().format(date);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Date a(String string2) {
        if (string2.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Cloneable cloneable = a.get().parse(string2, parsePosition);
        if (parsePosition.getIndex() == string2.length()) {
            return cloneable;
        }
        String[] arrstring = b;
        synchronized (arrstring) {
            int n2 = b.length;
            int n3 = 0;
            while (n3 < n2) {
                DateFormat dateFormat = c[n3];
                cloneable = dateFormat;
                if (dateFormat == null) {
                    cloneable = new SimpleDateFormat(b[n3], Locale.US);
                    ((DateFormat)cloneable).setTimeZone(c.g);
                    d.c[n3] = cloneable;
                }
                parsePosition.setIndex(0);
                cloneable = ((DateFormat)cloneable).parse(string2, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return cloneable;
                }
                ++n3;
            }
            return null;
        }
    }

}

