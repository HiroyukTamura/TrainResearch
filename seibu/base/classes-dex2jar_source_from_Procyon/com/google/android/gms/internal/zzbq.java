// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbq extends adj<zzbq>
{
    public zzbp[] zzlA;
    public zzbn zzlB;
    public String zzlC;
    
    public zzbq() {
        this.zzlA = zzbp.zzt();
        this.zzlB = null;
        this.zzlC = "";
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbq)) {
                return false;
            }
            final zzbq zzbq = (zzbq)o;
            if (!adn.equals(this.zzlA, zzbq.zzlA)) {
                return false;
            }
            if (this.zzlB == null) {
                if (zzbq.zzlB != null) {
                    return false;
                }
            }
            else if (!this.zzlB.equals(zzbq.zzlB)) {
                return false;
            }
            if (this.zzlC == null) {
                if (zzbq.zzlC != null) {
                    return false;
                }
            }
            else if (!this.zzlC.equals(zzbq.zzlC)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbq.zzcso);
            }
            if (zzbq.zzcso != null && !zzbq.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzlA);
        int hashCode3;
        if (this.zzlB == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzlB.hashCode();
        }
        int hashCode4;
        if (this.zzlC == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzlC.hashCode();
        }
        int hashCode5 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode5 = n;
            }
            else {
                hashCode5 = this.zzcso.hashCode();
            }
        }
        return (hashCode4 + (hashCode3 + ((hashCode + 527) * 31 + hashCode2) * 31) * 31) * 31 + hashCode5;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzlA != null && this.zzlA.length > 0) {
            for (int i = 0; i < this.zzlA.length; ++i) {
                final zzbp zzbp = this.zzlA[i];
                if (zzbp != null) {
                    adh.zza(1, zzbp);
                }
            }
        }
        if (this.zzlB != null) {
            adh.zza(2, this.zzlB);
        }
        if (this.zzlC != null && !this.zzlC.equals("")) {
            adh.zzl(3, this.zzlC);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        int n = zzn = super.zzn();
        if (this.zzlA != null) {
            zzn = n;
            if (this.zzlA.length > 0) {
                int n2 = 0;
                while (true) {
                    zzn = n;
                    if (n2 >= this.zzlA.length) {
                        break;
                    }
                    final zzbp zzbp = this.zzlA[n2];
                    int n3 = n;
                    if (zzbp != null) {
                        n3 = n + adh.zzb(1, zzbp);
                    }
                    ++n2;
                    n = n3;
                }
            }
        }
        int n4 = zzn;
        if (this.zzlB != null) {
            n4 = zzn + adh.zzb(2, this.zzlB);
        }
        int n5 = n4;
        if (this.zzlC != null) {
            n5 = n4;
            if (!this.zzlC.equals("")) {
                n5 = n4 + adh.zzm(3, this.zzlC);
            }
        }
        return n5;
    }
}
