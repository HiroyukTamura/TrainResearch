package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzgd extends zzecd<zzgd, zza> implements zzedq {
    /* access modifiers changed from: private */
    public static final zzgd zzabm;
    private static volatile zzedx<zzgd> zzea;
    private zzgh zzabj;
    private zzeaq zzabk;
    private zzeaq zzabl;
    private int zzdl;

    public static final class zza extends zzecd.zza<zzgd, zza> implements zzedq {
        private zza() {
            super(zzgd.zzabm);
        }

        /* synthetic */ zza(zzgf zzgf) {
            this();
        }
    }

    static {
        zzgd zzgd = new zzgd();
        zzabm = zzgd;
        zzecd.zza(zzgd.class, zzgd);
    }

    private zzgd() {
        zzeaq zzeaq = zzeaq.zzhtf;
        this.zzabk = zzeaq;
        this.zzabl = zzeaq;
    }

    public static zzgd zza(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzgd) zzecd.zza(zzabm, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgf.zzdk[i - 1]) {
            case 1:
                return new zzgd();
            case 2:
                return new zza((zzgf) null);
            case 3:
                return zzecd.zza((zzedo) zzabm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzabj", "zzabk", "zzabl"});
            case 4:
                return zzabm;
            case 5:
                zzedx<zzgd> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzgd.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzabm);
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

    public final zzgh zzdd() {
        zzgh zzgh = this.zzabj;
        return zzgh == null ? zzgh.zzdn() : zzgh;
    }

    public final zzeaq zzde() {
        return this.zzabk;
    }

    public final zzeaq zzdf() {
        return this.zzabl;
    }
}
