package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmf;
import com.google.android.gms.internal.ads.zzecd;
import kotlin.text.Typography;

public final class zzdmm extends zzecd<zzdmm, zzb> implements zzedq {
    private static volatile zzedx<zzdmm> zzea;
    /* access modifiers changed from: private */
    public static final zzdmm zzhch;
    private int zzdl;
    private String zzdm = "";
    private int zzhce;
    private String zzhcf = "";
    private zzdmf zzhcg;

    public enum zza implements zzecf {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzeci<zza> zzeh = null;
        private final int value;

        static {
            zzeh = new zzdmo();
        }

        private zza(int i) {
            this.value = i;
        }

        public static zza zzea(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        public static zzech zzx() {
            return zzdmn.zzej;
        }

        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        public final int zzw() {
            return this.value;
        }
    }

    public static final class zzb extends zzecd.zza<zzdmm, zzb> implements zzedq {
        private zzb() {
            super(zzdmm.zzhch);
        }

        /* synthetic */ zzb(zzdml zzdml) {
            this();
        }

        public final zzb zza(zzdmf.zzb zzb) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdmm) this.zzhxt).zza((zzdmf) ((zzecd) zzb.zzbet()));
            return this;
        }

        public final zzb zzb(zza zza) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdmm) this.zzhxt).zza(zza);
            return this;
        }

        public final zzb zzhc(String str) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdmm) this.zzhxt).zzn(str);
            return this;
        }
    }

    static {
        zzdmm zzdmm = new zzdmm();
        zzhch = zzdmm;
        zzecd.zza(zzdmm.class, zzdmm);
    }

    private zzdmm() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzdmf zzdmf) {
        zzdmf.getClass();
        this.zzhcg = zzdmf;
        this.zzdl |= 8;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzhce = zza2.zzw();
        this.zzdl |= 1;
    }

    public static zzb zzaus() {
        return (zzb) zzhch.zzbev();
    }

    /* access modifiers changed from: private */
    public final void zzn(String str) {
        str.getClass();
        this.zzdl |= 2;
        this.zzdm = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdml.zzdk[i - 1]) {
            case 1:
                return new zzdmm();
            case 2:
                return new zzb((zzdml) null);
            case 3:
                return zzecd.zza((zzedo) zzhch, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003", new Object[]{"zzdl", "zzhce", zza.zzx(), "zzdm", "zzhcf", "zzhcg"});
            case 4:
                return zzhch;
            case 5:
                zzedx<zzdmm> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdmm.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhch);
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
