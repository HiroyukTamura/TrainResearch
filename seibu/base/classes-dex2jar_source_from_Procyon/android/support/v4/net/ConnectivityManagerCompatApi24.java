// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.net;

import android.net.ConnectivityManager;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(24)
@RequiresApi(24)
class ConnectivityManagerCompatApi24
{
    public static int getRestrictBackgroundStatus(final ConnectivityManager connectivityManager) {
        return connectivityManager.getRestrictBackgroundStatus();
    }
}
