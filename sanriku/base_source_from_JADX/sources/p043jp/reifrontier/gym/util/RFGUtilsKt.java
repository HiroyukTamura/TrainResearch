package p043jp.reifrontier.gym.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.format.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\u001e\u0010\u000b\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a\n\u0010\u0013\u001a\u00020\u000f*\u00020\u0001\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0016"}, mo21739d2 = {"ago", "Ljava/util/Date;", "with", "", "fileAsString", "", "Landroid/content/res/AssetManager;", "subdirectory", "filename", "firstMonth", "firstOfYear", "formaaat11", "format", "timezone", "hasInstalledGoogleFit", "", "Landroid/content/Context;", "isSame", "date", "isToday", "later", "monthAgo", "app_productionRelease"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.util.RFGUtilsKt */
public final class RFGUtilsKt {
    public static final Date ago(Date date, int i) {
        Intrinsics.checkParameterIsNotNull(date, "$this$ago");
        return new Date(date.getTime() - (((long) i) * 86400000));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        kotlin.p045io.CloseableKt.closeFinally(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String fileAsString(android.content.res.AssetManager r1, java.lang.String r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "$this$fileAsString"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "subdirectory"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "filename"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r2 = 47
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = r0.toString()
            java.io.InputStream r1 = r1.open(r2)
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)     // Catch:{ all -> 0x0043 }
            byte[] r2 = kotlin.p045io.ByteStreamsKt.readBytes(r1)     // Catch:{ all -> 0x0043 }
            java.nio.charset.Charset r3 = java.nio.charset.Charset.defaultCharset()     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = "Charset.defaultCharset()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0043 }
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0043 }
            r2 = 0
            kotlin.p045io.CloseableKt.closeFinally(r1, r2)
            return r0
        L_0x0043:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r3 = move-exception
            kotlin.p045io.CloseableKt.closeFinally(r1, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.util.RFGUtilsKt.fileAsString(android.content.res.AssetManager, java.lang.String, java.lang.String):java.lang.String");
    }

    public static final Date firstMonth(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$firstMonth");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        instance.set(5, 1);
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }

    public static final Date firstOfYear(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$firstOfYear");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        instance.set(2, 0);
        instance.set(5, 1);
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }

    public static final String formaaat11(Date date, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(date, "$this$formaaat11");
        Intrinsics.checkParameterIsNotNull(str, "format");
        Calendar instance = Calendar.getInstance();
        if (str2 != null) {
            TimeZone timeZone = TimeZone.getTimeZone(str2);
            Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
            instance.setTimeZone(timeZone);
        }
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        CharSequence format = DateFormat.format(str, instance);
        if (format != null) {
            return (String) format;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    public static /* synthetic */ String formaaat11$default(Date date, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return formaaat11(date, str, str2);
    }

    public static final boolean hasInstalledGoogleFit(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$hasInstalledGoogleFit");
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(128).iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                return false;
            }
            PackageInfo next = it.next();
            String str = next.packageName;
            if (str != null) {
                Intrinsics.checkExpressionValueIsNotNull(str, "info.packageName");
                if (str.length() > 0) {
                    z = true;
                }
                if (z && Intrinsics.areEqual((Object) next.packageName, (Object) GymUtils.GOOGLE_FIT_PACKAGE_NAME)) {
                    return true;
                }
            }
        }
    }

    public static final boolean isSame(Date date, Date date2) {
        Intrinsics.checkParameterIsNotNull(date, "$this$isSame");
        Intrinsics.checkParameterIsNotNull(date2, "date");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "calendar2");
        instance2.setTime(date2);
        return instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5);
    }

    public static final boolean isToday(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$isToday");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "calendar2");
        instance2.setTime(new Date());
        return instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5);
    }

    public static final Date later(Date date, int i) {
        Intrinsics.checkParameterIsNotNull(date, "$this$later");
        return new Date(date.getTime() + (((long) i) * 86400000));
    }

    public static final Date monthAgo(Date date, int i) {
        Intrinsics.checkParameterIsNotNull(date, "$this$monthAgo");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        instance.setTime(date);
        instance.add(2, -i);
        Date time = instance.getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "calendar.time");
        return time;
    }
}
