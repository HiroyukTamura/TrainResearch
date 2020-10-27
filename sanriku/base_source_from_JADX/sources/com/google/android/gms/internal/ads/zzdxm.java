package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

@Deprecated
public final class zzdxm extends zzecd<zzdxm, zza> implements zzedq {
    private static volatile zzedx<zzdxm> zzea;
    /* access modifiers changed from: private */
    public static final zzdxm zzhow;
    private String zzhnz = "";
    private String zzhos = "";
    private int zzhot;
    private boolean zzhou;
    private String zzhov = "";

    public static final class zza extends zzecd.zza<zzdxm, zza> implements zzedq {
        private zza() {
            super(zzdxm.zzhow);
        }

        /* synthetic */ zza(zzdxn zzdxn) {
            this();
        }
    }

    static {
        zzdxm zzdxm = new zzdxm();
        zzhow = zzdxm;
        zzecd.zza(zzdxm.class, zzdxm);
    }

    private zzdxm() {
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxn.zzdk[i - 1]) {
            case 1:
                return new zzdxm();
            case 2:
                return new zza((zzdxn) null);
            case 3:
                return zzecd.zza((zzedo) zzhow, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzhos", "zzhnz", "zzhot", "zzhou", "zzhov"});
            case 4:
                return zzhow;
            case 5:
                zzedx<zzdxm> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxm.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhow);
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

    public final String zzbal() {
        return this.zzhos;
    }

    public final int zzbam() {
        return this.zzhot;
    }

    public final boolean zzban() {
        return this.zzhou;
    }

    public final String zzbao() {
        return this.zzhov;
    }
}
