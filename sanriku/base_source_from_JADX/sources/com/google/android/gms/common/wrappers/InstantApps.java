package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps {
    private static Context zzim;
    private static Boolean zzin;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        boolean z;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zzim == null || zzin == null || zzim != applicationContext) {
                zzin = null;
                if (PlatformVersion.isAtLeastO()) {
                    z = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzin = true;
                    } catch (ClassNotFoundException unused) {
                        z = false;
                    }
                    zzim = applicationContext;
                    boolean booleanValue = zzin.booleanValue();
                    return booleanValue;
                }
                zzin = z;
                zzim = applicationContext;
                boolean booleanValue2 = zzin.booleanValue();
                return booleanValue2;
            }
            boolean booleanValue3 = zzin.booleanValue();
            return booleanValue3;
        }
    }
}
