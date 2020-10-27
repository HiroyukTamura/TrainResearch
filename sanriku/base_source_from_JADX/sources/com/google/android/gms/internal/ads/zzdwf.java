package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwf extends zzecd<zzdwf, zza> implements zzedq {
    private static volatile zzedx<zzdwf> zzea;
    /* access modifiers changed from: private */
    public static final zzdwf zzhmi;

    public static final class zza extends zzecd.zza<zzdwf, zza> implements zzedq {
        private zza() {
            super(zzdwf.zzhmi);
        }

        /* synthetic */ zza(zzdwg zzdwg) {
            this();
        }
    }

    static {
        zzdwf zzdwf = new zzdwf();
        zzhmi = zzdwf;
        zzecd.zza(zzdwf.class, zzdwf);
    }

    private zzdwf() {
    }

    public static zzdwf zzm(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdwf) zzecd.zza(zzhmi, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdwg.zzdk[i - 1]) {
            case 1:
                return new zzdwf();
            case 2:
                return new zza((zzdwg) null);
            case 3:
                return zzecd.zza((zzedo) zzhmi, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhmi;
            case 5:
                zzedx<zzdwf> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwf.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhmi);
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
}
