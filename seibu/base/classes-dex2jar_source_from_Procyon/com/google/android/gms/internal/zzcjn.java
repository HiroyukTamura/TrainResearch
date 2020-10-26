// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjn extends adj<zzcjn>
{
    private static volatile zzcjn[] zzbuL;
    public Integer zzbuM;
    public String zzbuN;
    public zzcjo[] zzbuO;
    private Boolean zzbuP;
    public zzcjp zzbuQ;
    
    public zzcjn() {
        this.zzbuM = null;
        this.zzbuN = null;
        this.zzbuO = zzcjo.zzzw();
        this.zzbuP = null;
        this.zzbuQ = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjn[] zzzv() {
        Label_0027: {
            if (zzcjn.zzbuL != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjn.zzbuL == null) {
                    zzcjn.zzbuL = new zzcjn[0];
                }
                return zzcjn.zzbuL;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjn)) {
                return false;
            }
            final zzcjn zzcjn = (zzcjn)o;
            if (this.zzbuM == null) {
                if (zzcjn.zzbuM != null) {
                    return false;
                }
            }
            else if (!this.zzbuM.equals(zzcjn.zzbuM)) {
                return false;
            }
            if (this.zzbuN == null) {
                if (zzcjn.zzbuN != null) {
                    return false;
                }
            }
            else if (!this.zzbuN.equals(zzcjn.zzbuN)) {
                return false;
            }
            if (!adn.equals(this.zzbuO, zzcjn.zzbuO)) {
                return false;
            }
            if (this.zzbuP == null) {
                if (zzcjn.zzbuP != null) {
                    return false;
                }
            }
            else if (!this.zzbuP.equals(zzcjn.zzbuP)) {
                return false;
            }
            if (this.zzbuQ == null) {
                if (zzcjn.zzbuQ != null) {
                    return false;
                }
            }
            else if (!this.zzbuQ.equals(zzcjn.zzbuQ)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjn.zzcso);
            }
            if (zzcjn.zzcso != null && !zzcjn.zzcso.isEmpty()) {
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
        if (this.zzbuN == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbuN.hashCode();
        }
        final int hashCode4 = adn.hashCode(this.zzbuO);
        int hashCode5;
        if (this.zzbuP == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbuP.hashCode();
        }
        int hashCode6;
        if (this.zzbuQ == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = this.zzbuQ.hashCode();
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
        return (hashCode6 + (hashCode5 + ((hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31 + hashCode4) * 31) * 31) * 31 + hashCode7;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbuM != null) {
            adh.zzr(1, this.zzbuM);
        }
        if (this.zzbuN != null) {
            adh.zzl(2, this.zzbuN);
        }
        if (this.zzbuO != null && this.zzbuO.length > 0) {
            for (int i = 0; i < this.zzbuO.length; ++i) {
                final zzcjo zzcjo = this.zzbuO[i];
                if (zzcjo != null) {
                    adh.zza(3, zzcjo);
                }
            }
        }
        if (this.zzbuP != null) {
            adh.zzk(4, this.zzbuP);
        }
        if (this.zzbuQ != null) {
            adh.zza(5, this.zzbuQ);
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
        if (this.zzbuN != null) {
            n2 = zzn + adh.zzm(2, this.zzbuN);
        }
        int n3 = n2;
        if (this.zzbuO != null) {
            n3 = n2;
            if (this.zzbuO.length > 0) {
                int n4;
                for (int i = 0; i < this.zzbuO.length; ++i, n2 = n4) {
                    final zzcjo zzcjo = this.zzbuO[i];
                    n4 = n2;
                    if (zzcjo != null) {
                        n4 = n2 + adh.zzb(3, zzcjo);
                    }
                }
                n3 = n2;
            }
        }
        int n5 = n3;
        if (this.zzbuP != null) {
            this.zzbuP;
            n5 = n3 + (adh.zzct(4) + 1);
        }
        int n6 = n5;
        if (this.zzbuQ != null) {
            n6 = n5 + adh.zzb(5, this.zzbuQ);
        }
        return n6;
    }
}
