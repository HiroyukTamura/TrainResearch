// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzbdg implements Runnable
{
    private /* synthetic */ zzbdd zzaEv;
    private /* synthetic */ ConnectionResult zzaEw;
    
    zzbdg(final zzbdd zzaEv, final ConnectionResult zzaEw) {
        this.zzaEv = zzaEv;
        this.zzaEw = zzaEw;
    }
    
    @Override
    public final void run() {
        this.zzaEv.onConnectionFailed(this.zzaEw);
    }
}
