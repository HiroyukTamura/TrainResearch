// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzchp implements Runnable
{
    private /* synthetic */ String zzbjh;
    private /* synthetic */ String zzbth;
    private /* synthetic */ String zzbti;
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ AtomicReference zzbtv;
    
    zzchp(final zzchl zzbtt, final AtomicReference zzbtv, final String zzbjh, final String zzbth, final String zzbti) {
        this.zzbtt = zzbtt;
        this.zzbtv = zzbtv;
        this.zzbjh = zzbjh;
        this.zzbth = zzbth;
        this.zzbti = zzbti;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzboe.zzww().zza(this.zzbtv, this.zzbjh, this.zzbth, this.zzbti);
    }
}
