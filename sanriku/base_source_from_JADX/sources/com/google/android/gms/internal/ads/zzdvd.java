package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdvd extends zzecd<zzdvd, zza> implements zzedq {
    private static volatile zzedx<zzdvd> zzea;
    /* access modifiers changed from: private */
    public static final zzdvd zzhlk;
    private int zzhlh;
    private zzeaq zzhli = zzeaq.zzhtf;
    private zzdvh zzhlj;

    public static final class zza extends zzecd.zza<zzdvd, zza> implements zzedq {
        private zza() {
            super(zzdvd.zzhlk);
        }

        /* synthetic */ zza(zzdve zzdve) {
            this();
        }

        public final zza zzd(zzdvh zzdvh) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdvd) this.zzhxt).zzc(zzdvh);
            return this;
        }

        public final zza zzem(int i) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdvd) this.zzhxt).setVersion(0);
            return this;
        }

        public final zza zzt(zzeaq zzeaq) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdvd) this.zzhxt).zzs(zzeaq);
            return this;
        }
    }

    static {
        zzdvd zzdvd = new zzdvd();
        zzhlk = zzdvd;
        zzecd.zza(zzdvd.class, zzdvd);
    }

    private zzdvd() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhlh = i;
    }

    public static zza zzaxp() {
        return (zza) zzhlk.zzbev();
    }

    public static zzdvd zzb(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdvd) zzecd.zza(zzhlk, zzeaq, zzebq);
    }

    /* access modifiers changed from: private */
    public final void zzc(zzdvh zzdvh) {
        zzdvh.getClass();
        this.zzhlj = zzdvh;
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
        switch (zzdve.zzdk[i - 1]) {
            case 1:
                return new zzdvd();
            case 2:
                return new zza((zzdve) null);
            case 3:
                return zzecd.zza((zzedo) zzhlk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzhlh", "zzhli", "zzhlj"});
            case 4:
                return zzhlk;
            case 5:
                zzedx<zzdvd> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdvd.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhlk);
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

    public final zzdvh zzaxo() {
        zzdvh zzdvh = this.zzhlj;
        return zzdvh == null ? zzdvh.zzaxt() : zzdvh;
    }
}
