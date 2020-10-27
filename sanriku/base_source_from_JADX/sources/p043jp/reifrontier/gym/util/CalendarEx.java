package p043jp.reifrontier.gym.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0004¨\u0006\u0016"}, mo21739d2 = {"Ljp/reifrontier/gym/util/CalendarEx;", "", "()V", "getInstance", "Ljava/util/Calendar;", "year", "", "month", "dayOfMonth", "hourOfDay", "minute", "second", "milliseconds", "now", "parse", "unixTime", "", "parseTime", "time", "", "format", "today", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.CalendarEx */
public final class CalendarEx {
    public static final CalendarEx INSTANCE = new CalendarEx();

    private CalendarEx() {
    }

    public static /* synthetic */ Calendar getInstance$default(CalendarEx calendarEx, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        return calendarEx.getInstance(i, i2, i3, (i8 & 8) != 0 ? 0 : i4, (i8 & 16) != 0 ? 0 : i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    public final Calendar getInstance(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        instance.set(11, i4);
        instance.set(12, i5);
        instance.set(13, i6);
        instance.set(14, i7);
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance().a… = milliseconds\n        }");
        return instance;
    }

    public final Calendar now() {
        Calendar instance = Calendar.getInstance();
        instance.set(14, 0);
        Intrinsics.checkExpressionValueIsNotNull(instance, "value");
        return instance;
    }

    public final Calendar parse(int i) {
        return parse(((long) i) * 1000);
    }

    public final Calendar parse(long j) {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "value");
        instance.setTimeInMillis(j);
        return instance;
    }

    public final Calendar parseTime(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "time");
        Intrinsics.checkParameterIsNotNull(str2, "format");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
            Calendar instance = Calendar.getInstance();
            Date parse = simpleDateFormat.parse(str);
            if (parse == null) {
                return instance;
            }
            Intrinsics.checkExpressionValueIsNotNull(instance, "value");
            instance.setTime(parse);
            return instance;
        } catch (Exception e) {
            C1122a.m1596a("[Sanriku]::Error " + e, new Object[0]);
            return null;
        }
    }

    public final Calendar today() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
        return CaledarExKt.dayStart(instance);
    }
}
