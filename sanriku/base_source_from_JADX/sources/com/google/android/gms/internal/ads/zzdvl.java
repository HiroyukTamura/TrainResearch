package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdvl extends zzecd<zzdvl, zza> implements zzedq {
    private static volatile zzedx<zzdvl> zzea;
    /* access modifiers changed from: private */
    public static final zzdvl zzhlv;
    private zzdvp zzhlt;
    private zzdxb zzhlu;

    public static final class zza extends zzecd.zza<zzdvl, zza> implements zzedq {
        private zza() {
            super(zzdvl.zzhlv);
        }

        /* synthetic */ zza(zzdvm zzdvm) {
            this();
        }
    }

    static {
        zzdvl zzdvl = new zzdvl();
        zzhlv = zzdvl;
        zzecd.zza(zzdvl.class, zzdvl);
    }

    private zzdvl() {
    }

    public static zzdvl zze(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdvl) zzecd.zza(zzhlv, zzeaq, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdvm.zzdk[i - 1]) {
            case 1:
                return new zzdvl();
            case 2:
                return new zza((zzdvm) null);
            case 3:
                return zzecd.zza((zzedo) zzhlv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzhlt", "zzhlu"});
            case 4:
                return zzhlv;
            case 5:
                zzedx<zzdvl> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdvl.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhlv);
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

    public final zzdvp zzaxz() {
        zzdvp zzdvp = this.zzhlt;
        return zzdvp == null ? zzdvp.zzayg() : zzdvp;
    }

    public final zzdxb zzaya() {
        zzdxb zzdxb = this.zzhlu;
        return zzdxb == null ? zzdxb.zzazy() : zzdxb;
    }
}
