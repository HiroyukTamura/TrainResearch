// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import android.support.annotation.RequiresPermission;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.internal.zzaoj;
import android.content.BroadcastReceiver;

public final class AnalyticsReceiver extends BroadcastReceiver
{
    private zzaoj zzadl;
    
    @RequiresPermission(allOf = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" })
    public final void onReceive(final Context context, final Intent intent) {
        if (this.zzadl == null) {
            this.zzadl = new zzaoj();
        }
        zzaoj.onReceive(context, intent);
    }
}
