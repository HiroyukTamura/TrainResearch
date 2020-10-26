// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzcfm implements Runnable
{
    private /* synthetic */ String zzbqV;
    private /* synthetic */ zzcfl zzbqW;
    
    zzcfm(final zzcfl zzbqW, final String zzbqV) {
        this.zzbqW = zzbqW;
        this.zzbqV = zzbqV;
    }
    
    @Override
    public final void run() {
        final zzcfw zzwG = this.zzbqW.zzboe.zzwG();
        if (!zzwG.isInitialized()) {
            this.zzbqW.zzk(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        zzwG.zzbrj.zzf(this.zzbqV, 1L);
    }
}
