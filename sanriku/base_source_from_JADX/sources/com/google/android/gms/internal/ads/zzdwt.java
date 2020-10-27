package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwt extends zzecd<zzdwt, zza> implements zzedq {
    private static volatile zzedx<zzdwt> zzea;
    /* access modifiers changed from: private */
    public static final zzdwt zzhnf;
    private int zzhnc;
    private int zzhnd;
    private zzeaq zzhne = zzeaq.zzhtf;

    public static final class zza extends zzecd.zza<zzdwt, zza> implements zzedq {
        private zza() {
            super(zzdwt.zzhnf);
        }

        /* synthetic */ zza(zzdwu zzdwu) {
            this();
        }
    }

    static {
        zzdwt zzdwt = new zzdwt();
        zzhnf = zzdwt;
        zzecd.zza(zzdwt.class, zzdwt);
    }

    private zzdwt() {
    }

    public static zzdwt zzazs() {
        return zzhnf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdwu.zzdk[i - 1]) {
            case 1:
                return new zzdwt();
            case 2:
                return new zza((zzdwu) null);
            case 3:
                return zzecd.zza((zzedo) zzhnf, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzhnc", "zzhnd", "zzhne"});
            case 4:
                return zzhnf;
            case 5:
                zzedx<zzdwt> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwt.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhnf);
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

    public final zzdww zzazp() {
        zzdww zzev = zzdww.zzev(this.zzhnc);
        return zzev == null ? zzdww.UNRECOGNIZED : zzev;
    }

    public final zzdwy zzazq() {
        zzdwy zzew = zzdwy.zzew(this.zzhnd);
        return zzew == null ? zzdwy.UNRECOGNIZED : zzew;
    }

    public final zzeaq zzazr() {
        return this.zzhne;
    }
}
