package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
public class Wrappers {
    private static Wrappers zziq = new Wrappers();
    private PackageManagerWrapper zzip = null;

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        return zziq.zzj(context);
    }

    @VisibleForTesting
    private final synchronized PackageManagerWrapper zzj(Context context) {
        if (this.zzip == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzip = new PackageManagerWrapper(context);
        }
        return this.zzip;
    }
}
