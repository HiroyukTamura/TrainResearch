// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzchu implements Runnable
{
    private /* synthetic */ String val$name;
    private /* synthetic */ Object zzbtD;
    private /* synthetic */ String zzbth;
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ long zzbty;
    
    zzchu(final zzchl zzbtt, final String zzbth, final String val$name, final Object zzbtD, final long zzbty) {
        this.zzbtt = zzbtt;
        this.zzbth = zzbth;
        this.val$name = val$name;
        this.zzbtD = zzbtD;
        this.zzbty = zzbty;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zza(this.zzbth, this.val$name, this.zzbtD, this.zzbty);
    }
}
