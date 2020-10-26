// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class aeh extends adj<aeh> implements Cloneable
{
    private String version;
    private int zzbpb;
    private String zzctL;
    
    public aeh() {
        this.zzbpb = 0;
        this.zzctL = "";
        this.version = "";
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    private aeh zzMb() {
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
            if (!(o instanceof aeh)) {
                return false;
            }
            final aeh aeh = (aeh)o;
            if (this.zzbpb != aeh.zzbpb) {
                return false;
            }
            if (this.zzctL == null) {
                if (aeh.zzctL != null) {
                    return false;
                }
            }
            else if (!this.zzctL.equals(aeh.zzctL)) {
                return false;
            }
            if (this.version == null) {
                if (aeh.version != null) {
                    return false;
                }
            }
            else if (!this.version.equals(aeh.version)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(aeh.zzcso);
            }
            if (aeh.zzcso != null && !aeh.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int zzbpb = this.zzbpb;
        int hashCode2;
        if (this.zzctL == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzctL.hashCode();
        }
        int hashCode3;
        if (this.version == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.version.hashCode();
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
        return (hashCode3 + (hashCode2 + ((hashCode + 527) * 31 + zzbpb) * 31) * 31) * 31 + hashCode4;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbpb != 0) {
            adh.zzr(1, this.zzbpb);
        }
        if (this.zzctL != null && !this.zzctL.equals("")) {
            adh.zzl(2, this.zzctL);
        }
        if (this.version != null && !this.version.equals("")) {
            adh.zzl(3, this.version);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzbpb != 0) {
            zzn = n + adh.zzs(1, this.zzbpb);
        }
        int n2 = zzn;
        if (this.zzctL != null) {
            n2 = zzn;
            if (!this.zzctL.equals("")) {
                n2 = zzn + adh.zzm(2, this.zzctL);
            }
        }
        int n3 = n2;
        if (this.version != null) {
            n3 = n2;
            if (!this.version.equals("")) {
                n3 = n2 + adh.zzm(3, this.version);
            }
        }
        return n3;
    }
}
