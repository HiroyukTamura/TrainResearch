package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdyh extends zzecd<zzdyh, zza> implements zzedq {
    private static volatile zzedx<zzdyh> zzea;
    /* access modifiers changed from: private */
    public static final zzdyh zzhqb;

    public static final class zza extends zzecd.zza<zzdyh, zza> implements zzedq {
        private zza() {
            super(zzdyh.zzhqb);
        }

        /* synthetic */ zza(zzdyg zzdyg) {
            this();
        }
    }

    static {
        zzdyh zzdyh = new zzdyh();
        zzhqb = zzdyh;
        zzecd.zza(zzdyh.class, zzdyh);
    }

    private zzdyh() {
    }

    public static zzdyh zzx(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdyh) zzecd.zza(zzhqb, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdyg.zzdk[i - 1]) {
            case 1:
                return new zzdyh();
            case 2:
                return new zza((zzdyg) null);
            case 3:
                return zzecd.zza((zzedo) zzhqb, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhqb;
            case 5:
                zzedx<zzdyh> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdyh.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhqb);
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
