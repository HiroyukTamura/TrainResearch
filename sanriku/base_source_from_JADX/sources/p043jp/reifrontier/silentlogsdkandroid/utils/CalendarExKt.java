package p043jp.reifrontier.silentlogsdkandroid.utils;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002¨\u0006\b"}, mo21739d2 = {"diffSeconds", "", "Ljava/util/Calendar;", "targetTime", "isSameDay", "", "targetDay", "unixTimeSeconds", "silentlogsdkandroid_release"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.CalendarExKt */
public final class CalendarExKt {
    public static final int diffSeconds(Calendar calendar, Calendar calendar2) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$diffSeconds");
        Intrinsics.checkParameterIsNotNull(calendar2, "targetTime");
        return Math.abs(unixTimeSeconds(calendar) - unixTimeSeconds(calendar2));
    }

    public static final boolean isSameDay(Calendar calendar, Calendar calendar2) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$isSameDay");
        Intrinsics.checkParameterIsNotNull(calendar2, "targetDay");
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static final int unixTimeSeconds(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "$this$unixTimeSeconds");
        calendar.set(14, 0);
        return (int) (calendar.getTimeInMillis() / ((long) 1000));
    }
}
