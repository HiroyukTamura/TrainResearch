// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzchq implements Runnable
{
    private /* synthetic */ String zzbjh;
    private /* synthetic */ String zzbth;
    private /* synthetic */ String zzbti;
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ AtomicReference zzbtv;
    private /* synthetic */ boolean zzbtw;
    
    zzchq(final zzchl zzbtt, final AtomicReference zzbtv, final String zzbjh, final String zzbth, final String zzbti, final boolean zzbtw) {
        this.zzbtt = zzbtt;
        this.zzbtv = zzbtv;
        this.zzbjh = zzbjh;
        this.zzbth = zzbth;
        this.zzbti = zzbti;
        this.zzbtw = zzbtw;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzboe.zzww().zza(this.zzbtv, this.zzbjh, this.zzbth, this.zzbti, this.zzbtw);
    }
}
