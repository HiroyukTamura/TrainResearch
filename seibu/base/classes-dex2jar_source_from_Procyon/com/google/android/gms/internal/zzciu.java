// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.ComponentName;

final class zzciu implements Runnable
{
    private /* synthetic */ zzciq zzbuk;
    
    zzciu(final zzciq zzbuk) {
        this.zzbuk = zzbuk;
    }
    
    @Override
    public final void run() {
        final zzcid zzbua = this.zzbuk.zzbua;
        final Context context = this.zzbuk.zzbua.getContext();
        zzcem.zzxE();
        zzbua.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
