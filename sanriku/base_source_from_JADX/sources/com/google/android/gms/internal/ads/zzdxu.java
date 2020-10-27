package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdxu extends zzecd<zzdxu, zza> implements zzedq {
    private static volatile zzedx<zzdxu> zzea;
    /* access modifiers changed from: private */
    public static final zzdxu zzhpk;
    private String zzhpj = "";

    public static final class zza extends zzecd.zza<zzdxu, zza> implements zzedq {
        private zza() {
            super(zzdxu.zzhpk);
        }

        /* synthetic */ zza(zzdxv zzdxv) {
            this();
        }
    }

    static {
        zzdxu zzdxu = new zzdxu();
        zzhpk = zzdxu;
        zzecd.zza(zzdxu.class, zzdxu);
    }

    private zzdxu() {
    }

    public static zzdxu zzbbg() {
        return zzhpk;
    }

    public static zzdxu zzt(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdxu) zzecd.zza(zzhpk, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxv.zzdk[i - 1]) {
            case 1:
                return new zzdxu();
            case 2:
                return new zza((zzdxv) null);
            case 3:
                return zzecd.zza((zzedo) zzhpk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzhpj"});
            case 4:
                return zzhpk;
            case 5:
                zzedx<zzdxu> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxu.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhpk);
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

    public final String zzbbf() {
        return this.zzhpj;
    }
}
