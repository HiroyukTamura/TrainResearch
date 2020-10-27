package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdvx extends zzecd<zzdvx, zza> implements zzedq {
    private static volatile zzedx<zzdvx> zzea;
    /* access modifiers changed from: private */
    public static final zzdvx zzhme;
    private int zzhlz;

    public static final class zza extends zzecd.zza<zzdvx, zza> implements zzedq {
        private zza() {
            super(zzdvx.zzhme);
        }

        /* synthetic */ zza(zzdvy zzdvy) {
            this();
        }
    }

    static {
        zzdvx zzdvx = new zzdvx();
        zzhme = zzdvx;
        zzecd.zza(zzdvx.class, zzdvx);
    }

    private zzdvx() {
    }

    public static zzdvx zzayp() {
        return zzhme;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvy.zzdk[i - 1]) {
            case 1:
                return new zzdvx();
            case 2:
                return new zza((zzdvy) null);
            case 3:
                return zzecd.zza((zzedo) zzhme, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhlz"});
            case 4:
                return zzhme;
            case 5:
                zzedx<zzdvx> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdvx.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhme);
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

    public final int zzayi() {
        return this.zzhlz;
    }
}
