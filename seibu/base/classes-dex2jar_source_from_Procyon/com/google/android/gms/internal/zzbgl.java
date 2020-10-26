// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class zzbgl extends zzbgi implements SafeParcelable
{
    public final int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!this.getClass().isInstance(o)) {
            return false;
        }
        final zzbgi zzbgi = (zzbgi)o;
        for (final zzbgj<?, ?> zzbgj : this.zzrL().values()) {
            if (this.zza(zzbgj)) {
                if (!zzbgi.zza(zzbgj)) {
                    return false;
                }
                if (!this.zzb(zzbgj).equals(zzbgi.zzb(zzbgj))) {
                    return false;
                }
                continue;
            }
            else {
                if (zzbgi.zza(zzbgj)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final Iterator<zzbgj<?, ?>> iterator = this.zzrL().values().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final zzbgj<?, ?> zzbgj = iterator.next();
            if (this.zza(zzbgj)) {
                n = this.zzb(zzbgj).hashCode() + n * 31;
            }
        }
        return n;
    }
    
    public Object zzcH(final String s) {
        return null;
    }
    
    public boolean zzcI(final String s) {
        return false;
    }
}
