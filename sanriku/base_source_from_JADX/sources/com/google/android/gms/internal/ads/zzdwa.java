package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdwa extends zzecd<zzdwa, zza> implements zzedq {
    private static volatile zzedx<zzdwa> zzea;
    /* access modifiers changed from: private */
    public static final zzdwa zzhmf;
    private int zzhlh;
    private zzeaq zzhli = zzeaq.zzhtf;

    public static final class zza extends zzecd.zza<zzdwa, zza> implements zzedq {
        private zza() {
            super(zzdwa.zzhmf);
        }

        /* synthetic */ zza(zzdvz zzdvz) {
            this();
        }

        public final zza zzeq(int i) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdwa) this.zzhxt).setVersion(0);
            return this;
        }

        public final zza zzw(zzeaq zzeaq) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdwa) this.zzhxt).zzs(zzeaq);
            return this;
        }
    }

    static {
        zzdwa zzdwa = new zzdwa();
        zzhmf = zzdwa;
        zzecd.zza(zzdwa.class, zzdwa);
    }

    private zzdwa() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhlh = i;
    }

    public static zza zzayr() {
        return (zza) zzhmf.zzbev();
    }

    public static zzdwa zzj(zzeaq zzeaq, zzebq zzebq) throws zzeco {
        return (zzdwa) zzecd.zza(zzhmf, zzeaq, zzebq);
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
        switch (zzdvz.zzdk[i - 1]) {
            case 1:
                return new zzdwa();
            case 2:
                return new zza((zzdvz) null);
            case 3:
                return zzecd.zza((zzedo) zzhmf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhlh", "zzhli"});
            case 4:
                return zzhmf;
            case 5:
                zzedx<zzdwa> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdwa.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhmf);
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
}
