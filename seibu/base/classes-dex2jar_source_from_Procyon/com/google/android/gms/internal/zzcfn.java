// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzcfn
{
    private final int mPriority;
    private /* synthetic */ zzcfl zzbqW;
    private final boolean zzbqX;
    private final boolean zzbqY;
    
    zzcfn(final zzcfl zzbqW, final int mPriority, final boolean zzbqX, final boolean zzbqY) {
        this.zzbqW = zzbqW;
        this.mPriority = mPriority;
        this.zzbqX = zzbqX;
        this.zzbqY = zzbqY;
    }
    
    public final void log(final String s) {
        this.zzbqW.zza(this.mPriority, this.zzbqX, this.zzbqY, s, null, null, null);
    }
    
    public final void zzd(final String s, final Object o, final Object o2, final Object o3) {
        this.zzbqW.zza(this.mPriority, this.zzbqX, this.zzbqY, s, o, o2, o3);
    }
    
    public final void zze(final String s, final Object o, final Object o2) {
        this.zzbqW.zza(this.mPriority, this.zzbqX, this.zzbqY, s, o, o2, null);
    }
    
    public final void zzj(final String s, final Object o) {
        this.zzbqW.zza(this.mPriority, this.zzbqX, this.zzbqY, s, o, null, null);
    }
}
