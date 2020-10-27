package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwp extends zzecd<zzdwp, zza> implements zzedq {
    private static volatile zzedx<zzdwp> zzea;
    /* access modifiers changed from: private */
    public static final zzdwp zzhmy;
    private int zzhlh;
    private zzeaq zzhli = zzeaq.zzhtf;
    private zzdws zzhmx;

    public static final class zza extends zzecd.zza<zzdwp, zza> implements zzedq {
        private zza() {
            super(zzdwp.zzhmy);
        }

        /* synthetic */ zza(zzdwq zzdwq) {
            this();
        }

        public final zza zzb(zzdws zzdws) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdwp) this.zzhxt).zza(zzdws);
            return this;
        }

        public final zza zzet(int i) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdwp) this.zzhxt).setVersion(0);
            return this;
        }

        public final zza zzy(zzeaq zzeaq) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdwp) this.zzhxt).zzs(zzeaq);
            return this;
        }
    }

    static {
        zzdwp zzdwp = new zzdwp();
        zzhmy = zzdwp;
        zzecd.zza(zzdwp.class, zzdwp);
    }

    private zzdwp() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhlh = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdws zzdws) {
        zzdws.getClass();
        this.zzhmx = zzdws;
    }

    public static zza zzazi() {
        return (zza) zzhmy.zzbev();
    }

    public static zzdwp zzo(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdwp) zzecd.zza(zzhmy, zzeaq, zzebq);
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeaq zzeaq) {
        zzeaq.getClass();
        this.zzhli = zzeaq;
    }

    public final int getVersion() {
        return this.zzhlh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdwq.zzdk[i - 1]) {
            case 1:
                return new zzdwp();
            case 2:
                return new zza((zzdwq) null);
            case 3:
                return zzecd.zza((zzedo) zzhmy, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhlh", "zzhmx", "zzhli"});
            case 4:
                return zzhmy;
            case 5:
                zzedx<zzdwp> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwp.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhmy);
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

    public final zzeaq zzaxn() {
        return this.zzhli;
    }

    public final zzdws zzazh() {
        zzdws zzdws = this.zzhmx;
        return zzdws == null ? zzdws.zzazn() : zzdws;
    }
}
