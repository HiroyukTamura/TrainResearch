package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import java.util.List;

public final class zzdxp extends zzecd<zzdxp, zzb> implements zzedq {
    private static volatile zzedx<zzdxp> zzea;
    /* access modifiers changed from: private */
    public static final zzdxp zzhoz;
    private int zzhox;
    private zzecl<zza> zzhoy = zzecd.zzbfa();

    public static final class zza extends zzecd<zza, C2657zza> implements zzedq {
        private static volatile zzedx<zza> zzea;
        /* access modifiers changed from: private */
        public static final zza zzhpd;
        private int zzhoq;
        private zzdxf zzhpa;
        private int zzhpb;
        private int zzhpc;

        /* renamed from: com.google.android.gms.internal.ads.zzdxp$zza$zza  reason: collision with other inner class name */
        public static final class C2657zza extends zzecd.zza<zza, C2657zza> implements zzedq {
            private C2657zza() {
                super(zza.zzhpd);
            }

            /* synthetic */ C2657zza(zzdxo zzdxo) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzhpd = zza;
            zzecd.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdxo.zzdk[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C2657zza((zzdxo) null);
                case 3:
                    return zzecd.zza((zzedo) zzhpd, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhpa", "zzhpb", "zzhpc", "zzhoq"});
                case 4:
                    return zzhpd;
                case 5:
                    zzedx<zza> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zza.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzhpd);
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

        public final zzdxj zzaxe() {
            zzdxj zzez = zzdxj.zzez(this.zzhpb);
            return zzez == null ? zzdxj.UNRECOGNIZED : zzez;
        }

        public final zzdyb zzaxf() {
            zzdyb zzfg = zzdyb.zzfg(this.zzhoq);
            return zzfg == null ? zzdyb.UNRECOGNIZED : zzfg;
        }

        public final boolean zzbau() {
            return this.zzhpa != null;
        }

        public final zzdxf zzbav() {
            zzdxf zzdxf = this.zzhpa;
            return zzdxf == null ? zzdxf.zzbah() : zzdxf;
        }

        public final int zzbaw() {
            return this.zzhpc;
        }
    }

    public static final class zzb extends zzecd.zza<zzdxp, zzb> implements zzedq {
        private zzb() {
            super(zzdxp.zzhoz);
        }

        /* synthetic */ zzb(zzdxo zzdxo) {
            this();
        }
    }

    static {
        zzdxp zzdxp = new zzdxp();
        zzhoz = zzdxp;
        zzecd.zza(zzdxp.class, zzdxp);
    }

    private zzdxp() {
    }

    public static zzdxp zzc(byte[] bArr, zzebq zzebq) throws zzeco {
        return (zzdxp) zzecd.zza(zzhoz, bArr, zzebq);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxo.zzdk[i - 1]) {
            case 1:
                return new zzdxp();
            case 2:
                return new zzb((zzdxo) null);
            case 3:
                return zzecd.zza((zzedo) zzhoz, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzhox", "zzhoy", zza.class});
            case 4:
                return zzhoz;
            case 5:
                zzedx<zzdxp> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxp.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhoz);
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

    public final int zzbaq() {
        return this.zzhox;
    }

    public final List<zza> zzbar() {
        return this.zzhoy;
    }

    public final int zzbas() {
        return this.zzhoy.size();
    }
}
