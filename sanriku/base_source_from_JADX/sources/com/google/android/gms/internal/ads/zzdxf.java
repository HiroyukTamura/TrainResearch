package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import kotlin.text.Typography;

public final class zzdxf extends zzecd<zzdxf, zza> implements zzedq {
    private static volatile zzedx<zzdxf> zzea;
    /* access modifiers changed from: private */
    public static final zzdxf zzhoc;
    private String zzhnz = "";
    private zzeaq zzhoa = zzeaq.zzhtf;
    private int zzhob;

    public static final class zza extends zzecd.zza<zzdxf, zza> implements zzedq {
        private zza() {
            super(zzdxf.zzhoc);
        }

        /* synthetic */ zza(zzdxg zzdxg) {
            this();
        }

        public final zza zzaf(zzeaq zzeaq) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdxf) this.zzhxt).zzae(zzeaq);
            return this;
        }

        public final zza zzb(zzb zzb) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdxf) this.zzhxt).zza(zzb);
            return this;
        }

        public final zza zzhm(String str) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdxf) this.zzhxt).zzhl(str);
            return this;
        }
    }

    public enum zzb implements zzecf {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzeci<zzb> zzeh = null;
        private final int value;

        static {
            zzeh = new zzdxh();
        }

        private zzb(int i) {
            this.value = i;
        }

        public static zzb zzey(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zzb.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzw());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append(Typography.greater);
            return sb.toString();
        }

        public final int zzw() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzdxf zzdxf = new zzdxf();
        zzhoc = zzdxf;
        zzecd.zza(zzdxf.class, zzdxf);
    }

    private zzdxf() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzhob = zzb2.zzw();
    }

    /* access modifiers changed from: private */
    public final void zzae(zzeaq zzeaq) {
        zzeaq.getClass();
        this.zzhoa = zzeaq;
    }

    public static zza zzbag() {
        return (zza) zzhoc.zzbev();
    }

    public static zzdxf zzbah() {
        return zzhoc;
    }

    /* access modifiers changed from: private */
    public final void zzhl(String str) {
        str.getClass();
        this.zzhnz = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxg.zzdk[i - 1]) {
            case 1:
                return new zzdxf();
            case 2:
                return new zza((zzdxg) null);
            case 3:
                return zzecd.zza((zzedo) zzhoc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhnz", "zzhoa", "zzhob"});
            case 4:
                return zzhoc;
            case 5:
                zzedx<zzdxf> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxf.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhoc);
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

    public final zzeaq zzbae() {
        return this.zzhoa;
    }

    public final zzb zzbaf() {
        zzb zzey = zzb.zzey(this.zzhob);
        return zzey == null ? zzb.UNRECOGNIZED : zzey;
    }
}
