// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class aek extends adj<aek> implements Cloneable
{
    private static volatile aek[] zzcuj;
    private String key;
    private String value;
    
    public aek() {
        this.key = "";
        this.value = "";
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static aek[] zzMe() {
        Label_0027: {
            if (aek.zzcuj != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (aek.zzcuj == null) {
                    aek.zzcuj = new aek[0];
                }
                return aek.zzcuj;
            }
        }
    }
    
    private aek zzMf() {
        try {
            return super.zzLN();
        }
        catch (CloneNotSupportedException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof aek)) {
                return false;
            }
            final aek aek = (aek)o;
            if (this.key == null) {
                if (aek.key != null) {
                    return false;
                }
            }
            else if (!this.key.equals(aek.key)) {
                return false;
            }
            if (this.value == null) {
                if (aek.value != null) {
                    return false;
                }
            }
            else if (!this.value.equals(aek.value)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(aek.zzcso);
            }
            if (aek.zzcso != null && !aek.zzcso.isEmpty()) {
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
        if (this.key != null && !this.key.equals("")) {
            adh.zzl(1, this.key);
        }
        if (this.value != null && !this.value.equals("")) {
            adh.zzl(2, this.value);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.key != null) {
            zzn = n;
            if (!this.key.equals("")) {
                zzn = n + adh.zzm(1, this.key);
            }
        }
        int n2 = zzn;
        if (this.value != null) {
            n2 = zzn;
            if (!this.value.equals("")) {
                n2 = zzn + adh.zzm(2, this.value);
            }
        }
        return n2;
    }
}
