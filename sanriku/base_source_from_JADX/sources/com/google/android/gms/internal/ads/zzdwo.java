package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwo extends zzecd<zzdwo, zza> implements zzedq {
    private static volatile zzedx<zzdwo> zzea;
    /* access modifiers changed from: private */
    public static final zzdwo zzhmw;
    private zzdwt zzhmt;
    private zzdwk zzhmu;
    private int zzhmv;

    public static final class zza extends zzecd.zza<zzdwo, zza> implements zzedq {
        private zza() {
            super(zzdwo.zzhmw);
        }

        /* synthetic */ zza(zzdwn zzdwn) {
            this();
        }
    }

    static {
        zzdwo zzdwo = new zzdwo();
        zzhmw = zzdwo;
        zzecd.zza(zzdwo.class, zzdwo);
    }

    private zzdwo() {
    }

    public static zzdwo zzazf() {
        return zzhmw;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdwn.zzdk[i - 1]) {
            case 1:
                return new zzdwo();
            case 2:
                return new zza((zzdwn) null);
            case 3:
                return zzecd.zza((zzedo) zzhmw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzhmt", "zzhmu", "zzhmv"});
            case 4:
                return zzhmw;
            case 5:
                zzedx<zzdwo> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwo.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhmw);
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

    public final zzdwt zzazc() {
        zzdwt zzdwt = this.zzhmt;
        return zzdwt == null ? zzdwt.zzazs() : zzdwt;
    }

    public final zzdwk zzazd() {
        zzdwk zzdwk = this.zzhmu;
        return zzdwk == null ? zzdwk.zzayy() : zzdwk;
    }

    public final zzdwi zzaze() {
        zzdwi zzes = zzdwi.zzes(this.zzhmv);
        return zzes == null ? zzdwi.UNRECOGNIZED : zzes;
    }
}
