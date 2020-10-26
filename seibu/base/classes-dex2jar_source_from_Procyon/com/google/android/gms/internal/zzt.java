// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzt<T>
{
    public final T result;
    public final zzc zzae;
    public final zzaa zzaf;
    public boolean zzag;
    
    private zzt(final zzaa zzaf) {
        this.zzag = false;
        this.result = null;
        this.zzae = null;
        this.zzaf = zzaf;
    }
    
    private zzt(final T result, final zzc zzae) {
        this.zzag = false;
        this.result = result;
        this.zzae = zzae;
        this.zzaf = null;
    }
    
    public static <T> zzt<T> zza(final T t, final zzc zzc) {
        return new zzt<T>(t, zzc);
    }
    
    public static <T> zzt<T> zzc(final zzaa zzaa) {
        return new zzt<T>(zzaa);
    }
}
