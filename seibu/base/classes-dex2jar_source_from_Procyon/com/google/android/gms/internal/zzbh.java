// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public interface zzbh
{
    public static final class zza extends adj<zza>
    {
        public static final adk<zzbr, zza> zzlo;
        private static final zza[] zzlp;
        public int[] zzlq;
        public int[] zzlr;
        public int[] zzls;
        private int zzlt;
        public int[] zzlu;
        public int zzlv;
        private int zzlw;
        
        static {
            zzlo = adk.zza(11, zza.class, 810L);
            zzlp = new zza[0];
        }
        
        public zza() {
            this.zzlq = ads.zzcsC;
            this.zzlr = ads.zzcsC;
            this.zzls = ads.zzcsC;
            this.zzlt = 0;
            this.zzlu = ads.zzcsC;
            this.zzlv = 0;
            this.zzlw = 0;
            this.zzcso = null;
            this.zzcsx = -1;
        }
        
        @Override
        public final boolean equals(final Object o) {
            if (o != this) {
                if (!(o instanceof zza)) {
                    return false;
                }
                final zza zza = (zza)o;
                if (!adn.equals(this.zzlq, zza.zzlq)) {
                    return false;
                }
                if (!adn.equals(this.zzlr, zza.zzlr)) {
                    return false;
                }
                if (!adn.equals(this.zzls, zza.zzls)) {
                    return false;
                }
                if (this.zzlt != zza.zzlt) {
                    return false;
                }
                if (!adn.equals(this.zzlu, zza.zzlu)) {
                    return false;
                }
                if (this.zzlv != zza.zzlv) {
                    return false;
                }
                if (this.zzlw != zza.zzlw) {
                    return false;
                }
                if (this.zzcso != null && !this.zzcso.isEmpty()) {
                    return this.zzcso.equals(zza.zzcso);
                }
                if (zza.zzcso != null && !zza.zzcso.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public final int hashCode() {
            final int hashCode = this.getClass().getName().hashCode();
            final int hashCode2 = adn.hashCode(this.zzlq);
            final int hashCode3 = adn.hashCode(this.zzlr);
            final int hashCode4 = adn.hashCode(this.zzls);
            final int zzlt = this.zzlt;
            final int hashCode5 = adn.hashCode(this.zzlu);
            final int zzlv = this.zzlv;
            final int zzlw = this.zzlw;
            int hashCode6;
            if (this.zzcso == null || this.zzcso.isEmpty()) {
                hashCode6 = 0;
            }
            else {
                hashCode6 = this.zzcso.hashCode();
            }
            return hashCode6 + ((((((((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + zzlt) * 31 + hashCode5) * 31 + zzlv) * 31 + zzlw) * 31;
        }
        
        @Override
        public final void zza(final adh adh) throws IOException {
            final int n = 0;
            if (this.zzlq != null && this.zzlq.length > 0) {
                for (int i = 0; i < this.zzlq.length; ++i) {
                    adh.zzr(1, this.zzlq[i]);
                }
            }
            if (this.zzlr != null && this.zzlr.length > 0) {
                for (int j = 0; j < this.zzlr.length; ++j) {
                    adh.zzr(2, this.zzlr[j]);
                }
            }
            if (this.zzls != null && this.zzls.length > 0) {
                for (int k = 0; k < this.zzls.length; ++k) {
                    adh.zzr(3, this.zzls[k]);
                }
            }
            if (this.zzlt != 0) {
                adh.zzr(4, this.zzlt);
            }
            if (this.zzlu != null && this.zzlu.length > 0) {
                for (int l = n; l < this.zzlu.length; ++l) {
                    adh.zzr(5, this.zzlu[l]);
                }
            }
            if (this.zzlv != 0) {
                adh.zzr(6, this.zzlv);
            }
            if (this.zzlw != 0) {
                adh.zzr(7, this.zzlw);
            }
            super.zza(adh);
        }
        
        @Override
        protected final int zzn() {
            final int n = 0;
            final int zzn = super.zzn();
            int n3;
            if (this.zzlq != null && this.zzlq.length > 0) {
                int i = 0;
                int n2 = 0;
                while (i < this.zzlq.length) {
                    n2 += adh.zzcr(this.zzlq[i]);
                    ++i;
                }
                n3 = zzn + n2 + this.zzlq.length * 1;
            }
            else {
                n3 = zzn;
            }
            int n4 = n3;
            if (this.zzlr != null) {
                n4 = n3;
                if (this.zzlr.length > 0) {
                    int j = 0;
                    int n5 = 0;
                    while (j < this.zzlr.length) {
                        n5 += adh.zzcr(this.zzlr[j]);
                        ++j;
                    }
                    n4 = n3 + n5 + this.zzlr.length * 1;
                }
            }
            int n6 = n4;
            if (this.zzls != null) {
                n6 = n4;
                if (this.zzls.length > 0) {
                    int k = 0;
                    int n7 = 0;
                    while (k < this.zzls.length) {
                        n7 += adh.zzcr(this.zzls[k]);
                        ++k;
                    }
                    n6 = n4 + n7 + this.zzls.length * 1;
                }
            }
            int n8 = n6;
            if (this.zzlt != 0) {
                n8 = n6 + adh.zzs(4, this.zzlt);
            }
            int n9 = n8;
            if (this.zzlu != null) {
                n9 = n8;
                if (this.zzlu.length > 0) {
                    int n10 = 0;
                    for (int l = n; l < this.zzlu.length; ++l) {
                        n10 += adh.zzcr(this.zzlu[l]);
                    }
                    n9 = n8 + n10 + this.zzlu.length * 1;
                }
            }
            int n11 = n9;
            if (this.zzlv != 0) {
                n11 = n9 + adh.zzs(6, this.zzlv);
            }
            int n12 = n11;
            if (this.zzlw != 0) {
                n12 = n11 + adh.zzs(7, this.zzlw);
            }
            return n12;
        }
    }
}
