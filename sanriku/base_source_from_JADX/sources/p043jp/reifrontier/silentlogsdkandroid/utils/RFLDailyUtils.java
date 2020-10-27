package p043jp.reifrontier.silentlogsdkandroid.utils;

import android.location.Location;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0017R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006%"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "", "()V", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "getDataLogger", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "setDataLogger", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "dateWith", "Ljava/util/Date;", "year", "", "month", "day", "distanceBetween", "", "src", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "dst", "durationBetween", "getDistanceBetweenAAndB", "lastLocation", "Landroid/location/Location;", "currentLocation", "isTimeBetweenBandC", "A", "T", "B", "location", "latitude", "", "longitude", "speedBetween", "validBetween", "validBetweenLocations", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils */
public final class RFLDailyUtils {
    public RFLDataLogger dataLogger;

    public RFLDailyUtils() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    public final Date dateWith(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2);
        instance.set(5, i3);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }

    public final float distanceBetween(RFLTrackPoint rFLTrackPoint, RFLTrackPoint rFLTrackPoint2) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "src");
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint2, "dst");
        return location(rFLTrackPoint.getLatitude(), rFLTrackPoint.getLongitude()).distanceTo(location(rFLTrackPoint2.getLatitude(), rFLTrackPoint2.getLongitude()));
    }

    public final float durationBetween(RFLTrackPoint rFLTrackPoint, RFLTrackPoint rFLTrackPoint2) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "src");
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint2, "dst");
        return (float) (rFLTrackPoint2.getTimestamp() - rFLTrackPoint.getTimestamp());
    }

    public final RFLDataLogger getDataLogger() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        return rFLDataLogger;
    }

    public final int getDistanceBetweenAAndB(Location location, Location location2) {
        if (location == null || location2 == null) {
            return 0;
        }
        double distanceTo = (double) (location.distanceTo(location2) / ((float) ((location.getTime() - location2.getTime()) / ((long) 1000))));
        if (distanceTo > 1.8d) {
            return 2;
        }
        return distanceTo > 0.6d ? 1 : 0;
    }

    public final int isTimeBetweenBandC(int i, int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i2 >= i ? 0 : -1;
    }

    public final Location location(double d, double d2) {
        Location location = new Location("silentLog_android");
        location.setLatitude(d);
        location.setLongitude(d2);
        return location;
    }

    public final void setDataLogger(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "<set-?>");
        this.dataLogger = rFLDataLogger;
    }

    public final float speedBetween(RFLTrackPoint rFLTrackPoint, RFLTrackPoint rFLTrackPoint2) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "src");
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint2, "dst");
        float durationBetween = durationBetween(rFLTrackPoint, rFLTrackPoint2);
        if (durationBetween <= 0.0f) {
            return 0.0f;
        }
        float distanceBetween = distanceBetween(rFLTrackPoint, rFLTrackPoint2);
        if (distanceBetween == 0.0f) {
            return 0.0f;
        }
        return distanceBetween / durationBetween;
    }

    public final int validBetween(RFLTrackPoint rFLTrackPoint, RFLTrackPoint rFLTrackPoint2) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint, "src");
        Intrinsics.checkParameterIsNotNull(rFLTrackPoint2, "dst");
        float speedBetween = speedBetween(rFLTrackPoint, rFLTrackPoint2);
        return (speedBetween <= 0.0f || speedBetween > 240.0f) ? 0 : 1;
    }

    public final boolean validBetweenLocations(Location location, Location location2) {
        Intrinsics.checkParameterIsNotNull(location, "src");
        Intrinsics.checkParameterIsNotNull(location2, "dst");
        return location.distanceTo(location2) / ((float) (location2.getTime() - location.getTime())) <= ((float) 240);
    }
}
