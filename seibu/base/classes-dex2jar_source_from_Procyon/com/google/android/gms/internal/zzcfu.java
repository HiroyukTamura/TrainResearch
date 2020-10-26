// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.IntentFilter;
import android.support.annotation.WorkerThread;
import android.support.annotation.MainThread;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.common.internal.zzbo;
import android.content.BroadcastReceiver;

class zzcfu extends BroadcastReceiver
{
    private static String zzaiq;
    private boolean mRegistered;
    private boolean zzair;
    private final zzcgl zzboe;
    
    static {
        zzcfu.zzaiq = zzcfu.class.getName();
    }
    
    zzcfu(final zzcgl zzboe) {
        zzbo.zzu(zzboe);
        this.zzboe = zzboe;
    }
    
    @MainThread
    public void onReceive(final Context context, final Intent intent) {
        this.zzboe.zzkD();
        final String action = intent.getAction();
        this.zzboe.zzwF().zzyD().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean zzlQ = this.zzboe.zzyU().zzlQ();
            if (this.zzair != zzlQ) {
                this.zzair = zzlQ;
                this.zzboe.zzwE().zzj(new zzcfv(this, zzlQ));
            }
            return;
        }
        this.zzboe.zzwF().zzyz().zzj("NetworkBroadcastReceiver received unknown action", action);
    }
    
    @WorkerThread
    public final void unregister() {
        this.zzboe.zzkD();
        this.zzboe.zzwE().zzjC();
        this.zzboe.zzwE().zzjC();
        if (!this.mRegistered) {
            return;
        }
        this.zzboe.zzwF().zzyD().log("Unregistering connectivity change receiver");
        this.mRegistered = false;
        this.zzair = false;
        final Context context = this.zzboe.getContext();
        try {
            context.unregisterReceiver((BroadcastReceiver)this);
        }
        catch (IllegalArgumentException ex) {
            this.zzboe.zzwF().zzyx().zzj("Failed to unregister the network broadcast receiver", ex);
        }
    }
    
    @WorkerThread
    public final void zzlN() {
        this.zzboe.zzkD();
        this.zzboe.zzwE().zzjC();
        if (this.mRegistered) {
            return;
        }
        this.zzboe.getContext().registerReceiver((BroadcastReceiver)this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzair = this.zzboe.zzyU().zzlQ();
        this.zzboe.zzwF().zzyD().zzj("Registering connectivity change receiver. Network connected", this.zzair);
        this.mRegistered = true;
    }
}
