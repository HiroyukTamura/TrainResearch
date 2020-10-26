// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjp extends adj<zzcjp>
{
    public Integer zzbuW;
    public Boolean zzbuX;
    public String zzbuY;
    public String zzbuZ;
    public String zzbva;
    
    public zzcjp() {
        this.zzbuW = null;
        this.zzbuX = null;
        this.zzbuY = null;
        this.zzbuZ = null;
        this.zzbva = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjp)) {
                return false;
            }
            final zzcjp zzcjp = (zzcjp)o;
            if (this.zzbuW == null) {
                if (zzcjp.zzbuW != null) {
                    return false;
                }
            }
            else if (!this.zzbuW.equals(zzcjp.zzbuW)) {
                return false;
            }
            if (this.zzbuX == null) {
                if (zzcjp.zzbuX != null) {
                    return false;
                }
            }
            else if (!this.zzbuX.equals(zzcjp.zzbuX)) {
                return false;
            }
            if (this.zzbuY == null) {
                if (zzcjp.zzbuY != null) {
                    return false;
                }
            }
            else if (!this.zzbuY.equals(zzcjp.zzbuY)) {
                return false;
            }
            if (this.zzbuZ == null) {
                if (zzcjp.zzbuZ != null) {
                    return false;
                }
            }
            else if (!this.zzbuZ.equals(zzcjp.zzbuZ)) {
                return false;
            }
            if (this.zzbva == null) {
                if (zzcjp.zzbva != null) {
                    return false;
                }
            }
            else if (!this.zzbva.equals(zzcjp.zzbva)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjp.zzcso);
            }
            if (zzcjp.zzcso != null && !zzcjp.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        int intValue;
        if (this.zzbuW == null) {
            intValue = 0;
        }
        else {
            intValue = this.zzbuW;
        }
        int hashCode2;
        if (this.zzbuX == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbuX.hashCode();
        }
        int hashCode3;
        if (this.zzbuY == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbuY.hashCode();
        }
        int hashCode4;
        if (this.zzbuZ == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbuZ.hashCode();
        }
        int hashCode5;
        if (this.zzbva == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbva.hashCode();
        }
        int hashCode6 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode6 = n;
            }
            else {
                hashCode6 = this.zzcso.hashCode();
            }
        }
        return (hashCode5 + (hashCode4 + (hashCode3 + (hashCode2 + (intValue + (hashCode + 527) * 31) * 31) * 31) * 31) * 31) * 31 + hashCode6;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbuW != null) {
            adh.zzr(1, this.zzbuW);
        }
        if (this.zzbuX != null) {
            adh.zzk(2, this.zzbuX);
        }
        if (this.zzbuY != null) {
            adh.zzl(3, this.zzbuY);
        }
        if (this.zzbuZ != null) {
            adh.zzl(4, this.zzbuZ);
        }
        if (this.zzbva != null) {
            adh.zzl(5, this.zzbva);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzbuW != null) {
            zzn = n + adh.zzs(1, this.zzbuW);
        }
        int n2 = zzn;
        if (this.zzbuX != null) {
            this.zzbuX;
            n2 = zzn + (adh.zzct(2) + 1);
        }
        int n3 = n2;
        if (this.zzbuY != null) {
            n3 = n2 + adh.zzm(3, this.zzbuY);
        }
        int n4 = n3;
        if (this.zzbuZ != null) {
            n4 = n3 + adh.zzm(4, this.zzbuZ);
        }
        int n5 = n4;
        if (this.zzbva != null) {
            n5 = n4 + adh.zzm(5, this.zzbva);
        }
        return n5;
    }
}
