// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjy extends adj<zzcjy>
{
    public zzcjz[] zzbvB;
    
    public zzcjy() {
        this.zzbvB = zzcjz.zzzD();
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjy)) {
                return false;
            }
            final zzcjy zzcjy = (zzcjy)o;
            if (!adn.equals(this.zzbvB, zzcjy.zzbvB)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjy.zzcso);
            }
            if (zzcjy.zzcso != null && !zzcjy.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzbvB);
        int hashCode3;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzcso.hashCode();
        }
        return hashCode3 + ((hashCode + 527) * 31 + hashCode2) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbvB != null && this.zzbvB.length > 0) {
            for (int i = 0; i < this.zzbvB.length; ++i) {
                final zzcjz zzcjz = this.zzbvB[i];
                if (zzcjz != null) {
                    adh.zza(1, zzcjz);
                }
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        int n = zzn = super.zzn();
        if (this.zzbvB != null) {
            zzn = n;
            if (this.zzbvB.length > 0) {
                int n2 = 0;
                while (true) {
                    zzn = n;
                    if (n2 >= this.zzbvB.length) {
                        break;
                    }
                    final zzcjz zzcjz = this.zzbvB[n2];
                    int n3 = n;
                    if (zzcjz != null) {
                        n3 = n + adh.zzb(1, zzcjz);
                    }
                    ++n2;
                    n = n3;
                }
            }
        }
        return zzn;
    }
}
