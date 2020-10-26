// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class aen extends adp
{
    public long zzaLt;
    public String zzcun;
    public String zzcuo;
    public long zzcup;
    public String zzcuq;
    public long zzcur;
    public String zzcus;
    public String zzcut;
    public String zzcuu;
    public String zzcuv;
    public String zzcuw;
    public int zzcux;
    public aem[] zzcuy;
    
    public aen() {
        this.zzcun = "";
        this.zzcuo = "";
        this.zzcup = 0L;
        this.zzcuq = "";
        this.zzcur = 0L;
        this.zzaLt = 0L;
        this.zzcus = "";
        this.zzcut = "";
        this.zzcuu = "";
        this.zzcuv = "";
        this.zzcuw = "";
        this.zzcux = 0;
        this.zzcuy = aem.zzMh();
        this.zzcsx = -1;
    }
    
    public static aen zzL(final byte[] array) throws ado {
        return adp.zza(new aen(), array);
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzcun != null && !this.zzcun.equals("")) {
            adh.zzl(1, this.zzcun);
        }
        if (this.zzcuo != null && !this.zzcuo.equals("")) {
            adh.zzl(2, this.zzcuo);
        }
        if (this.zzcup != 0L) {
            adh.zzb(3, this.zzcup);
        }
        if (this.zzcuq != null && !this.zzcuq.equals("")) {
            adh.zzl(4, this.zzcuq);
        }
        if (this.zzcur != 0L) {
            adh.zzb(5, this.zzcur);
        }
        if (this.zzaLt != 0L) {
            adh.zzb(6, this.zzaLt);
        }
        if (this.zzcus != null && !this.zzcus.equals("")) {
            adh.zzl(7, this.zzcus);
        }
        if (this.zzcut != null && !this.zzcut.equals("")) {
            adh.zzl(8, this.zzcut);
        }
        if (this.zzcuu != null && !this.zzcuu.equals("")) {
            adh.zzl(9, this.zzcuu);
        }
        if (this.zzcuv != null && !this.zzcuv.equals("")) {
            adh.zzl(10, this.zzcuv);
        }
        if (this.zzcuw != null && !this.zzcuw.equals("")) {
            adh.zzl(11, this.zzcuw);
        }
        if (this.zzcux != 0) {
            adh.zzr(12, this.zzcux);
        }
        if (this.zzcuy != null && this.zzcuy.length > 0) {
            for (int i = 0; i < this.zzcuy.length; ++i) {
                final aem aem = this.zzcuy[i];
                if (aem != null) {
                    adh.zza(13, aem);
                }
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzcun != null) {
            zzn = n;
            if (!this.zzcun.equals("")) {
                zzn = n + adh.zzm(1, this.zzcun);
            }
        }
        int n2 = zzn;
        if (this.zzcuo != null) {
            n2 = zzn;
            if (!this.zzcuo.equals("")) {
                n2 = zzn + adh.zzm(2, this.zzcuo);
            }
        }
        int n3 = n2;
        if (this.zzcup != 0L) {
            n3 = n2 + adh.zze(3, this.zzcup);
        }
        int n4 = n3;
        if (this.zzcuq != null) {
            n4 = n3;
            if (!this.zzcuq.equals("")) {
                n4 = n3 + adh.zzm(4, this.zzcuq);
            }
        }
        int n5 = n4;
        if (this.zzcur != 0L) {
            n5 = n4 + adh.zze(5, this.zzcur);
        }
        int n6 = n5;
        if (this.zzaLt != 0L) {
            n6 = n5 + adh.zze(6, this.zzaLt);
        }
        int n7 = n6;
        if (this.zzcus != null) {
            n7 = n6;
            if (!this.zzcus.equals("")) {
                n7 = n6 + adh.zzm(7, this.zzcus);
            }
        }
        int n8 = n7;
        if (this.zzcut != null) {
            n8 = n7;
            if (!this.zzcut.equals("")) {
                n8 = n7 + adh.zzm(8, this.zzcut);
            }
        }
        int n9 = n8;
        if (this.zzcuu != null) {
            n9 = n8;
            if (!this.zzcuu.equals("")) {
                n9 = n8 + adh.zzm(9, this.zzcuu);
            }
        }
        int n10 = n9;
        if (this.zzcuv != null) {
            n10 = n9;
            if (!this.zzcuv.equals("")) {
                n10 = n9 + adh.zzm(10, this.zzcuv);
            }
        }
        int n11 = n10;
        if (this.zzcuw != null) {
            n11 = n10;
            if (!this.zzcuw.equals("")) {
                n11 = n10 + adh.zzm(11, this.zzcuw);
            }
        }
        int n12 = n11;
        if (this.zzcux != 0) {
            n12 = n11 + adh.zzs(12, this.zzcux);
        }
        int n13 = n12;
        if (this.zzcuy != null) {
            n13 = n12;
            if (this.zzcuy.length > 0) {
                int n14;
                for (int i = 0; i < this.zzcuy.length; ++i, n12 = n14) {
                    final aem aem = this.zzcuy[i];
                    n14 = n12;
                    if (aem != null) {
                        n14 = n12 + adh.zzb(13, aem);
                    }
                }
                n13 = n12;
            }
        }
        return n13;
    }
}
