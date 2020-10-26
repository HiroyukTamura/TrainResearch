// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class ee extends adj<ee>
{
    public long zzbLG;
    public zzbq zzbLH;
    public zzbn zzlB;
    
    public ee() {
        this.zzbLG = 0L;
        this.zzlB = null;
        this.zzbLH = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof ee)) {
                return false;
            }
            final ee ee = (ee)o;
            if (this.zzbLG != ee.zzbLG) {
                return false;
            }
            if (this.zzlB == null) {
                if (ee.zzlB != null) {
                    return false;
                }
            }
            else if (!this.zzlB.equals(ee.zzlB)) {
                return false;
            }
            if (this.zzbLH == null) {
                if (ee.zzbLH != null) {
                    return false;
                }
            }
            else if (!this.zzbLH.equals(ee.zzbLH)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(ee.zzcso);
            }
            if (ee.zzcso != null && !ee.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int n2 = (int)(this.zzbLG ^ this.zzbLG >>> 32);
        int hashCode2;
        if (this.zzlB == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzlB.hashCode();
        }
        int hashCode3;
        if (this.zzbLH == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbLH.hashCode();
        }
        int hashCode4 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode4 = n;
            }
            else {
                hashCode4 = this.zzcso.hashCode();
            }
        }
        return (hashCode3 + (hashCode2 + ((hashCode + 527) * 31 + n2) * 31) * 31) * 31 + hashCode4;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        adh.zzb(1, this.zzbLG);
        if (this.zzlB != null) {
            adh.zza(2, this.zzlB);
        }
        if (this.zzbLH != null) {
            adh.zza(3, this.zzbLH);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int n2;
        final int n = n2 = super.zzn() + adh.zze(1, this.zzbLG);
        if (this.zzlB != null) {
            n2 = n + adh.zzb(2, this.zzlB);
        }
        int n3 = n2;
        if (this.zzbLH != null) {
            n3 = n2 + adh.zzb(3, this.zzbLH);
        }
        return n3;
    }
}
