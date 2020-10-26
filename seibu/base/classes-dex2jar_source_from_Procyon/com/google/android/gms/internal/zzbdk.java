// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.net.Uri;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public final class zzbdk extends BroadcastReceiver
{
    private Context mContext;
    private final zzbdl zzaEA;
    
    public zzbdk(final zzbdl zzaEA) {
        this.zzaEA = zzaEA;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        final Uri data = intent.getData();
        Object schemeSpecificPart = null;
        if (data != null) {
            schemeSpecificPart = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(schemeSpecificPart)) {
            this.zzaEA.zzpA();
            this.unregister();
        }
    }
    
    public final void setContext(final Context mContext) {
        this.mContext = mContext;
    }
    
    public final void unregister() {
        synchronized (this) {
            if (this.mContext != null) {
                this.mContext.unregisterReceiver((BroadcastReceiver)this);
            }
            this.mContext = null;
        }
    }
}
