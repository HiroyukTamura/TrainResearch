// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.app;

import android.app.ActivityManager;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class ActivityManagerCompatKitKat
{
    public static boolean isLowRamDevice(final ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
