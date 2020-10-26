// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class aei extends adj<aei> implements Cloneable
{
    private byte[] zzctM;
    private String zzctN;
    private byte[][] zzctO;
    private boolean zzctP;
    
    public aei() {
        this.zzctM = ads.zzcsI;
        this.zzctN = "";
        this.zzctO = ads.zzcsH;
        this.zzctP = false;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    private aei zzMc() {
        try {
            final aei aei = super.zzLN();
            if (this.zzctO != null && this.zzctO.length > 0) {
                aei.zzctO = this.zzctO.clone();
            }
            return aei;
        }
        catch (CloneNotSupportedException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof aei)) {
                return false;
            }
            final aei aei = (aei)o;
            if (!Arrays.equals(this.zzctM, aei.zzctM)) {
                return false;
            }
            if (this.zzctN == null) {
                if (aei.zzctN != null) {
                    return false;
                }
            }
            else if (!this.zzctN.equals(aei.zzctN)) {
                return false;
            }
            if (!adn.zza(this.zzctO, aei.zzctO)) {
                return false;
            }
            if (this.zzctP != aei.zzctP) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(aei.zzcso);
            }
            if (aei.zzcso != null && !aei.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = Arrays.hashCode(this.zzctM);
        int hashCode3;
        if (this.zzctN == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzctN.hashCode();
        }
        final int zzc = adn.zzc(this.zzctO);
        int n2;
        if (this.zzctP) {
            n2 = 1231;
        }
        else {
            n2 = 1237;
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
        return (n2 + ((hashCode3 + ((hashCode + 527) * 31 + hashCode2) * 31) * 31 + zzc) * 31) * 31 + hashCode4;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (!Arrays.equals(this.zzctM, ads.zzcsI)) {
            adh.zzb(1, this.zzctM);
        }
        if (this.zzctO != null && this.zzctO.length > 0) {
            for (int i = 0; i < this.zzctO.length; ++i) {
                final byte[] array = this.zzctO[i];
                if (array != null) {
                    adh.zzb(2, array);
                }
            }
        }
        if (this.zzctP) {
            adh.zzk(3, this.zzctP);
        }
        if (this.zzctN != null && !this.zzctN.equals("")) {
            adh.zzl(4, this.zzctN);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        int zzn;
        final int n2 = zzn = super.zzn();
        if (!Arrays.equals(this.zzctM, ads.zzcsI)) {
            zzn = n2 + adh.zzc(1, this.zzctM);
        }
        int n3 = zzn;
        if (this.zzctO != null) {
            n3 = zzn;
            if (this.zzctO.length > 0) {
                int n4 = 0;
                int n5 = 0;
                int n6;
                int n7;
                for (int i = n; i < this.zzctO.length; ++i, n4 = n6, n5 = n7) {
                    final byte[] array = this.zzctO[i];
                    n6 = n4;
                    n7 = n5;
                    if (array != null) {
                        n7 = n5 + 1;
                        n6 = n4 + adh.zzJ(array);
                    }
                }
                n3 = zzn + n4 + n5 * 1;
            }
        }
        int n8 = n3;
        if (this.zzctP) {
            n8 = n3 + (adh.zzct(3) + 1);
        }
        int n9 = n8;
        if (this.zzctN != null) {
            n9 = n8;
            if (!this.zzctN.equals("")) {
                n9 = n8 + adh.zzm(4, this.zzctN);
            }
        }
        return n9;
    }
}
