// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzchv implements Runnable
{
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ AtomicReference zzbtv;
    private /* synthetic */ boolean zzbtw;
    
    zzchv(final zzchl zzbtt, final AtomicReference zzbtv, final boolean zzbtw) {
        this.zzbtt = zzbtt;
        this.zzbtv = zzbtv;
        this.zzbtw = zzbtw;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzww().zza(this.zzbtv, this.zzbtw);
    }
}
