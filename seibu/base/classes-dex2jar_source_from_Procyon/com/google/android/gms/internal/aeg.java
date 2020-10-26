// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class aeg extends adj<aeg> implements Cloneable
{
    private String[] zzctG;
    private String[] zzctH;
    private int[] zzctI;
    private long[] zzctJ;
    private long[] zzctK;
    
    public aeg() {
        this.zzctG = ads.EMPTY_STRING_ARRAY;
        this.zzctH = ads.EMPTY_STRING_ARRAY;
        this.zzctI = ads.zzcsC;
        this.zzctJ = ads.zzcsD;
        this.zzctK = ads.zzcsD;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    private aeg zzMa() {
        try {
            final aeg aeg = super.zzLN();
            if (this.zzctG != null && this.zzctG.length > 0) {
                aeg.zzctG = this.zzctG.clone();
            }
            if (this.zzctH != null && this.zzctH.length > 0) {
                aeg.zzctH = this.zzctH.clone();
            }
            if (this.zzctI != null && this.zzctI.length > 0) {
                aeg.zzctI = this.zzctI.clone();
            }
            if (this.zzctJ != null && this.zzctJ.length > 0) {
                aeg.zzctJ = this.zzctJ.clone();
            }
            if (this.zzctK != null && this.zzctK.length > 0) {
                aeg.zzctK = this.zzctK.clone();
            }
            return aeg;
        }
        catch (CloneNotSupportedException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof aeg)) {
                return false;
            }
            final aeg aeg = (aeg)o;
            if (!adn.equals(this.zzctG, aeg.zzctG)) {
                return false;
            }
            if (!adn.equals(this.zzctH, aeg.zzctH)) {
                return false;
            }
            if (!adn.equals(this.zzctI, aeg.zzctI)) {
                return false;
            }
            if (!adn.equals(this.zzctJ, aeg.zzctJ)) {
                return false;
            }
            if (!adn.equals(this.zzctK, aeg.zzctK)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(aeg.zzcso);
            }
            if (aeg.zzcso != null && !aeg.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzctG);
        final int hashCode3 = adn.hashCode(this.zzctH);
        final int hashCode4 = adn.hashCode(this.zzctI);
        final int hashCode5 = adn.hashCode(this.zzctJ);
        final int hashCode6 = adn.hashCode(this.zzctK);
        int hashCode7;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = this.zzcso.hashCode();
        }
        return hashCode7 + ((((((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzctG != null && this.zzctG.length > 0) {
            for (int i = 0; i < this.zzctG.length; ++i) {
                final String s = this.zzctG[i];
                if (s != null) {
                    adh.zzl(1, s);
                }
            }
        }
        if (this.zzctH != null && this.zzctH.length > 0) {
            for (int j = 0; j < this.zzctH.length; ++j) {
                final String s2 = this.zzctH[j];
                if (s2 != null) {
                    adh.zzl(2, s2);
                }
            }
        }
        if (this.zzctI != null && this.zzctI.length > 0) {
            for (int k = 0; k < this.zzctI.length; ++k) {
                adh.zzr(3, this.zzctI[k]);
            }
        }
        if (this.zzctJ != null && this.zzctJ.length > 0) {
            for (int l = 0; l < this.zzctJ.length; ++l) {
                adh.zzb(4, this.zzctJ[l]);
            }
        }
        if (this.zzctK != null && this.zzctK.length > 0) {
            for (int n2 = n; n2 < this.zzctK.length; ++n2) {
                adh.zzb(5, this.zzctK[n2]);
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        final int zzn = super.zzn();
        int n6;
        if (this.zzctG != null && this.zzctG.length > 0) {
            int i = 0;
            int n2 = 0;
            int n3 = 0;
            while (i < this.zzctG.length) {
                final String s = this.zzctG[i];
                int n4 = n2;
                int n5 = n3;
                if (s != null) {
                    n5 = n3 + 1;
                    n4 = n2 + adh.zzhQ(s);
                }
                ++i;
                n2 = n4;
                n3 = n5;
            }
            n6 = zzn + n2 + n3 * 1;
        }
        else {
            n6 = zzn;
        }
        int n7 = n6;
        if (this.zzctH != null) {
            n7 = n6;
            if (this.zzctH.length > 0) {
                int j = 0;
                int n8 = 0;
                int n9 = 0;
                while (j < this.zzctH.length) {
                    final String s2 = this.zzctH[j];
                    int n10 = n8;
                    int n11 = n9;
                    if (s2 != null) {
                        n11 = n9 + 1;
                        n10 = n8 + adh.zzhQ(s2);
                    }
                    ++j;
                    n8 = n10;
                    n9 = n11;
                }
                n7 = n6 + n8 + n9 * 1;
            }
        }
        int n12 = n7;
        if (this.zzctI != null) {
            n12 = n7;
            if (this.zzctI.length > 0) {
                int k = 0;
                int n13 = 0;
                while (k < this.zzctI.length) {
                    n13 += adh.zzcr(this.zzctI[k]);
                    ++k;
                }
                n12 = n7 + n13 + this.zzctI.length * 1;
            }
        }
        int n14 = n12;
        if (this.zzctJ != null) {
            n14 = n12;
            if (this.zzctJ.length > 0) {
                int l = 0;
                int n15 = 0;
                while (l < this.zzctJ.length) {
                    n15 += adh.zzaP(this.zzctJ[l]);
                    ++l;
                }
                n14 = n12 + n15 + this.zzctJ.length * 1;
            }
        }
        int n16 = n14;
        if (this.zzctK != null) {
            n16 = n14;
            if (this.zzctK.length > 0) {
                int n17 = 0;
                for (int n18 = n; n18 < this.zzctK.length; ++n18) {
                    n17 += adh.zzaP(this.zzctK[n18]);
                }
                n16 = n14 + n17 + this.zzctK.length * 1;
            }
        }
        return n16;
    }
}
