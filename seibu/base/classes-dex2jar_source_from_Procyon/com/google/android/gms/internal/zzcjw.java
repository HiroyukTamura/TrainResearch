// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjw extends adj<zzcjw>
{
    private static volatile zzcjw[] zzbvv;
    public Integer count;
    public String name;
    public zzcjx[] zzbvw;
    public Long zzbvx;
    public Long zzbvy;
    
    public zzcjw() {
        this.zzbvw = zzcjx.zzzC();
        this.name = null;
        this.zzbvx = null;
        this.zzbvy = null;
        this.count = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjw[] zzzB() {
        Label_0027: {
            if (zzcjw.zzbvv != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjw.zzbvv == null) {
                    zzcjw.zzbvv = new zzcjw[0];
                }
                return zzcjw.zzbvv;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjw)) {
                return false;
            }
            final zzcjw zzcjw = (zzcjw)o;
            if (!adn.equals(this.zzbvw, zzcjw.zzbvw)) {
                return false;
            }
            if (this.name == null) {
                if (zzcjw.name != null) {
                    return false;
                }
            }
            else if (!this.name.equals(zzcjw.name)) {
                return false;
            }
            if (this.zzbvx == null) {
                if (zzcjw.zzbvx != null) {
                    return false;
                }
            }
            else if (!this.zzbvx.equals(zzcjw.zzbvx)) {
                return false;
            }
            if (this.zzbvy == null) {
                if (zzcjw.zzbvy != null) {
                    return false;
                }
            }
            else if (!this.zzbvy.equals(zzcjw.zzbvy)) {
                return false;
            }
            if (this.count == null) {
                if (zzcjw.count != null) {
                    return false;
                }
            }
            else if (!this.count.equals(zzcjw.count)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjw.zzcso);
            }
            if (zzcjw.zzcso != null && !zzcjw.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzbvw);
        int hashCode3;
        if (this.name == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.name.hashCode();
        }
        int hashCode4;
        if (this.zzbvx == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbvx.hashCode();
        }
        int hashCode5;
        if (this.zzbvy == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbvy.hashCode();
        }
        int hashCode6;
        if (this.count == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = this.count.hashCode();
        }
        int hashCode7 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode7 = n;
            }
            else {
                hashCode7 = this.zzcso.hashCode();
            }
        }
        return (hashCode6 + (hashCode5 + (hashCode4 + (hashCode3 + ((hashCode + 527) * 31 + hashCode2) * 31) * 31) * 31) * 31) * 31 + hashCode7;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbvw != null && this.zzbvw.length > 0) {
            for (int i = 0; i < this.zzbvw.length; ++i) {
                final zzcjx zzcjx = this.zzbvw[i];
                if (zzcjx != null) {
                    adh.zza(1, zzcjx);
                }
            }
        }
        if (this.name != null) {
            adh.zzl(2, this.name);
        }
        if (this.zzbvx != null) {
            adh.zzb(3, this.zzbvx);
        }
        if (this.zzbvy != null) {
            adh.zzb(4, this.zzbvy);
        }
        if (this.count != null) {
            adh.zzr(5, this.count);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        int n = zzn = super.zzn();
        if (this.zzbvw != null) {
            zzn = n;
            if (this.zzbvw.length > 0) {
                int n2 = 0;
                while (true) {
                    zzn = n;
                    if (n2 >= this.zzbvw.length) {
                        break;
                    }
                    final zzcjx zzcjx = this.zzbvw[n2];
                    int n3 = n;
                    if (zzcjx != null) {
                        n3 = n + adh.zzb(1, zzcjx);
                    }
                    ++n2;
                    n = n3;
                }
            }
        }
        int n4 = zzn;
        if (this.name != null) {
            n4 = zzn + adh.zzm(2, this.name);
        }
        int n5 = n4;
        if (this.zzbvx != null) {
            n5 = n4 + adh.zze(3, this.zzbvx);
        }
        int n6 = n5;
        if (this.zzbvy != null) {
            n6 = n5 + adh.zze(4, this.zzbvy);
        }
        int n7 = n6;
        if (this.count != null) {
            n7 = n6 + adh.zzs(5, this.count);
        }
        return n7;
    }
}
