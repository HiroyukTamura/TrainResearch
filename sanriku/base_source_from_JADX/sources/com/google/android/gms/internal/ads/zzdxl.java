package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdxl extends zzecd<zzdxl, zza> implements zzedq {
    private static volatile zzedx<zzdxl> zzea;
    /* access modifiers changed from: private */
    public static final zzdxl zzhor;
    private String zzhnz = "";
    private zzeaq zzhoa = zzeaq.zzhtf;
    private int zzhoq;

    public static final class zza extends zzecd.zza<zzdxl, zza> implements zzedq {
        private zza() {
            super(zzdxl.zzhor);
        }

        /* synthetic */ zza(zzdxk zzdxk) {
            this();
        }
    }

    static {
        zzdxl zzdxl = new zzdxl();
        zzhor = zzdxl;
        zzecd.zza(zzdxl.class, zzdxl);
    }

    private zzdxl() {
    }

    public static zzdxl zzbaj() {
        return zzhor;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxk.zzdk[i - 1]) {
            case 1:
                return new zzdxl();
            case 2:
                return new zza((zzdxk) null);
            case 3:
                return zzecd.zza((zzedo) zzhor, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhnz", "zzhoa", "zzhoq"});
            case 4:
                return zzhor;
            case 5:
                zzedx<zzdxl> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxl.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhor);
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

    public final String zzbad() {
        return this.zzhnz;
    }

    public final zzeaq zzbae() {
        return this.zzhoa;
    }
}
