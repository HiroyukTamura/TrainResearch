// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

public final class zzcfc<V>
{
    private final String zzBN;
    private final V zzahV;
    private final zzbez<V> zzahW;
    
    private zzcfc(final String zzBN, final zzbez<V> zzahW, final V zzahV) {
        zzbo.zzu(zzahW);
        this.zzahW = zzahW;
        this.zzahV = zzahV;
        this.zzBN = zzBN;
    }
    
    static zzcfc<Long> zzb(final String s, final long l, final long i) {
        return new zzcfc<Long>(s, zzbez.zza(s, i), l);
    }
    
    static zzcfc<Boolean> zzb(final String s, final boolean b, final boolean b2) {
        return new zzcfc<Boolean>(s, zzbez.zzg(s, b2), b);
    }
    
    static zzcfc<String> zzj(final String s, final String s2, final String s3) {
        return new zzcfc<String>(s, zzbez.zzv(s, s3), s2);
    }
    
    static zzcfc<Integer> zzm(final String s, final int i, final int j) {
        return new zzcfc<Integer>(s, zzbez.zza(s, j), i);
    }
    
    public final V get() {
        return this.zzahV;
    }
    
    public final V get(final V v) {
        if (v != null) {
            return v;
        }
        return this.zzahV;
    }
    
    public final String getKey() {
        return this.zzBN;
    }
}
