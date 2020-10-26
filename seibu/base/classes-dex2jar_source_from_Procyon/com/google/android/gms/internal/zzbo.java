// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbo extends adj<zzbo>
{
    private static volatile zzbo[] zzld;
    public int[] zzle;
    public int[] zzlf;
    public int[] zzlg;
    public int[] zzlh;
    public int[] zzli;
    public int[] zzlj;
    public int[] zzlk;
    public int[] zzll;
    public int[] zzlm;
    public int[] zzln;
    
    public zzbo() {
        this.zzle = ads.zzcsC;
        this.zzlf = ads.zzcsC;
        this.zzlg = ads.zzcsC;
        this.zzlh = ads.zzcsC;
        this.zzli = ads.zzcsC;
        this.zzlj = ads.zzcsC;
        this.zzlk = ads.zzcsC;
        this.zzll = ads.zzcsC;
        this.zzlm = ads.zzcsC;
        this.zzln = ads.zzcsC;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzbo[] zzs() {
        Label_0027: {
            if (zzbo.zzld != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzbo.zzld == null) {
                    zzbo.zzld = new zzbo[0];
                }
                return zzbo.zzld;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbo)) {
                return false;
            }
            final zzbo zzbo = (zzbo)o;
            if (!adn.equals(this.zzle, zzbo.zzle)) {
                return false;
            }
            if (!adn.equals(this.zzlf, zzbo.zzlf)) {
                return false;
            }
            if (!adn.equals(this.zzlg, zzbo.zzlg)) {
                return false;
            }
            if (!adn.equals(this.zzlh, zzbo.zzlh)) {
                return false;
            }
            if (!adn.equals(this.zzli, zzbo.zzli)) {
                return false;
            }
            if (!adn.equals(this.zzlj, zzbo.zzlj)) {
                return false;
            }
            if (!adn.equals(this.zzlk, zzbo.zzlk)) {
                return false;
            }
            if (!adn.equals(this.zzll, zzbo.zzll)) {
                return false;
            }
            if (!adn.equals(this.zzlm, zzbo.zzlm)) {
                return false;
            }
            if (!adn.equals(this.zzln, zzbo.zzln)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbo.zzcso);
            }
            if (zzbo.zzcso != null && !zzbo.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzle);
        final int hashCode3 = adn.hashCode(this.zzlf);
        final int hashCode4 = adn.hashCode(this.zzlg);
        final int hashCode5 = adn.hashCode(this.zzlh);
        final int hashCode6 = adn.hashCode(this.zzli);
        final int hashCode7 = adn.hashCode(this.zzlj);
        final int hashCode8 = adn.hashCode(this.zzlk);
        final int hashCode9 = adn.hashCode(this.zzll);
        final int hashCode10 = adn.hashCode(this.zzlm);
        final int hashCode11 = adn.hashCode(this.zzln);
        int hashCode12;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode12 = 0;
        }
        else {
            hashCode12 = this.zzcso.hashCode();
        }
        return hashCode12 + (((((((((((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8) * 31 + hashCode9) * 31 + hashCode10) * 31 + hashCode11) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzle != null && this.zzle.length > 0) {
            for (int i = 0; i < this.zzle.length; ++i) {
                adh.zzr(1, this.zzle[i]);
            }
        }
        if (this.zzlf != null && this.zzlf.length > 0) {
            for (int j = 0; j < this.zzlf.length; ++j) {
                adh.zzr(2, this.zzlf[j]);
            }
        }
        if (this.zzlg != null && this.zzlg.length > 0) {
            for (int k = 0; k < this.zzlg.length; ++k) {
                adh.zzr(3, this.zzlg[k]);
            }
        }
        if (this.zzlh != null && this.zzlh.length > 0) {
            for (int l = 0; l < this.zzlh.length; ++l) {
                adh.zzr(4, this.zzlh[l]);
            }
        }
        if (this.zzli != null && this.zzli.length > 0) {
            for (int n2 = 0; n2 < this.zzli.length; ++n2) {
                adh.zzr(5, this.zzli[n2]);
            }
        }
        if (this.zzlj != null && this.zzlj.length > 0) {
            for (int n3 = 0; n3 < this.zzlj.length; ++n3) {
                adh.zzr(6, this.zzlj[n3]);
            }
        }
        if (this.zzlk != null && this.zzlk.length > 0) {
            for (int n4 = 0; n4 < this.zzlk.length; ++n4) {
                adh.zzr(7, this.zzlk[n4]);
            }
        }
        if (this.zzll != null && this.zzll.length > 0) {
            for (int n5 = 0; n5 < this.zzll.length; ++n5) {
                adh.zzr(8, this.zzll[n5]);
            }
        }
        if (this.zzlm != null && this.zzlm.length > 0) {
            for (int n6 = 0; n6 < this.zzlm.length; ++n6) {
                adh.zzr(9, this.zzlm[n6]);
            }
        }
        if (this.zzln != null && this.zzln.length > 0) {
            for (int n7 = n; n7 < this.zzln.length; ++n7) {
                adh.zzr(10, this.zzln[n7]);
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        final int zzn = super.zzn();
        int n3;
        if (this.zzle != null && this.zzle.length > 0) {
            int i = 0;
            int n2 = 0;
            while (i < this.zzle.length) {
                n2 += adh.zzcr(this.zzle[i]);
                ++i;
            }
            n3 = zzn + n2 + this.zzle.length * 1;
        }
        else {
            n3 = zzn;
        }
        int n4 = n3;
        if (this.zzlf != null) {
            n4 = n3;
            if (this.zzlf.length > 0) {
                int j = 0;
                int n5 = 0;
                while (j < this.zzlf.length) {
                    n5 += adh.zzcr(this.zzlf[j]);
                    ++j;
                }
                n4 = n3 + n5 + this.zzlf.length * 1;
            }
        }
        int n6 = n4;
        if (this.zzlg != null) {
            n6 = n4;
            if (this.zzlg.length > 0) {
                int k = 0;
                int n7 = 0;
                while (k < this.zzlg.length) {
                    n7 += adh.zzcr(this.zzlg[k]);
                    ++k;
                }
                n6 = n4 + n7 + this.zzlg.length * 1;
            }
        }
        int n8 = n6;
        if (this.zzlh != null) {
            n8 = n6;
            if (this.zzlh.length > 0) {
                int l = 0;
                int n9 = 0;
                while (l < this.zzlh.length) {
                    n9 += adh.zzcr(this.zzlh[l]);
                    ++l;
                }
                n8 = n6 + n9 + this.zzlh.length * 1;
            }
        }
        int n10 = n8;
        if (this.zzli != null) {
            n10 = n8;
            if (this.zzli.length > 0) {
                int n11 = 0;
                int n12 = 0;
                while (n11 < this.zzli.length) {
                    n12 += adh.zzcr(this.zzli[n11]);
                    ++n11;
                }
                n10 = n8 + n12 + this.zzli.length * 1;
            }
        }
        int n13 = n10;
        if (this.zzlj != null) {
            n13 = n10;
            if (this.zzlj.length > 0) {
                int n14 = 0;
                int n15 = 0;
                while (n14 < this.zzlj.length) {
                    n15 += adh.zzcr(this.zzlj[n14]);
                    ++n14;
                }
                n13 = n10 + n15 + this.zzlj.length * 1;
            }
        }
        int n16 = n13;
        if (this.zzlk != null) {
            n16 = n13;
            if (this.zzlk.length > 0) {
                int n17 = 0;
                int n18 = 0;
                while (n17 < this.zzlk.length) {
                    n18 += adh.zzcr(this.zzlk[n17]);
                    ++n17;
                }
                n16 = n13 + n18 + this.zzlk.length * 1;
            }
        }
        int n19 = n16;
        if (this.zzll != null) {
            n19 = n16;
            if (this.zzll.length > 0) {
                int n20 = 0;
                int n21 = 0;
                while (n20 < this.zzll.length) {
                    n21 += adh.zzcr(this.zzll[n20]);
                    ++n20;
                }
                n19 = n16 + n21 + this.zzll.length * 1;
            }
        }
        int n22 = n19;
        if (this.zzlm != null) {
            n22 = n19;
            if (this.zzlm.length > 0) {
                int n23 = 0;
                int n24 = 0;
                while (n23 < this.zzlm.length) {
                    n24 += adh.zzcr(this.zzlm[n23]);
                    ++n23;
                }
                n22 = n19 + n24 + this.zzlm.length * 1;
            }
        }
        int n25 = n22;
        if (this.zzln != null) {
            n25 = n22;
            if (this.zzln.length > 0) {
                int n26 = 0;
                for (int n27 = n; n27 < this.zzln.length; ++n27) {
                    n26 += adh.zzcr(this.zzln[n27]);
                }
                n25 = n22 + n26 + this.zzln.length * 1;
            }
        }
        return n25;
    }
}
