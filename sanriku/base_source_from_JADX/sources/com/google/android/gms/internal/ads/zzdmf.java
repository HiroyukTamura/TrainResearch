package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import kotlin.text.Typography;

public final class zzdmf extends zzecd<zzdmf, zzb> implements zzedq {
    private static volatile zzedx<zzdmf> zzea;
    private static final zzecj<Integer, zza> zzhbw = new zzdmi();
    /* access modifiers changed from: private */
    public static final zzdmf zzhca;
    private int zzdl;
    private zzeck zzhbv = zzecd.zzbey();
    private String zzhbx = "";
    private String zzhby = "";
    private String zzhbz = "";

    public enum zza implements zzecf {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzeci<zza> zzeh = null;
        private final int value;

        static {
            zzeh = new zzdmj();
        }

        private zza(int i) {
            this.value = i;
        }

        public static zza zzdz(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzech zzx() {
            return zzdmk.zzej;
        }

        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        public final int zzw() {
            return this.value;
        }
    }

    public static final class zzb extends zzecd.zza<zzdmf, zzb> implements zzedq {
        private zzb() {
            super(zzdmf.zzhca);
        }

        /* synthetic */ zzb(zzdmi zzdmi) {
            this();
        }

        public final zzb zzb(zza zza) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdmf) this.zzhxt).zza(zza);
            return this;
        }

        public final zzb zzhb(String str) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdmf) this.zzhxt).zzha(str);
            return this;
        }
    }

    static {
        zzdmf zzdmf = new zzdmf();
        zzhca = zzdmf;
        zzecd.zza(zzdmf.class, zzdmf);
    }

    private zzdmf() {
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        if (!this.zzhbv.zzbci()) {
            this.zzhbv = zzecd.zza(this.zzhbv);
        }
        this.zzhbv.zzgw(zza2.zzw());
    }

    public static zzb zzauq() {
        return (zzb) zzhca.zzbev();
    }

    /* access modifiers changed from: private */
    public final void zzha(String str) {
        str.getClass();
        this.zzdl |= 1;
        this.zzhbx = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdmh.zzdk[i - 1]) {
            case 1:
                return new zzdmf();
            case 2:
                return new zzb((zzdmi) null);
            case 3:
                return zzecd.zza((zzedo) zzhca, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdl", "zzhbv", zza.zzx(), "zzhbx", "zzhby", "zzhbz"});
            case 4:
                return zzhca;
            case 5:
                zzedx<zzdmf> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdmf.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhca);
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
