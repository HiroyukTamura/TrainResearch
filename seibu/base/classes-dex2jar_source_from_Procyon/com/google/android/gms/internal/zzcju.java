// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcju extends adj<zzcju>
{
    private static volatile zzcju[] zzbvq;
    public String key;
    public String value;
    
    public zzcju() {
        this.key = null;
        this.value = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcju[] zzzz() {
        Label_0027: {
            if (zzcju.zzbvq != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcju.zzbvq == null) {
                    zzcju.zzbvq = new zzcju[0];
                }
                return zzcju.zzbvq;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcju)) {
                return false;
            }
            final zzcju zzcju = (zzcju)o;
            if (this.key == null) {
                if (zzcju.key != null) {
                    return false;
                }
            }
            else if (!this.key.equals(zzcju.key)) {
                return false;
            }
            if (this.value == null) {
                if (zzcju.value != null) {
                    return false;
                }
            }
            else if (!this.value.equals(zzcju.value)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcju.zzcso);
            }
            if (zzcju.zzcso != null && !zzcju.zzcso.isEmpty()) {
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
        if (this.key == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.key.hashCode();
        }
        int hashCode3;
        if (this.value == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.value.hashCode();
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
        return (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31 + hashCode4;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.key != null) {
            adh.zzl(1, this.key);
        }
        if (this.value != null) {
            adh.zzl(2, this.value);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.key != null) {
            zzn = n + adh.zzm(1, this.key);
        }
        int n2 = zzn;
        if (this.value != null) {
            n2 = zzn + adh.zzm(2, this.value);
        }
        return n2;
    }
}
