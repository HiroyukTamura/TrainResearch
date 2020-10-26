// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbn extends adj<zzbn>
{
    public String version;
    private String[] zzkN;
    public String[] zzkO;
    public zzbr[] zzkP;
    public zzbm[] zzkQ;
    public zzbj[] zzkR;
    public zzbj[] zzkS;
    public zzbj[] zzkT;
    public zzbo[] zzkU;
    private String zzkV;
    private String zzkW;
    private String zzkX;
    private zzbi zzkY;
    private float zzkZ;
    private boolean zzla;
    private String[] zzlb;
    public int zzlc;
    
    public zzbn() {
        this.zzkN = ads.EMPTY_STRING_ARRAY;
        this.zzkO = ads.EMPTY_STRING_ARRAY;
        this.zzkP = zzbr.zzu();
        this.zzkQ = zzbm.zzr();
        this.zzkR = zzbj.zzp();
        this.zzkS = zzbj.zzp();
        this.zzkT = zzbj.zzp();
        this.zzkU = zzbo.zzs();
        this.zzkV = "";
        this.zzkW = "";
        this.zzkX = "0";
        this.version = "";
        this.zzkY = null;
        this.zzkZ = 0.0f;
        this.zzla = false;
        this.zzlb = ads.EMPTY_STRING_ARRAY;
        this.zzlc = 0;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbn)) {
                return false;
            }
            final zzbn zzbn = (zzbn)o;
            if (!adn.equals(this.zzkN, zzbn.zzkN)) {
                return false;
            }
            if (!adn.equals(this.zzkO, zzbn.zzkO)) {
                return false;
            }
            if (!adn.equals(this.zzkP, zzbn.zzkP)) {
                return false;
            }
            if (!adn.equals(this.zzkQ, zzbn.zzkQ)) {
                return false;
            }
            if (!adn.equals(this.zzkR, zzbn.zzkR)) {
                return false;
            }
            if (!adn.equals(this.zzkS, zzbn.zzkS)) {
                return false;
            }
            if (!adn.equals(this.zzkT, zzbn.zzkT)) {
                return false;
            }
            if (!adn.equals(this.zzkU, zzbn.zzkU)) {
                return false;
            }
            if (this.zzkV == null) {
                if (zzbn.zzkV != null) {
                    return false;
                }
            }
            else if (!this.zzkV.equals(zzbn.zzkV)) {
                return false;
            }
            if (this.zzkW == null) {
                if (zzbn.zzkW != null) {
                    return false;
                }
            }
            else if (!this.zzkW.equals(zzbn.zzkW)) {
                return false;
            }
            if (this.zzkX == null) {
                if (zzbn.zzkX != null) {
                    return false;
                }
            }
            else if (!this.zzkX.equals(zzbn.zzkX)) {
                return false;
            }
            if (this.version == null) {
                if (zzbn.version != null) {
                    return false;
                }
            }
            else if (!this.version.equals(zzbn.version)) {
                return false;
            }
            if (this.zzkY == null) {
                if (zzbn.zzkY != null) {
                    return false;
                }
            }
            else if (!this.zzkY.equals(zzbn.zzkY)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzkZ) != Float.floatToIntBits(zzbn.zzkZ)) {
                return false;
            }
            if (this.zzla != zzbn.zzla) {
                return false;
            }
            if (!adn.equals(this.zzlb, zzbn.zzlb)) {
                return false;
            }
            if (this.zzlc != zzbn.zzlc) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbn.zzcso);
            }
            if (zzbn.zzcso != null && !zzbn.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzkN);
        final int hashCode3 = adn.hashCode(this.zzkO);
        final int hashCode4 = adn.hashCode(this.zzkP);
        final int hashCode5 = adn.hashCode(this.zzkQ);
        final int hashCode6 = adn.hashCode(this.zzkR);
        final int hashCode7 = adn.hashCode(this.zzkS);
        final int hashCode8 = adn.hashCode(this.zzkT);
        final int hashCode9 = adn.hashCode(this.zzkU);
        int hashCode10;
        if (this.zzkV == null) {
            hashCode10 = 0;
        }
        else {
            hashCode10 = this.zzkV.hashCode();
        }
        int hashCode11;
        if (this.zzkW == null) {
            hashCode11 = 0;
        }
        else {
            hashCode11 = this.zzkW.hashCode();
        }
        int hashCode12;
        if (this.zzkX == null) {
            hashCode12 = 0;
        }
        else {
            hashCode12 = this.zzkX.hashCode();
        }
        int hashCode13;
        if (this.version == null) {
            hashCode13 = 0;
        }
        else {
            hashCode13 = this.version.hashCode();
        }
        int hashCode14;
        if (this.zzkY == null) {
            hashCode14 = 0;
        }
        else {
            hashCode14 = this.zzkY.hashCode();
        }
        final int floatToIntBits = Float.floatToIntBits(this.zzkZ);
        int n2;
        if (this.zzla) {
            n2 = 1231;
        }
        else {
            n2 = 1237;
        }
        final int hashCode15 = adn.hashCode(this.zzlb);
        final int zzlc = this.zzlc;
        int hashCode16 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode16 = n;
            }
            else {
                hashCode16 = this.zzcso.hashCode();
            }
        }
        return (((n2 + ((hashCode14 + (hashCode13 + (hashCode12 + (hashCode11 + (hashCode10 + (((((((((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31) * 31) * 31) * 31) * 31) * 31 + floatToIntBits) * 31) * 31 + hashCode15) * 31 + zzlc) * 31 + hashCode16;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzkO != null && this.zzkO.length > 0) {
            for (int i = 0; i < this.zzkO.length; ++i) {
                final String s = this.zzkO[i];
                if (s != null) {
                    adh.zzl(1, s);
                }
            }
        }
        if (this.zzkP != null && this.zzkP.length > 0) {
            for (int j = 0; j < this.zzkP.length; ++j) {
                final zzbr zzbr = this.zzkP[j];
                if (zzbr != null) {
                    adh.zza(2, zzbr);
                }
            }
        }
        if (this.zzkQ != null && this.zzkQ.length > 0) {
            for (int k = 0; k < this.zzkQ.length; ++k) {
                final zzbm zzbm = this.zzkQ[k];
                if (zzbm != null) {
                    adh.zza(3, zzbm);
                }
            }
        }
        if (this.zzkR != null && this.zzkR.length > 0) {
            for (int l = 0; l < this.zzkR.length; ++l) {
                final zzbj zzbj = this.zzkR[l];
                if (zzbj != null) {
                    adh.zza(4, zzbj);
                }
            }
        }
        if (this.zzkS != null && this.zzkS.length > 0) {
            for (int n2 = 0; n2 < this.zzkS.length; ++n2) {
                final zzbj zzbj2 = this.zzkS[n2];
                if (zzbj2 != null) {
                    adh.zza(5, zzbj2);
                }
            }
        }
        if (this.zzkT != null && this.zzkT.length > 0) {
            for (int n3 = 0; n3 < this.zzkT.length; ++n3) {
                final zzbj zzbj3 = this.zzkT[n3];
                if (zzbj3 != null) {
                    adh.zza(6, zzbj3);
                }
            }
        }
        if (this.zzkU != null && this.zzkU.length > 0) {
            for (int n4 = 0; n4 < this.zzkU.length; ++n4) {
                final zzbo zzbo = this.zzkU[n4];
                if (zzbo != null) {
                    adh.zza(7, zzbo);
                }
            }
        }
        if (this.zzkV != null && !this.zzkV.equals("")) {
            adh.zzl(9, this.zzkV);
        }
        if (this.zzkW != null && !this.zzkW.equals("")) {
            adh.zzl(10, this.zzkW);
        }
        if (this.zzkX != null && !this.zzkX.equals("0")) {
            adh.zzl(12, this.zzkX);
        }
        if (this.version != null && !this.version.equals("")) {
            adh.zzl(13, this.version);
        }
        if (this.zzkY != null) {
            adh.zza(14, this.zzkY);
        }
        if (Float.floatToIntBits(this.zzkZ) != Float.floatToIntBits(0.0f)) {
            adh.zzc(15, this.zzkZ);
        }
        if (this.zzlb != null && this.zzlb.length > 0) {
            for (int n5 = 0; n5 < this.zzlb.length; ++n5) {
                final String s2 = this.zzlb[n5];
                if (s2 != null) {
                    adh.zzl(16, s2);
                }
            }
        }
        if (this.zzlc != 0) {
            adh.zzr(17, this.zzlc);
        }
        if (this.zzla) {
            adh.zzk(18, this.zzla);
        }
        if (this.zzkN != null && this.zzkN.length > 0) {
            for (int n6 = n; n6 < this.zzkN.length; ++n6) {
                final String s3 = this.zzkN[n6];
                if (s3 != null) {
                    adh.zzl(19, s3);
                }
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        final int zzn = super.zzn();
        int n6;
        if (this.zzkO != null && this.zzkO.length > 0) {
            int i = 0;
            int n2 = 0;
            int n3 = 0;
            while (i < this.zzkO.length) {
                final String s = this.zzkO[i];
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
        if (this.zzkP != null) {
            n7 = n6;
            if (this.zzkP.length > 0) {
                n7 = n6;
                int n8;
                for (int j = 0; j < this.zzkP.length; ++j, n7 = n8) {
                    final zzbr zzbr = this.zzkP[j];
                    n8 = n7;
                    if (zzbr != null) {
                        n8 = n7 + adh.zzb(2, zzbr);
                    }
                }
            }
        }
        int n9 = n7;
        if (this.zzkQ != null) {
            n9 = n7;
            if (this.zzkQ.length > 0) {
                int n10;
                for (int k = 0; k < this.zzkQ.length; ++k, n7 = n10) {
                    final zzbm zzbm = this.zzkQ[k];
                    n10 = n7;
                    if (zzbm != null) {
                        n10 = n7 + adh.zzb(3, zzbm);
                    }
                }
                n9 = n7;
            }
        }
        int n11 = n9;
        if (this.zzkR != null) {
            n11 = n9;
            if (this.zzkR.length > 0) {
                n11 = n9;
                int n12;
                for (int l = 0; l < this.zzkR.length; ++l, n11 = n12) {
                    final zzbj zzbj = this.zzkR[l];
                    n12 = n11;
                    if (zzbj != null) {
                        n12 = n11 + adh.zzb(4, zzbj);
                    }
                }
            }
        }
        int n13 = n11;
        if (this.zzkS != null) {
            n13 = n11;
            if (this.zzkS.length > 0) {
                int n15;
                for (int n14 = 0; n14 < this.zzkS.length; ++n14, n11 = n15) {
                    final zzbj zzbj2 = this.zzkS[n14];
                    n15 = n11;
                    if (zzbj2 != null) {
                        n15 = n11 + adh.zzb(5, zzbj2);
                    }
                }
                n13 = n11;
            }
        }
        int n16 = n13;
        if (this.zzkT != null) {
            n16 = n13;
            if (this.zzkT.length > 0) {
                n16 = n13;
                int n18;
                for (int n17 = 0; n17 < this.zzkT.length; ++n17, n16 = n18) {
                    final zzbj zzbj3 = this.zzkT[n17];
                    n18 = n16;
                    if (zzbj3 != null) {
                        n18 = n16 + adh.zzb(6, zzbj3);
                    }
                }
            }
        }
        int n19 = n16;
        if (this.zzkU != null) {
            n19 = n16;
            if (this.zzkU.length > 0) {
                int n21;
                for (int n20 = 0; n20 < this.zzkU.length; ++n20, n16 = n21) {
                    final zzbo zzbo = this.zzkU[n20];
                    n21 = n16;
                    if (zzbo != null) {
                        n21 = n16 + adh.zzb(7, zzbo);
                    }
                }
                n19 = n16;
            }
        }
        int n22 = n19;
        if (this.zzkV != null) {
            n22 = n19;
            if (!this.zzkV.equals("")) {
                n22 = n19 + adh.zzm(9, this.zzkV);
            }
        }
        int n23 = n22;
        if (this.zzkW != null) {
            n23 = n22;
            if (!this.zzkW.equals("")) {
                n23 = n22 + adh.zzm(10, this.zzkW);
            }
        }
        int n24 = n23;
        if (this.zzkX != null) {
            n24 = n23;
            if (!this.zzkX.equals("0")) {
                n24 = n23 + adh.zzm(12, this.zzkX);
            }
        }
        int n25 = n24;
        if (this.version != null) {
            n25 = n24;
            if (!this.version.equals("")) {
                n25 = n24 + adh.zzm(13, this.version);
            }
        }
        int n26 = n25;
        if (this.zzkY != null) {
            n26 = n25 + adh.zzb(14, this.zzkY);
        }
        int n27 = n26;
        if (Float.floatToIntBits(this.zzkZ) != Float.floatToIntBits(0.0f)) {
            n27 = n26 + (adh.zzct(15) + 4);
        }
        int n28 = n27;
        if (this.zzlb != null) {
            n28 = n27;
            if (this.zzlb.length > 0) {
                int n29 = 0;
                int n30 = 0;
                int n31 = 0;
                while (n29 < this.zzlb.length) {
                    final String s2 = this.zzlb[n29];
                    int n32 = n30;
                    int n33 = n31;
                    if (s2 != null) {
                        n33 = n31 + 1;
                        n32 = n30 + adh.zzhQ(s2);
                    }
                    ++n29;
                    n30 = n32;
                    n31 = n33;
                }
                n28 = n27 + n30 + n31 * 2;
            }
        }
        int n34 = n28;
        if (this.zzlc != 0) {
            n34 = n28 + adh.zzs(17, this.zzlc);
        }
        int n35 = n34;
        if (this.zzla) {
            n35 = n34 + (adh.zzct(18) + 1);
        }
        int n36 = n35;
        if (this.zzkN != null) {
            n36 = n35;
            if (this.zzkN.length > 0) {
                int n37 = 0;
                int n38 = 0;
                int n40;
                int n41;
                for (int n39 = n; n39 < this.zzkN.length; ++n39, n37 = n40, n38 = n41) {
                    final String s3 = this.zzkN[n39];
                    n40 = n37;
                    n41 = n38;
                    if (s3 != null) {
                        n41 = n38 + 1;
                        n40 = n37 + adh.zzhQ(s3);
                    }
                }
                n36 = n35 + n37 + n38 * 2;
            }
        }
        return n36;
    }
}
