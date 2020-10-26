// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjs extends adj<zzcjs>
{
    private static volatile zzcjs[] zzbvi;
    public String name;
    public Boolean zzbvj;
    public Boolean zzbvk;
    
    public zzcjs() {
        this.name = null;
        this.zzbvj = null;
        this.zzbvk = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjs[] zzzy() {
        Label_0027: {
            if (zzcjs.zzbvi != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjs.zzbvi == null) {
                    zzcjs.zzbvi = new zzcjs[0];
                }
                return zzcjs.zzbvi;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjs)) {
                return false;
            }
            final zzcjs zzcjs = (zzcjs)o;
            if (this.name == null) {
                if (zzcjs.name != null) {
                    return false;
                }
            }
            else if (!this.name.equals(zzcjs.name)) {
                return false;
            }
            if (this.zzbvj == null) {
                if (zzcjs.zzbvj != null) {
                    return false;
                }
            }
            else if (!this.zzbvj.equals(zzcjs.zzbvj)) {
                return false;
            }
            if (this.zzbvk == null) {
                if (zzcjs.zzbvk != null) {
                    return false;
                }
            }
            else if (!this.zzbvk.equals(zzcjs.zzbvk)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjs.zzcso);
            }
            if (zzcjs.zzcso != null && !zzcjs.zzcso.isEmpty()) {
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
        if (this.name == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.name.hashCode();
        }
        int hashCode3;
        if (this.zzbvj == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbvj.hashCode();
        }
        int hashCode4;
        if (this.zzbvk == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbvk.hashCode();
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
        if (this.name != null) {
            adh.zzl(1, this.name);
        }
        if (this.zzbvj != null) {
            adh.zzk(2, this.zzbvj);
        }
        if (this.zzbvk != null) {
            adh.zzk(3, this.zzbvk);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.name != null) {
            zzn = n + adh.zzm(1, this.name);
        }
        int n2 = zzn;
        if (this.zzbvj != null) {
            this.zzbvj;
            n2 = zzn + (adh.zzct(2) + 1);
        }
        int n3 = n2;
        if (this.zzbvk != null) {
            this.zzbvk;
            n3 = n2 + (adh.zzct(3) + 1);
        }
        return n3;
    }
}
