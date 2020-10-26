// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjq extends adj<zzcjq>
{
    private static volatile zzcjq[] zzbvb;
    public Integer zzbuM;
    public String zzbvc;
    public zzcjo zzbvd;
    
    public zzcjq() {
        this.zzbuM = null;
        this.zzbvc = null;
        this.zzbvd = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjq[] zzzx() {
        Label_0027: {
            if (zzcjq.zzbvb != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjq.zzbvb == null) {
                    zzcjq.zzbvb = new zzcjq[0];
                }
                return zzcjq.zzbvb;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjq)) {
                return false;
            }
            final zzcjq zzcjq = (zzcjq)o;
            if (this.zzbuM == null) {
                if (zzcjq.zzbuM != null) {
                    return false;
                }
            }
            else if (!this.zzbuM.equals(zzcjq.zzbuM)) {
                return false;
            }
            if (this.zzbvc == null) {
                if (zzcjq.zzbvc != null) {
                    return false;
                }
            }
            else if (!this.zzbvc.equals(zzcjq.zzbvc)) {
                return false;
            }
            if (this.zzbvd == null) {
                if (zzcjq.zzbvd != null) {
                    return false;
                }
            }
            else if (!this.zzbvd.equals(zzcjq.zzbvd)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjq.zzcso);
            }
            if (zzcjq.zzcso != null && !zzcjq.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        int hashCode2;
        if (this.zzbuM == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbuM.hashCode();
        }
        int hashCode3;
        if (this.zzbvc == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbvc.hashCode();
        }
        int hashCode4;
        if (this.zzbvd == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbvd.hashCode();
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
        return (hashCode4 + (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31) * 31 + hashCode5;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbuM != null) {
            adh.zzr(1, this.zzbuM);
        }
        if (this.zzbvc != null) {
            adh.zzl(2, this.zzbvc);
        }
        if (this.zzbvd != null) {
            adh.zza(3, this.zzbvd);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzbuM != null) {
            zzn = n + adh.zzs(1, this.zzbuM);
        }
        int n2 = zzn;
        if (this.zzbvc != null) {
            n2 = zzn + adh.zzm(2, this.zzbvc);
        }
        int n3 = n2;
        if (this.zzbvd != null) {
            n3 = n2 + adh.zzb(3, this.zzbvd);
        }
        return n3;
    }
}
