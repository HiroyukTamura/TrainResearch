package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

public final class zzl {
    private static volatile boolean zzjs = (!zzan());
    @GuardedBy("DirectBootUtils.class")
    private static boolean zzjt = false;

    @RequiresApi(24)
    @TargetApi(24)
    public static Context getDeviceProtectedStorageContext(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }

    public static boolean zzan() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
