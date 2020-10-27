package p043jp.reifrontier.gym.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002¨\u0006\u000b"}, mo21739d2 = {"compareTime", "", "Ljava/util/Calendar;", "target", "dayStart", "format", "", "isPassedMinute", "", "passedMinute", "unixTime", "app_productionRelease"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.CaledarExKt */
public final class CaledarExKt {
    public static final int compareTime(Calendar calendar, Calendar calendar2) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$compareTime");
        Intrinsics.checkParameterIsNotNull(calendar2, "target");
        Object clone = calendar.clone();
        if (clone != null) {
            Calendar calendar3 = (Calendar) clone;
            calendar3.set(1, calendar2.get(1));
            calendar3.set(2, calendar2.get(2));
            calendar3.set(5, calendar2.get(5));
            return calendar3.compareTo(calendar2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }

    public static final Calendar dayStart(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$dayStart");
        Object clone = calendar.clone();
        if (clone != null) {
            Calendar calendar2 = (Calendar) clone;
            calendar2.set(11, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            calendar2.set(14, 0);
            return calendar2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }

    public static final String format(Calendar calendar, String str) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$format");
        Intrinsics.checkParameterIsNotNull(str, "format");
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
        Intrinsics.checkExpressionValueIsNotNull(format, "simpleDateFormat.format(this.time)");
        return format;
    }

    public static final boolean isPassedMinute(Calendar calendar, int i) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$isPassedMinute");
        Calendar instance = Calendar.getInstance();
        Object clone = calendar.clone();
        if (clone != null) {
            Calendar calendar2 = (Calendar) clone;
            calendar2.set(12, calendar2.get(12) + i);
            return instance.compareTo(calendar2) >= 0;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
    }

    public static final int unixTime(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$unixTime");
        return (int) (calendar.getTimeInMillis() / 1000);
    }
}
