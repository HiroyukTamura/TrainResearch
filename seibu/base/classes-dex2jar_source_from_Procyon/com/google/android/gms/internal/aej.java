// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class aej extends adj<aej> implements Cloneable
{
    private String tag;
    private boolean zzccZ;
    private ael zzcmX;
    public long zzctQ;
    public long zzctR;
    private long zzctS;
    public int zzctT;
    private aek[] zzctU;
    private byte[] zzctV;
    private aeh zzctW;
    public byte[] zzctX;
    private String zzctY;
    private String zzctZ;
    private aeg zzcua;
    private String zzcub;
    public long zzcuc;
    private aei zzcud;
    public byte[] zzcue;
    private String zzcuf;
    private int zzcug;
    private int[] zzcuh;
    private long zzcui;
    public int zzrB;
    
    public aej() {
        this.zzctQ = 0L;
        this.zzctR = 0L;
        this.zzctS = 0L;
        this.tag = "";
        this.zzctT = 0;
        this.zzrB = 0;
        this.zzccZ = false;
        this.zzctU = aek.zzMe();
        this.zzctV = ads.zzcsI;
        this.zzctW = null;
        this.zzctX = ads.zzcsI;
        this.zzctY = "";
        this.zzctZ = "";
        this.zzcua = null;
        this.zzcub = "";
        this.zzcuc = 180000L;
        this.zzcud = null;
        this.zzcue = ads.zzcsI;
        this.zzcuf = "";
        this.zzcug = 0;
        this.zzcuh = ads.zzcsC;
        this.zzcui = 0L;
        this.zzcmX = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    private final aej zzMd() {
        aej aej;
        try {
            aej = super.zzLN();
            if (this.zzctU != null && this.zzctU.length > 0) {
                aej.zzctU = new aek[this.zzctU.length];
                for (int i = 0; i < this.zzctU.length; ++i) {
                    if (this.zzctU[i] != null) {
                        aej.zzctU[i] = (aek)this.zzctU[i].clone();
                    }
                }
            }
        }
        catch (CloneNotSupportedException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
        if (this.zzctW != null) {
            aej.zzctW = (aeh)this.zzctW.clone();
        }
        if (this.zzcua != null) {
            aej.zzcua = (aeg)this.zzcua.clone();
        }
        if (this.zzcud != null) {
            aej.zzcud = (aei)this.zzcud.clone();
        }
        if (this.zzcuh != null && this.zzcuh.length > 0) {
            aej.zzcuh = this.zzcuh.clone();
        }
        if (this.zzcmX != null) {
            aej.zzcmX = (ael)this.zzcmX.clone();
        }
        return aej;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof aej)) {
                return false;
            }
            final aej aej = (aej)o;
            if (this.zzctQ != aej.zzctQ) {
                return false;
            }
            if (this.zzctR != aej.zzctR) {
                return false;
            }
            if (this.zzctS != aej.zzctS) {
                return false;
            }
            if (this.tag == null) {
                if (aej.tag != null) {
                    return false;
                }
            }
            else if (!this.tag.equals(aej.tag)) {
                return false;
            }
            if (this.zzctT != aej.zzctT) {
                return false;
            }
            if (this.zzrB != aej.zzrB) {
                return false;
            }
            if (this.zzccZ != aej.zzccZ) {
                return false;
            }
            if (!adn.equals(this.zzctU, aej.zzctU)) {
                return false;
            }
            if (!Arrays.equals(this.zzctV, aej.zzctV)) {
                return false;
            }
            if (this.zzctW == null) {
                if (aej.zzctW != null) {
                    return false;
                }
            }
            else if (!this.zzctW.equals(aej.zzctW)) {
                return false;
            }
            if (!Arrays.equals(this.zzctX, aej.zzctX)) {
                return false;
            }
            if (this.zzctY == null) {
                if (aej.zzctY != null) {
                    return false;
                }
            }
            else if (!this.zzctY.equals(aej.zzctY)) {
                return false;
            }
            if (this.zzctZ == null) {
                if (aej.zzctZ != null) {
                    return false;
                }
            }
            else if (!this.zzctZ.equals(aej.zzctZ)) {
                return false;
            }
            if (this.zzcua == null) {
                if (aej.zzcua != null) {
                    return false;
                }
            }
            else if (!this.zzcua.equals(aej.zzcua)) {
                return false;
            }
            if (this.zzcub == null) {
                if (aej.zzcub != null) {
                    return false;
                }
            }
            else if (!this.zzcub.equals(aej.zzcub)) {
                return false;
            }
            if (this.zzcuc != aej.zzcuc) {
                return false;
            }
            if (this.zzcud == null) {
                if (aej.zzcud != null) {
                    return false;
                }
            }
            else if (!this.zzcud.equals(aej.zzcud)) {
                return false;
            }
            if (!Arrays.equals(this.zzcue, aej.zzcue)) {
                return false;
            }
            if (this.zzcuf == null) {
                if (aej.zzcuf != null) {
                    return false;
                }
            }
            else if (!this.zzcuf.equals(aej.zzcuf)) {
                return false;
            }
            if (this.zzcug != aej.zzcug) {
                return false;
            }
            if (!adn.equals(this.zzcuh, aej.zzcuh)) {
                return false;
            }
            if (this.zzcui != aej.zzcui) {
                return false;
            }
            if (this.zzcmX == null) {
                if (aej.zzcmX != null) {
                    return false;
                }
            }
            else if (!this.zzcmX.equals(aej.zzcmX)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(aej.zzcso);
            }
            if (aej.zzcso != null && !aej.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        final int n2 = (int)(this.zzctQ ^ this.zzctQ >>> 32);
        final int n3 = (int)(this.zzctR ^ this.zzctR >>> 32);
        final int n4 = (int)(this.zzctS ^ this.zzctS >>> 32);
        int hashCode2;
        if (this.tag == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.tag.hashCode();
        }
        final int zzctT = this.zzctT;
        final int zzrB = this.zzrB;
        int n5;
        if (this.zzccZ) {
            n5 = 1231;
        }
        else {
            n5 = 1237;
        }
        final int hashCode3 = adn.hashCode(this.zzctU);
        final int hashCode4 = Arrays.hashCode(this.zzctV);
        int hashCode5;
        if (this.zzctW == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzctW.hashCode();
        }
        final int hashCode6 = Arrays.hashCode(this.zzctX);
        int hashCode7;
        if (this.zzctY == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = this.zzctY.hashCode();
        }
        int hashCode8;
        if (this.zzctZ == null) {
            hashCode8 = 0;
        }
        else {
            hashCode8 = this.zzctZ.hashCode();
        }
        int hashCode9;
        if (this.zzcua == null) {
            hashCode9 = 0;
        }
        else {
            hashCode9 = this.zzcua.hashCode();
        }
        int hashCode10;
        if (this.zzcub == null) {
            hashCode10 = 0;
        }
        else {
            hashCode10 = this.zzcub.hashCode();
        }
        final int n6 = (int)(this.zzcuc ^ this.zzcuc >>> 32);
        int hashCode11;
        if (this.zzcud == null) {
            hashCode11 = 0;
        }
        else {
            hashCode11 = this.zzcud.hashCode();
        }
        final int hashCode12 = Arrays.hashCode(this.zzcue);
        int hashCode13;
        if (this.zzcuf == null) {
            hashCode13 = 0;
        }
        else {
            hashCode13 = this.zzcuf.hashCode();
        }
        final int zzcug = this.zzcug;
        final int hashCode14 = adn.hashCode(this.zzcuh);
        final int n7 = (int)(this.zzcui ^ this.zzcui >>> 32);
        int hashCode15;
        if (this.zzcmX == null) {
            hashCode15 = 0;
        }
        else {
            hashCode15 = this.zzcmX.hashCode();
        }
        int hashCode16 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode16 = n;
            }
            else {
                hashCode16 = this.zzcso.hashCode();
            }
        }
        return (hashCode15 + ((((hashCode13 + ((hashCode11 + ((hashCode10 + (hashCode9 + (hashCode8 + (hashCode7 + ((hashCode5 + (((n5 + (((hashCode2 + ((((hashCode + 527) * 31 + n2) * 31 + n3) * 31 + n4) * 31) * 31 + zzctT) * 31 + zzrB) * 31) * 31 + hashCode3) * 31 + hashCode4) * 31) * 31 + hashCode6) * 31) * 31) * 31) * 31) * 31 + n6) * 31) * 31 + hashCode12) * 31) * 31 + zzcug) * 31 + hashCode14) * 31 + n7) * 31) * 31 + hashCode16;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzctQ != 0L) {
            adh.zzb(1, this.zzctQ);
        }
        if (this.tag != null && !this.tag.equals("")) {
            adh.zzl(2, this.tag);
        }
        if (this.zzctU != null && this.zzctU.length > 0) {
            for (int i = 0; i < this.zzctU.length; ++i) {
                final aek aek = this.zzctU[i];
                if (aek != null) {
                    adh.zza(3, aek);
                }
            }
        }
        if (!Arrays.equals(this.zzctV, ads.zzcsI)) {
            adh.zzb(4, this.zzctV);
        }
        if (!Arrays.equals(this.zzctX, ads.zzcsI)) {
            adh.zzb(6, this.zzctX);
        }
        if (this.zzcua != null) {
            adh.zza(7, this.zzcua);
        }
        if (this.zzctY != null && !this.zzctY.equals("")) {
            adh.zzl(8, this.zzctY);
        }
        if (this.zzctW != null) {
            adh.zza(9, this.zzctW);
        }
        if (this.zzccZ) {
            adh.zzk(10, this.zzccZ);
        }
        if (this.zzctT != 0) {
            adh.zzr(11, this.zzctT);
        }
        if (this.zzrB != 0) {
            adh.zzr(12, this.zzrB);
        }
        if (this.zzctZ != null && !this.zzctZ.equals("")) {
            adh.zzl(13, this.zzctZ);
        }
        if (this.zzcub != null && !this.zzcub.equals("")) {
            adh.zzl(14, this.zzcub);
        }
        if (this.zzcuc != 180000L) {
            adh.zzd(15, this.zzcuc);
        }
        if (this.zzcud != null) {
            adh.zza(16, this.zzcud);
        }
        if (this.zzctR != 0L) {
            adh.zzb(17, this.zzctR);
        }
        if (!Arrays.equals(this.zzcue, ads.zzcsI)) {
            adh.zzb(18, this.zzcue);
        }
        if (this.zzcug != 0) {
            adh.zzr(19, this.zzcug);
        }
        if (this.zzcuh != null && this.zzcuh.length > 0) {
            for (int j = n; j < this.zzcuh.length; ++j) {
                adh.zzr(20, this.zzcuh[j]);
            }
        }
        if (this.zzctS != 0L) {
            adh.zzb(21, this.zzctS);
        }
        if (this.zzcui != 0L) {
            adh.zzb(22, this.zzcui);
        }
        if (this.zzcmX != null) {
            adh.zza(23, this.zzcmX);
        }
        if (this.zzcuf != null && !this.zzcuf.equals("")) {
            adh.zzl(24, this.zzcuf);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        int zzn;
        final int n2 = zzn = super.zzn();
        if (this.zzctQ != 0L) {
            zzn = n2 + adh.zze(1, this.zzctQ);
        }
        int n3 = zzn;
        if (this.tag != null) {
            n3 = zzn;
            if (!this.tag.equals("")) {
                n3 = zzn + adh.zzm(2, this.tag);
            }
        }
        int n4 = n3;
        if (this.zzctU != null) {
            n4 = n3;
            if (this.zzctU.length > 0) {
                int n5;
                for (int i = 0; i < this.zzctU.length; ++i, n3 = n5) {
                    final aek aek = this.zzctU[i];
                    n5 = n3;
                    if (aek != null) {
                        n5 = n3 + adh.zzb(3, aek);
                    }
                }
                n4 = n3;
            }
        }
        int n6 = n4;
        if (!Arrays.equals(this.zzctV, ads.zzcsI)) {
            n6 = n4 + adh.zzc(4, this.zzctV);
        }
        int n7 = n6;
        if (!Arrays.equals(this.zzctX, ads.zzcsI)) {
            n7 = n6 + adh.zzc(6, this.zzctX);
        }
        int n8 = n7;
        if (this.zzcua != null) {
            n8 = n7 + adh.zzb(7, this.zzcua);
        }
        int n9 = n8;
        if (this.zzctY != null) {
            n9 = n8;
            if (!this.zzctY.equals("")) {
                n9 = n8 + adh.zzm(8, this.zzctY);
            }
        }
        int n10 = n9;
        if (this.zzctW != null) {
            n10 = n9 + adh.zzb(9, this.zzctW);
        }
        int n11 = n10;
        if (this.zzccZ) {
            n11 = n10 + (adh.zzct(10) + 1);
        }
        int n12 = n11;
        if (this.zzctT != 0) {
            n12 = n11 + adh.zzs(11, this.zzctT);
        }
        int n13 = n12;
        if (this.zzrB != 0) {
            n13 = n12 + adh.zzs(12, this.zzrB);
        }
        int n14 = n13;
        if (this.zzctZ != null) {
            n14 = n13;
            if (!this.zzctZ.equals("")) {
                n14 = n13 + adh.zzm(13, this.zzctZ);
            }
        }
        int n15 = n14;
        if (this.zzcub != null) {
            n15 = n14;
            if (!this.zzcub.equals("")) {
                n15 = n14 + adh.zzm(14, this.zzcub);
            }
        }
        int n16 = n15;
        if (this.zzcuc != 180000L) {
            n16 = n15 + adh.zzf(15, this.zzcuc);
        }
        int n17 = n16;
        if (this.zzcud != null) {
            n17 = n16 + adh.zzb(16, this.zzcud);
        }
        int n18 = n17;
        if (this.zzctR != 0L) {
            n18 = n17 + adh.zze(17, this.zzctR);
        }
        int n19 = n18;
        if (!Arrays.equals(this.zzcue, ads.zzcsI)) {
            n19 = n18 + adh.zzc(18, this.zzcue);
        }
        int n20 = n19;
        if (this.zzcug != 0) {
            n20 = n19 + adh.zzs(19, this.zzcug);
        }
        int n21 = n20;
        if (this.zzcuh != null) {
            n21 = n20;
            if (this.zzcuh.length > 0) {
                int n22 = 0;
                for (int j = n; j < this.zzcuh.length; ++j) {
                    n22 += adh.zzcr(this.zzcuh[j]);
                }
                n21 = n20 + n22 + this.zzcuh.length * 2;
            }
        }
        int n23 = n21;
        if (this.zzctS != 0L) {
            n23 = n21 + adh.zze(21, this.zzctS);
        }
        int n24 = n23;
        if (this.zzcui != 0L) {
            n24 = n23 + adh.zze(22, this.zzcui);
        }
        int n25 = n24;
        if (this.zzcmX != null) {
            n25 = n24 + adh.zzb(23, this.zzcmX);
        }
        int n26 = n25;
        if (this.zzcuf != null) {
            n26 = n25;
            if (!this.zzcuf.equals("")) {
                n26 = n25 + adh.zzm(24, this.zzcuf);
            }
        }
        return n26;
    }
}
