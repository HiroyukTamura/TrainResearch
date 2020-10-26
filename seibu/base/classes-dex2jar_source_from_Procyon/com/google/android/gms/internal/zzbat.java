// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbe;
import java.util.Arrays;
import com.google.android.gms.common.api.Api;

public final class zzbat<O extends Api.ApiOptions>
{
    private final O zzaAJ;
    private final int zzaBA;
    private final boolean zzaBz;
    private final Api<O> zzayW;
    
    private zzbat(final Api<O> zzayW) {
        this.zzaBz = true;
        this.zzayW = zzayW;
        this.zzaAJ = null;
        this.zzaBA = System.identityHashCode(this);
    }
    
    private zzbat(final Api<O> zzayW, final O zzaAJ) {
        this.zzaBz = false;
        this.zzayW = zzayW;
        this.zzaAJ = zzaAJ;
        this.zzaBA = Arrays.hashCode(new Object[] { this.zzayW, this.zzaAJ });
    }
    
    public static <O extends Api.ApiOptions> zzbat<O> zza(final Api<O> api, final O o) {
        return new zzbat<O>(api, o);
    }
    
    public static <O extends Api.ApiOptions> zzbat<O> zzb(final Api<O> api) {
        return new zzbat<O>(api);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbat)) {
                return false;
            }
            final zzbat zzbat = (zzbat)o;
            if (this.zzaBz || zzbat.zzaBz || !zzbe.equal(this.zzayW, zzbat.zzayW) || !zzbe.equal(this.zzaAJ, zzbat.zzaAJ)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return this.zzaBA;
    }
    
    public final String zzpr() {
        return this.zzayW.getName();
    }
}
