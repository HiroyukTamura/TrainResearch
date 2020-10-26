// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

public final class zzl implements ServiceConnection
{
    private /* synthetic */ zzd zzaHe;
    private final int zzaHh;
    
    public zzl(final zzd zzaHe, final int zzaHh) {
        this.zzaHe = zzaHe;
        this.zzaHh = zzaHh;
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        if (binder == null) {
            zzd.zza(this.zzaHe, 16);
            return;
        }
        synchronized (this.zzaHe.zzaGO) {
            final zzd zzaHe = this.zzaHe;
            zzaw zzaw;
            if (binder == null) {
                zzaw = null;
            }
            else {
                final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface != null && queryLocalInterface instanceof zzaw) {
                    zzaw = (zzaw)queryLocalInterface;
                }
                else {
                    zzaw = new zzax(binder);
                }
            }
            zzaHe.zzaGP = zzaw;
            // monitorexit(zzd.zza((zzd<IInterface>)this.zzaHe))
            this.zzaHe.zza(0, null, this.zzaHh);
        }
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        synchronized (this.zzaHe.zzaGO) {
            this.zzaHe.zzaGP = null;
            // monitorexit(zzd.zza((zzd<IInterface>)this.zzaHe))
            this.zzaHe.mHandler.sendMessage(this.zzaHe.mHandler.obtainMessage(6, this.zzaHh, 1));
        }
    }
}
