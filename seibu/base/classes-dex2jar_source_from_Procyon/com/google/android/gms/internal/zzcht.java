// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Bundle;

final class zzcht implements Runnable
{
    private /* synthetic */ String val$name;
    private /* synthetic */ String zzbjh;
    private /* synthetic */ boolean zzbtA;
    private /* synthetic */ boolean zzbtB;
    private /* synthetic */ boolean zzbtC;
    private /* synthetic */ String zzbth;
    private /* synthetic */ zzchl zzbtt;
    private /* synthetic */ long zzbty;
    private /* synthetic */ Bundle zzbtz;
    
    zzcht(final zzchl zzbtt, final String zzbth, final String val$name, final long zzbty, final Bundle zzbtz, final boolean zzbtA, final boolean zzbtB, final boolean zzbtC, final String zzbjh) {
        this.zzbtt = zzbtt;
        this.zzbth = zzbth;
        this.val$name = val$name;
        this.zzbty = zzbty;
        this.zzbtz = zzbtz;
        this.zzbtA = zzbtA;
        this.zzbtB = zzbtB;
        this.zzbtC = zzbtC;
        this.zzbjh = zzbjh;
    }
    
    @Override
    public final void run() {
        this.zzbtt.zzb(this.zzbth, this.val$name, this.zzbty, this.zzbtz, this.zzbtA, this.zzbtB, this.zzbtC, this.zzbjh);
    }
}
