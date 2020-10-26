/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.d;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import jp.co.jreast.jreastapp.commuter.model.BoardingDate;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u00a8\u0006\u0013"}, d2={"Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "", "()V", "boardingToDate", "Ljava/util/Date;", "boardingDate", "Ljp/co/jreast/jreastapp/commuter/model/BoardingDate;", "calendarFromString", "Ljava/util/Calendar;", "ymd", "", "hhmm", "currentCalendar", "currentDateTime", "dateFromString", "diffMinute", "", "dateTime", "baseDateTime", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    public final float a(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return (calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / (long)60000;
        }
        return 0.0f;
    }

    public final Date a() {
        return new Date();
    }

    public final Date a(BoardingDate serializable) {
        j.b(serializable, "boardingDate");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(serializable.getYear()), Integer.parseInt(serializable.getMonth()) - 1, Integer.parseInt(serializable.getDay()));
        j.a((Object)calendar, "cal");
        serializable = calendar.getTime();
        j.a((Object)serializable, "cal.time");
        return serializable;
    }

    public final Calendar b() {
        Calendar calendar = Calendar.getInstance();
        j.a((Object)calendar, "Calendar.getInstance()");
        return calendar;
    }
}

