package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwl extends zzecd<zzdwl, zza> implements zzedq {
    private static volatile zzedx<zzdwl> zzea;
    /* access modifiers changed from: private */
    public static final zzdwl zzhms;
    private zzdwo zzhmr;

    public static final class zza extends zzecd.zza<zzdwl, zza> implements zzedq {
        private zza() {
            super(zzdwl.zzhms);
        }

        /* synthetic */ zza(zzdwm zzdwm) {
            this();
        }
    }

    static {
        zzdwl zzdwl = new zzdwl();
        zzhms = zzdwl;
        zzecd.zza(zzdwl.class, zzdwl);
    }

    private zzdwl() {
    }

    public static zzdwl zzn(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdwl) zzecd.zza(zzhms, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdwm.zzdk[i - 1]) {
            case 1:
                return new zzdwl();
            case 2:
                return new zza((zzdwm) null);
            case 3:
                return zzecd.zza((zzedo) zzhms, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzhmr"});
            case 4:
                return zzhms;
            case 5:
                zzedx<zzdwl> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwl.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhms);
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

    public final zzdwo zzaza() {
        zzdwo zzdwo = this.zzhmr;
        return zzdwo == null ? zzdwo.zzazf() : zzdwo;
    }
}
