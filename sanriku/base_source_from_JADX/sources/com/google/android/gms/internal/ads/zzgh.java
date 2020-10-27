package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzgh extends zzecd<zzgh, zza> implements zzedq {
    /* access modifiers changed from: private */
    public static final zzgh zzabs;
    private static volatile zzedx<zzgh> zzea;
    private String zzabn = "";
    private String zzabo = "";
    private long zzabp;
    private long zzabq;
    private long zzabr;
    private int zzdl;

    public static final class zza extends zzecd.zza<zzgh, zza> implements zzedq {
        private zza() {
            super(zzgh.zzabs);
        }

        /* synthetic */ zza(zzgg zzgg) {
            this();
        }

        public final zza zzau(String str) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzgh) this.zzhxt).zzas(str);
            return this;
        }

        public final zza zzav(String str) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzgh) this.zzhxt).zzat(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzgh) this.zzhxt).zzdg(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzgh) this.zzhxt).zzdh(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzgh) this.zzhxt).zzdi(j);
            return this;
        }
    }

    static {
        zzgh zzgh = new zzgh();
        zzabs = zzgh;
        zzecd.zza(zzgh.class, zzgh);
    }

    private zzgh() {
    }

    /* access modifiers changed from: private */
    public final void zzas(String str) {
        str.getClass();
        this.zzdl |= 1;
        this.zzabn = str;
    }

    /* access modifiers changed from: private */
    public final void zzat(String str) {
        str.getClass();
        this.zzdl |= 2;
        this.zzabo = str;
    }

    /* access modifiers changed from: private */
    public final void zzdg(long j) {
        this.zzdl |= 4;
        this.zzabp = j;
    }

    /* access modifiers changed from: private */
    public final void zzdh(long j) {
        this.zzdl |= 8;
        this.zzabq = j;
    }

    /* access modifiers changed from: private */
    public final void zzdi(long j) {
        this.zzdl |= 16;
        this.zzabr = j;
    }

    public static zza zzdm() {
        return (zza) zzabs.zzbev();
    }

    public static zzgh zzdn() {
        return zzabs;
    }

    public static zzgh zzl(zzeaq zzeaq) throws zzeco {
        return (zzgh) zzecd.zza(zzabs, zzeaq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgg.zzdk[i - 1]) {
            case 1:
                return new zzgh();
            case 2:
                return new zza((zzgg) null);
            case 3:
                return zzecd.zza((zzedo) zzabs, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0003\u0002\u0004\u0003\u0003\u0005\u0003\u0004", new Object[]{"zzdl", "zzabn", "zzabo", "zzabp", "zzabq", "zzabr"});
            case 4:
                return zzabs;
            case 5:
                zzedx<zzgh> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzgh.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzabs);
                            zzea = zzedx;
                        }
                    }
                }
                return zzedx;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final String zzdh() {
        return this.zzabn;
    }

    public final String zzdi() {
        return this.zzabo;
    }

    public final long zzdj() {
        return this.zzabp;
    }

    public final long zzdk() {
        return this.zzabq;
    }

    public final long zzdl() {
        return this.zzabr;
    }
}
