// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.IntentFilter;
import android.content.Intent;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.google.android.gms.common.internal.zzbo;
import android.content.BroadcastReceiver;

class zzaod extends BroadcastReceiver
{
    private static String zzaiq;
    private boolean mRegistered;
    private final zzamj zzafJ;
    private boolean zzair;
    
    static {
        zzaod.zzaiq = zzaod.class.getName();
    }
    
    zzaod(final zzamj zzafJ) {
        zzbo.zzu(zzafJ);
        this.zzafJ = zzafJ;
    }
    
    private final void zzlO() {
        this.zzafJ.zzkr();
        this.zzafJ.zzkv();
    }
    
    private final boolean zzlQ() {
        final ConnectivityManager connectivityManager = (ConnectivityManager)this.zzafJ.getContext().getSystemService("connectivity");
        try {
            final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        catch (SecurityException ex) {
            return false;
        }
    }
    
    public final boolean isConnected() {
        if (!this.mRegistered) {
            this.zzafJ.zzkr().zzbr("Connectivity unknown. Receiver not registered");
        }
        return this.zzair;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        this.zzlO();
        final String action = intent.getAction();
        this.zzafJ.zzkr().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean zzlQ = this.zzlQ();
            if (this.zzair != zzlQ) {
                this.zzair = zzlQ;
                final zzaly zzkv = this.zzafJ.zzkv();
                zzkv.zza("Network connectivity status changed", zzlQ);
                zzkv.zzkt().zzf(new zzama(zzkv, zzlQ));
            }
        }
        else {
            if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
                this.zzafJ.zzkr().zzd("NetworkBroadcastReceiver received unknown action", action);
                return;
            }
            if (!intent.hasExtra(zzaod.zzaiq)) {
                final zzaly zzkv2 = this.zzafJ.zzkv();
                zzkv2.zzbo("Radio powered up");
                zzkv2.zzkl();
            }
        }
    }
    
    public final void unregister() {
        if (!this.mRegistered) {
            return;
        }
        this.zzafJ.zzkr().zzbo("Unregistering connectivity change receiver");
        this.mRegistered = false;
        this.zzair = false;
        final Context context = this.zzafJ.getContext();
        try {
            context.unregisterReceiver((BroadcastReceiver)this);
        }
        catch (IllegalArgumentException ex) {
            this.zzafJ.zzkr().zze("Failed to unregister the network broadcast receiver", ex);
        }
    }
    
    public final void zzlN() {
        this.zzlO();
        if (this.mRegistered) {
            return;
        }
        final Context context = this.zzafJ.getContext();
        context.registerReceiver((BroadcastReceiver)this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        final IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver((BroadcastReceiver)this, intentFilter);
        this.zzair = this.zzlQ();
        this.zzafJ.zzkr().zza("Registering connectivity change receiver. Network connected", this.zzair);
        this.mRegistered = true;
    }
    
    public final void zzlP() {
        final Context context = this.zzafJ.getContext();
        final Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzaod.zzaiq, true);
        context.sendOrderedBroadcast(intent, (String)null);
    }
}
