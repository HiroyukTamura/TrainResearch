// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcfv implements Runnable
{
    private /* synthetic */ boolean zzbrg;
    private /* synthetic */ zzcfu zzbrh;
    
    zzcfv(final zzcfu zzbrh, final boolean zzbrg) {
        this.zzbrh = zzbrh;
        this.zzbrg = zzbrg;
    }
    
    @Override
    public final void run() {
        this.zzbrh.zzboe.zzam(this.zzbrg);
    }
}
