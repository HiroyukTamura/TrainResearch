package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdxy extends zzecd<zzdxy, zza> implements zzedq {
    private static volatile zzedx<zzdxy> zzea;
    /* access modifiers changed from: private */
    public static final zzdxy zzhpp;
    private String zzhpn = "";
    private zzdxl zzhpo;

    public static final class zza extends zzecd.zza<zzdxy, zza> implements zzedq {
        private zza() {
            super(zzdxy.zzhpp);
        }

        /* synthetic */ zza(zzdxz zzdxz) {
            this();
        }
    }

    static {
        zzdxy zzdxy = new zzdxy();
        zzhpp = zzdxy;
        zzecd.zza(zzdxy.class, zzdxy);
    }

    private zzdxy() {
    }

    public static zzdxy zzbbn() {
        return zzhpp;
    }

    public static zzdxy zzv(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdxy) zzecd.zza(zzhpp, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxz.zzdk[i - 1]) {
            case 1:
                return new zzdxy();
            case 2:
                return new zza((zzdxz) null);
            case 3:
                return zzecd.zza((zzedo) zzhpp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzhpn", "zzhpo"});
            case 4:
                return zzhpp;
            case 5:
                zzedx<zzdxy> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxy.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhpp);
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

    public final String zzbbl() {
        return this.zzhpn;
    }

    public final zzdxl zzbbm() {
        zzdxl zzdxl = this.zzhpo;
        return zzdxl == null ? zzdxl.zzbaj() : zzdxl;
    }
}
