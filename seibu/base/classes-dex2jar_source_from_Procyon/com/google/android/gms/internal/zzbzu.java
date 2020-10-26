// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public abstract class zzbzu<T>
{
    private final int zzBM;
    private final String zzBN;
    private final T zzBO;
    
    private zzbzu(final int zzBM, final String zzBN, final T zzBO) {
        this.zzBM = zzBM;
        this.zzBN = zzBN;
        this.zzBO = zzBO;
        zzcaf.zzub().zza(this);
    }
    
    public static zzbzw zzb(final int n, final String s, final Boolean b) {
        return new zzbzw(0, s, b);
    }
    
    public static zzbzx zzb(final int n, final String s, final int i) {
        return new zzbzx(0, s, i);
    }
    
    public static zzbzy zzb(final int n, final String s, final long l) {
        return new zzbzy(0, s, l);
    }
    
    public final String getKey() {
        return this.zzBN;
    }
    
    public final int getSource() {
        return this.zzBM;
    }
    
    protected abstract T zza(final zzcac p0);
    
    public final T zzdI() {
        return this.zzBO;
    }
}
