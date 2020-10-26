// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzchx implements Runnable
{
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ AtomicReference zzbtv;
    
    zzchx(final zzchl zzbtt, final AtomicReference zzbtv) {
        this.zzbtt = zzbtt;
        this.zzbtv = zzbtv;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzww().zza(this.zzbtv);
    }
}
