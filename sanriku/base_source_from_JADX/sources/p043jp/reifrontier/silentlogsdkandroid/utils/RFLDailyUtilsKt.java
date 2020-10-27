package p043jp.reifrontier.silentlogsdkandroid.utils;

import android.location.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResult;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u001a\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0010\u0010\u000e\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u0005*\u00020\u0005\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0002\u001a\f\u0010\u0015\u001a\u00020\u0002*\u00020\u0001H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0000\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\u001a\u001a\u00020\u0005*\u00020\u0018H\u0000\u001a\f\u0010\u001a\u001a\u00020\u0005*\u00020\u0017H\u0000\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0001¨\u0006\u001e"}, mo21739d2 = {"date", "Ljava/util/Date;", "", "end", "format", "", "timezone", "inside", "", "Landroid/location/Location;", "location", "radius", "", "isSameDay", "max", "", "md5", "millisecond", "", "minus", "year", "second", "segment", "Ljp/reifrontier/silentlogsdkandroid/utils/RFL_SEGMENT_TYPE;", "Ljp/reifrontier/silentlogsdkandroid/utils/RFL_ACTIVITY_TYPE;", "start", "string", "tomorrow", "weekDay", "yesterday", "silentlogsdkandroid_release"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt */
public final class RFLDailyUtilsKt {

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[RFL_ACTIVITY_TYPE.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFL_ACTIVITY_TYPE rfl_activity_type = RFL_ACTIVITY_TYPE.STAY;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFL_ACTIVITY_TYPE rfl_activity_type2 = RFL_ACTIVITY_TYPE.TRANSPORT;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFL_ACTIVITY_TYPE rfl_activity_type3 = RFL_ACTIVITY_TYPE.WALK;
            iArr3[2] = 3;
            int[] iArr4 = $EnumSwitchMapping$0;
            RFL_ACTIVITY_TYPE rfl_activity_type4 = RFL_ACTIVITY_TYPE.CHANGE;
            iArr4[3] = 4;
            int[] iArr5 = new int[RFL_ACTIVITY_TYPE.values().length];
            $EnumSwitchMapping$1 = iArr5;
            RFL_ACTIVITY_TYPE rfl_activity_type5 = RFL_ACTIVITY_TYPE.STAY;
            iArr5[0] = 1;
            int[] iArr6 = $EnumSwitchMapping$1;
            RFL_ACTIVITY_TYPE rfl_activity_type6 = RFL_ACTIVITY_TYPE.TRANSPORT;
            iArr6[1] = 2;
            int[] iArr7 = $EnumSwitchMapping$1;
            RFL_ACTIVITY_TYPE rfl_activity_type7 = RFL_ACTIVITY_TYPE.WALK;
            iArr7[2] = 3;
            int[] iArr8 = $EnumSwitchMapping$1;
            RFL_ACTIVITY_TYPE rfl_activity_type8 = RFL_ACTIVITY_TYPE.CHANGE;
            iArr8[3] = 4;
            int[] iArr9 = new int[RFL_SEGMENT_TYPE.values().length];
            $EnumSwitchMapping$2 = iArr9;
            RFL_SEGMENT_TYPE rfl_segment_type = RFL_SEGMENT_TYPE.MOVE;
            iArr9[1] = 1;
            int[] iArr10 = $EnumSwitchMapping$2;
            RFL_SEGMENT_TYPE rfl_segment_type2 = RFL_SEGMENT_TYPE.PLACE;
            iArr10[0] = 2;
        }
    }

    public static final Date date(int i) {
        return new Date(((long) i) * 1000);
    }

    public static final Date end(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$end");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, RFLAdResult.ERROR_FAILED);
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }

    public static final String format(Date date, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(date, "$this$format");
        Intrinsics.checkParameterIsNotNull(str, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        if (str2 != null) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
        }
        String format = simpleDateFormat.format(date);
        if (format != null) {
            return format;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    public static /* synthetic */ String format$default(Date date, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return format(date, str, str2);
    }

    public static final boolean inside(Location location, Location location2, float f) {
        Intrinsics.checkParameterIsNotNull(location, "$this$inside");
        Intrinsics.checkParameterIsNotNull(location2, FirebaseAnalytics.Param.LOCATION);
        return location.distanceTo(location2) < f;
    }

    public static final boolean isSameDay(Date date, Date date2) {
        Intrinsics.checkParameterIsNotNull(date, "$this$isSameDay");
        Intrinsics.checkParameterIsNotNull(date2, "date");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "calendar2");
        instance2.setTime(date2);
        return instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5);
    }

    public static final int max(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$max");
        int i = 0;
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (i < intValue2) {
                i = intValue2;
            }
        }
        return i;
    }

    public static final String md5(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$md5");
        MessageDigest instance = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = digest.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(digest[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[digest[i2] & 15];
        }
        return new String(cArr2);
    }

    public static final long millisecond(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$millisecond");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        return instance.getTimeInMillis();
    }

    public static final Date minus(Date date, int i) {
        Intrinsics.checkParameterIsNotNull(date, "$this$minus");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        instance.set(1, instance.get(1) - i);
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }

    public static final int second(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$second");
        return (int) (millisecond(date) / ((long) 1000));
    }

    public static final RFL_SEGMENT_TYPE segment(RFL_ACTIVITY_TYPE rfl_activity_type) {
        Intrinsics.checkParameterIsNotNull(rfl_activity_type, "$this$segment");
        int i = WhenMappings.$EnumSwitchMapping$1[rfl_activity_type.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return RFL_SEGMENT_TYPE.MOVE;
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return RFL_SEGMENT_TYPE.PLACE;
    }

    public static final Date start(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$start");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }

    public static final String string(RFL_ACTIVITY_TYPE rfl_activity_type) {
        Intrinsics.checkParameterIsNotNull(rfl_activity_type, "$this$string");
        int i = WhenMappings.$EnumSwitchMapping$0[rfl_activity_type.ordinal()];
        if (i == 1) {
            return "sty";
        }
        if (i == 2) {
            return "trp";
        }
        if (i == 3) {
            return "wlk";
        }
        if (i == 4) {
            return "chg";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String string(RFL_SEGMENT_TYPE rfl_segment_type) {
        Intrinsics.checkParameterIsNotNull(rfl_segment_type, "$this$string");
        int i = WhenMappings.$EnumSwitchMapping$2[rfl_segment_type.ordinal()];
        if (i == 1) {
            return "move";
        }
        if (i == 2) {
            return "place";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Date tomorrow(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$tomorrow");
        return new Date(date.getTime() + 86400000);
    }

    public static final int weekDay(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$weekDay");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        return instance.get(7);
    }

    public static final Date yesterday(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$yesterday");
        return new Date(date.getTime() - 86400000);
    }
}
