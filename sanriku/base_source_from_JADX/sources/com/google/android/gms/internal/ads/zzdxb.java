package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdxb extends zzecd<zzdxb, zza> implements zzedq {
    private static volatile zzedx<zzdxb> zzea;
    /* access modifiers changed from: private */
    public static final zzdxb zzhnw;
    private int zzhlh;
    private int zzhlm;
    private zzdxe zzhnu;

    public static final class zza extends zzecd.zza<zzdxb, zza> implements zzedq {
        private zza() {
            super(zzdxb.zzhnw);
        }

        /* synthetic */ zza(zzdxc zzdxc) {
            this();
        }
    }

    static {
        zzdxb zzdxb = new zzdxb();
        zzhnw = zzdxb;
        zzecd.zza(zzdxb.class, zzdxb);
    }

    private zzdxb() {
    }

    public static zzdxb zzazy() {
        return zzhnw;
    }

    public static zzdxb zzr(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdxb) zzecd.zza(zzhnw, zzeaq, zzebq);
    }

    public final int getKeySize() {
        return this.zzhlm;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxc.zzdk[i - 1]) {
            case 1:
                return new zzdxb();
            case 2:
                return new zza((zzdxc) null);
            case 3:
                return zzecd.zza((zzedo) zzhnw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzhnu", "zzhlm", "zzhlh"});
            case 4:
                return zzhnw;
            case 5:
                zzedx<zzdxb> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxb.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhnw);
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

    public final zzdxe zzazu() {
        zzdxe zzdxe = this.zzhnu;
        return zzdxe == null ? zzdxe.zzbab() : zzdxe;
    }
}
