// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.measurement;

import android.support.annotation.MainThread;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.internal.zzcgc;
import com.google.android.gms.internal.zzcge;
import android.content.BroadcastReceiver;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzcge
{
    private zzcgc zzboo;
    
    public final void doStartService(final Context context, final Intent intent) {
    }
    
    @MainThread
    public final void onReceive(final Context context, final Intent intent) {
        if (this.zzboo == null) {
            this.zzboo = new zzcgc(this);
        }
        this.zzboo.onReceive(context, intent);
    }
}
