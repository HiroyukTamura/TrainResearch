// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

public final class zzant<V>
{
    private final V zzahV;
    private final zzbez<V> zzahW;
    
    private zzant(final zzbez<V> zzahW, final V zzahV) {
        zzbo.zzu(zzahW);
        this.zzahW = zzahW;
        this.zzahV = zzahV;
    }
    
    static zzant<Float> zza(final String s, final float n, final float n2) {
        return new zzant<Float>(zzbez.zza(s, 0.5f), 0.5f);
    }
    
    static zzant<Integer> zza(final String s, final int i, final int j) {
        return new zzant<Integer>(zzbez.zza(s, j), i);
    }
    
    static zzant<Long> zza(final String s, final long l, final long i) {
        return new zzant<Long>(zzbez.zza(s, i), l);
    }
    
    static zzant<Boolean> zza(final String s, final boolean b, final boolean b2) {
        return new zzant<Boolean>(zzbez.zzg(s, b2), b);
    }
    
    static zzant<String> zzc(final String s, final String s2, final String s3) {
        return new zzant<String>(zzbez.zzv(s, s3), s2);
    }
    
    public final V get() {
        return this.zzahV;
    }
}
