// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

import android.content.Context;

public class ConnectivityMonitorFactory
{
    public ConnectivityMonitor build(final Context context, final ConnectivityMonitor.ConnectivityListener connectivityListener) {
        int n;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
