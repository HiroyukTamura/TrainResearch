// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbr extends adj<zzbr>
{
    private static volatile zzbr[] zzlD;
    public String string;
    public int type;
    public zzbr[] zzlE;
    public zzbr[] zzlF;
    public zzbr[] zzlG;
    public String zzlH;
    public String zzlI;
    public long zzlJ;
    public boolean zzlK;
    public zzbr[] zzlL;
    public int[] zzlM;
    public boolean zzlN;
    
    public zzbr() {
        this.type = 1;
        this.string = "";
        this.zzlE = zzu();
        this.zzlF = zzu();
        this.zzlG = zzu();
        this.zzlH = "";
        this.zzlI = "";
        this.zzlJ = 0L;
        this.zzlK = false;
        this.zzlL = zzu();
        this.zzlM = ads.zzcsC;
        this.zzlN = false;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzbr[] zzu() {
        Label_0027: {
            if (zzbr.zzlD != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzbr.zzlD == null) {
                    zzbr.zzlD = new zzbr[0];
                }
                return zzbr.zzlD;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbr)) {
                return false;
            }
            final zzbr zzbr = (zzbr)o;
            if (this.type != zzbr.type) {
                return false;
            }
            if (this.string == null) {
                if (zzbr.string != null) {
                    return false;
                }
            }
            else if (!this.string.equals(zzbr.string)) {
                return false;
            }
            if (!adn.equals(this.zzlE, zzbr.zzlE)) {
                return false;
            }
            if (!adn.equals(this.zzlF, zzbr.zzlF)) {
                return false;
            }
            if (!adn.equals(this.zzlG, zzbr.zzlG)) {
                return false;
            }
            if (this.zzlH == null) {
                if (zzbr.zzlH != null) {
                    return false;
                }
            }
            else if (!this.zzlH.equals(zzbr.zzlH)) {
                return false;
            }
            if (this.zzlI == null) {
                if (zzbr.zzlI != null) {
                    return false;
                }
            }
            else if (!this.zzlI.equals(zzbr.zzlI)) {
                return false;
            }
            if (this.zzlJ != zzbr.zzlJ) {
                return false;
            }
            if (this.zzlK != zzbr.zzlK) {
                return false;
            }
            if (!adn.equals(this.zzlL, zzbr.zzlL)) {
                return false;
            }
            if (!adn.equals(this.zzlM, zzbr.zzlM)) {
                return false;
            }
            if (this.zzlN != zzbr.zzlN) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbr.zzcso);
            }
            if (zzbr.zzcso != null && !zzbr.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int n = 1231;
        final int n2 = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int type = this.type;
        int hashCode2;
        if (this.string == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.string.hashCode();
        }
        final int hashCode3 = adn.hashCode(this.zzlE);
        final int hashCode4 = adn.hashCode(this.zzlF);
        final int hashCode5 = adn.hashCode(this.zzlG);
        int hashCode6;
        if (this.zzlH == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = this.zzlH.hashCode();
        }
        int hashCode7;
        if (this.zzlI == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = this.zzlI.hashCode();
        }
        final int n3 = (int)(this.zzlJ ^ this.zzlJ >>> 32);
        int n4;
        if (this.zzlK) {
            n4 = 1231;
        }
        else {
            n4 = 1237;
        }
        final int hashCode8 = adn.hashCode(this.zzlL);
        final int hashCode9 = adn.hashCode(this.zzlM);
        if (!this.zzlN) {
            n = 1237;
        }
        int hashCode10 = n2;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode10 = n2;
            }
            else {
                hashCode10 = this.zzcso.hashCode();
            }
        }
        return ((((n4 + ((hashCode7 + (hashCode6 + ((((hashCode2 + ((hashCode + 527) * 31 + type) * 31) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31) * 31) * 31 + n3) * 31) * 31 + hashCode8) * 31 + hashCode9) * 31 + n) * 31 + hashCode10;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        adh.zzr(1, this.type);
        if (this.string != null && !this.string.equals("")) {
            adh.zzl(2, this.string);
        }
        if (this.zzlE != null && this.zzlE.length > 0) {
            for (int i = 0; i < this.zzlE.length; ++i) {
                final zzbr zzbr = this.zzlE[i];
                if (zzbr != null) {
                    adh.zza(3, zzbr);
                }
            }
        }
        if (this.zzlF != null && this.zzlF.length > 0) {
            for (int j = 0; j < this.zzlF.length; ++j) {
                final zzbr zzbr2 = this.zzlF[j];
                if (zzbr2 != null) {
                    adh.zza(4, zzbr2);
                }
            }
        }
        if (this.zzlG != null && this.zzlG.length > 0) {
            for (int k = 0; k < this.zzlG.length; ++k) {
                final zzbr zzbr3 = this.zzlG[k];
                if (zzbr3 != null) {
                    adh.zza(5, zzbr3);
                }
            }
        }
        if (this.zzlH != null && !this.zzlH.equals("")) {
            adh.zzl(6, this.zzlH);
        }
        if (this.zzlI != null && !this.zzlI.equals("")) {
            adh.zzl(7, this.zzlI);
        }
        if (this.zzlJ != 0L) {
            adh.zzb(8, this.zzlJ);
        }
        if (this.zzlN) {
            adh.zzk(9, this.zzlN);
        }
        if (this.zzlM != null && this.zzlM.length > 0) {
            for (int l = 0; l < this.zzlM.length; ++l) {
                adh.zzr(10, this.zzlM[l]);
            }
        }
        if (this.zzlL != null && this.zzlL.length > 0) {
            for (int n2 = n; n2 < this.zzlL.length; ++n2) {
                final zzbr zzbr4 = this.zzlL[n2];
                if (zzbr4 != null) {
                    adh.zza(11, zzbr4);
                }
            }
        }
        if (this.zzlK) {
            adh.zzk(12, this.zzlK);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        int n3;
        final int n2 = n3 = super.zzn() + adh.zzs(1, this.type);
        if (this.string != null) {
            n3 = n2;
            if (!this.string.equals("")) {
                n3 = n2 + adh.zzm(2, this.string);
            }
        }
        int n4 = n3;
        if (this.zzlE != null) {
            n4 = n3;
            if (this.zzlE.length > 0) {
                int n5;
                for (int i = 0; i < this.zzlE.length; ++i, n3 = n5) {
                    final zzbr zzbr = this.zzlE[i];
                    n5 = n3;
                    if (zzbr != null) {
                        n5 = n3 + adh.zzb(3, zzbr);
                    }
                }
                n4 = n3;
            }
        }
        int n6 = n4;
        if (this.zzlF != null) {
            n6 = n4;
            if (this.zzlF.length > 0) {
                n6 = n4;
                int n7;
                for (int j = 0; j < this.zzlF.length; ++j, n6 = n7) {
                    final zzbr zzbr2 = this.zzlF[j];
                    n7 = n6;
                    if (zzbr2 != null) {
                        n7 = n6 + adh.zzb(4, zzbr2);
                    }
                }
            }
        }
        int n8 = n6;
        if (this.zzlG != null) {
            n8 = n6;
            if (this.zzlG.length > 0) {
                int n9;
                for (int k = 0; k < this.zzlG.length; ++k, n6 = n9) {
                    final zzbr zzbr3 = this.zzlG[k];
                    n9 = n6;
                    if (zzbr3 != null) {
                        n9 = n6 + adh.zzb(5, zzbr3);
                    }
                }
                n8 = n6;
            }
        }
        int n10 = n8;
        if (this.zzlH != null) {
            n10 = n8;
            if (!this.zzlH.equals("")) {
                n10 = n8 + adh.zzm(6, this.zzlH);
            }
        }
        int n11 = n10;
        if (this.zzlI != null) {
            n11 = n10;
            if (!this.zzlI.equals("")) {
                n11 = n10 + adh.zzm(7, this.zzlI);
            }
        }
        int n12 = n11;
        if (this.zzlJ != 0L) {
            n12 = n11 + adh.zze(8, this.zzlJ);
        }
        int n13 = n12;
        if (this.zzlN) {
            n13 = n12 + (adh.zzct(9) + 1);
        }
        int n14 = n13;
        if (this.zzlM != null) {
            n14 = n13;
            if (this.zzlM.length > 0) {
                int l = 0;
                int n15 = 0;
                while (l < this.zzlM.length) {
                    n15 += adh.zzcr(this.zzlM[l]);
                    ++l;
                }
                n14 = n13 + n15 + this.zzlM.length * 1;
            }
        }
        int n16 = n14;
        if (this.zzlL != null) {
            n16 = n14;
            if (this.zzlL.length > 0) {
                int n17 = n;
                while (true) {
                    n16 = n14;
                    if (n17 >= this.zzlL.length) {
                        break;
                    }
                    final zzbr zzbr4 = this.zzlL[n17];
                    int n18 = n14;
                    if (zzbr4 != null) {
                        n18 = n14 + adh.zzb(11, zzbr4);
                    }
                    ++n17;
                    n14 = n18;
                }
            }
        }
        int n19 = n16;
        if (this.zzlK) {
            n19 = n16 + (adh.zzct(12) + 1);
        }
        return n19;
    }
}
