package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdvt extends zzecd<zzdvt, zza> implements zzedq {
    private static volatile zzedx<zzdvt> zzea;
    /* access modifiers changed from: private */
    public static final zzdvt zzhmc;
    private int zzhlh;
    private zzeaq zzhli = zzeaq.zzhtf;
    private zzdvx zzhmb;

    public static final class zza extends zzecd.zza<zzdvt, zza> implements zzedq {
        private zza() {
            super(zzdvt.zzhmc);
        }

        /* synthetic */ zza(zzdvu zzdvu) {
            this();
        }

        public final zza zzb(zzdvx zzdvx) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdvt) this.zzhxt).zza(zzdvx);
            return this;
        }

        public final zza zzep(int i) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdvt) this.zzhxt).setVersion(0);
            return this;
        }

        public final zza zzv(zzeaq zzeaq) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdvt) this.zzhxt).zzs(zzeaq);
            return this;
        }
    }

    static {
        zzdvt zzdvt = new zzdvt();
        zzhmc = zzdvt;
        zzecd.zza(zzdvt.class, zzdvt);
    }

    private zzdvt() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhlh = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdvx zzdvx) {
        zzdvx.getClass();
        this.zzhmb = zzdvx;
    }

    public static zza zzaym() {
        return (zza) zzhmc.zzbev();
    }

    public static zzdvt zzh(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdvt) zzecd.zza(zzhmc, zzeaq, zzebq);
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
        switch (zzdvu.zzdk[i - 1]) {
            case 1:
                return new zzdvt();
            case 2:
                return new zza((zzdvu) null);
            case 3:
                return zzecd.zza((zzedo) zzhmc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhlh", "zzhmb", "zzhli"});
            case 4:
                return zzhmc;
            case 5:
                zzedx<zzdvt> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdvt.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhmc);
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

    public final zzdvx zzayl() {
        zzdvx zzdvx = this.zzhmb;
        return zzdvx == null ? zzdvx.zzayp() : zzdvx;
    }
}
