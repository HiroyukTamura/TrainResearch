package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdvg extends zzecd<zzdvg, zza> implements zzedq {
    private static volatile zzedx<zzdvg> zzea;
    /* access modifiers changed from: private */
    public static final zzdvg zzhln;
    private zzdvh zzhlj;
    private int zzhlm;

    public static final class zza extends zzecd.zza<zzdvg, zza> implements zzedq {
        private zza() {
            super(zzdvg.zzhln);
        }

        /* synthetic */ zza(zzdvf zzdvf) {
            this();
        }
    }

    static {
        zzdvg zzdvg = new zzdvg();
        zzhln = zzdvg;
        zzecd.zza(zzdvg.class, zzdvg);
    }

    private zzdvg() {
    }

    public static zzdvg zzc(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdvg) zzecd.zza(zzhln, zzeaq, zzebq);
    }

    public final int getKeySize() {
        return this.zzhlm;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvf.zzdk[i - 1]) {
            case 1:
                return new zzdvg();
            case 2:
                return new zza((zzdvf) null);
            case 3:
                return zzecd.zza((zzedo) zzhln, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhlm", "zzhlj"});
            case 4:
                return zzhln;
            case 5:
                zzedx<zzdvg> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdvg.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhln);
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

    public final zzdvh zzaxo() {
        zzdvh zzdvh = this.zzhlj;
        return zzdvh == null ? zzdvh.zzaxt() : zzdvh;
    }
}
