// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.measurement;

import android.support.annotation.MainThread;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.internal.zzcgc;
import com.google.android.gms.internal.zzcge;
import android.support.v4.content.WakefulBroadcastReceiver;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzcge
{
    private zzcgc zzboo;
    
    @MainThread
    @Override
    public final void doStartService(final Context context, final Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }
    
    @MainThread
    public final void onReceive(final Context context, final Intent intent) {
        if (this.zzboo == null) {
            this.zzboo = new zzcgc(this);
        }
        this.zzboo.onReceive(context, intent);
    }
}
