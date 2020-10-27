package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwb extends zzecd<zzdwb, zza> implements zzedq {
    private static volatile zzedx<zzdwb> zzea;
    /* access modifiers changed from: private */
    public static final zzdwb zzhmg;
    private int zzhlh;
    private int zzhlm;

    public static final class zza extends zzecd.zza<zzdwb, zza> implements zzedq {
        private zza() {
            super(zzdwb.zzhmg);
        }

        /* synthetic */ zza(zzdwc zzdwc) {
            this();
        }
    }

    static {
        zzdwb zzdwb = new zzdwb();
        zzhmg = zzdwb;
        zzecd.zza(zzdwb.class, zzdwb);
    }

    private zzdwb() {
    }

    public static zzdwb zzk(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdwb) zzecd.zza(zzhmg, zzeaq, zzebq);
    }

    public final int getKeySize() {
        return this.zzhlm;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdwc.zzdk[i - 1]) {
            case 1:
                return new zzdwb();
            case 2:
                return new zza((zzdwc) null);
            case 3:
                return zzecd.zza((zzedo) zzhmg, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzhlm", "zzhlh"});
            case 4:
                return zzhmg;
            case 5:
                zzedx<zzdwb> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwb.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhmg);
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
