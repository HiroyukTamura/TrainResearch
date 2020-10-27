package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import kotlin.text.Typography;

public final class zztf {

    public static final class zza extends zzecd<zza, zzb> implements zzedq {
        /* access modifiers changed from: private */
        public static final zza zzbwj;
        private static volatile zzedx<zza> zzea;
        private int zzbvy;
        private int zzbvz = 1000;
        private zzd zzbwa;
        private zze zzbwb;
        private zzecl<zzc> zzbwc = zzecd.zzbfa();
        private zzf zzbwd;
        private zzp zzbwe;
        private zzn zzbwf;
        private zzk zzbwg;
        private zzl zzbwh;
        private zzecl<zzv> zzbwi = zzecd.zzbfa();
        private int zzdl;

        /* renamed from: com.google.android.gms.internal.ads.zztf$zza$zza  reason: collision with other inner class name */
        public enum C2669zza implements zzecf {
            AD_INITIATER_UNSPECIFIED(0),
            BANNER(1),
            DFP_BANNER(2),
            INTERSTITIAL(3),
            DFP_INTERSTITIAL(4),
            NATIVE_EXPRESS(5),
            AD_LOADER(6),
            REWARD_BASED_VIDEO_AD(7),
            BANNER_SEARCH_ADS(8),
            GOOGLE_MOBILE_ADS_SDK_ADAPTER(9),
            APP_OPEN(10);
            
            private static final zzeci<C2669zza> zzeh = null;
            private final int value;

            static {
                zzeh = new zzth();
            }

            private C2669zza(int i) {
                this.value = i;
            }

            public static C2669zza zzbt(int i) {
                switch (i) {
                    case 0:
                        return AD_INITIATER_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return DFP_BANNER;
                    case 3:
                        return INTERSTITIAL;
                    case 4:
                        return DFP_INTERSTITIAL;
                    case 5:
                        return NATIVE_EXPRESS;
                    case 6:
                        return AD_LOADER;
                    case 7:
                        return REWARD_BASED_VIDEO_AD;
                    case 8:
                        return BANNER_SEARCH_ADS;
                    case 9:
                        return GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                    case 10:
                        return APP_OPEN;
                    default:
                        return null;
                }
            }

            public static zzech zzx() {
                return zztg.zzej;
            }

            public final String toString() {
                return "<" + C2669zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        public static final class zzb extends zzecd.zza<zza, zzb> implements zzedq {
            private zzb() {
                super(zza.zzbwj);
            }

            /* synthetic */ zzb(zzte zzte) {
                this();
            }

            public final zzb zza(zze.zza zza) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zza((zze) ((zzecd) zza.zzbet()));
                return this;
            }

            public final zzb zzb(C2669zza zza) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zza) this.zzhxt).zza(zza);
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzbwj = zza;
            zzecd.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void zza(C2669zza zza) {
            this.zzbvy = zza.zzw();
            this.zzdl |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze) {
            zze.getClass();
            this.zzbwb = zze;
            this.zzdl |= 8;
        }

        public static zza zznd() {
            return zzbwj;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbwj, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007\f\u0000\b\f\u0001\t\t\u0002\n\t\u0003\u000b\u001b\f\t\u0004\r\t\u0005\u000e\t\u0006\u000f\t\u0007\u0010\t\b\u0011\u001b", new Object[]{"zzdl", "zzbvy", C2669zza.zzx(), "zzbvz", zztp.zzx(), "zzbwa", "zzbwb", "zzbwc", zzc.class, "zzbwd", "zzbwe", "zzbwf", "zzbwg", "zzbwh", "zzbwi", zzv.class});
                case 4:
                    return zzbwj;
                case 5:
                    zzedx<zza> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zza.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbwj);
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

        public final zze zznc() {
            zze zze = this.zzbwb;
            return zze == null ? zze.zznp() : zze;
        }
    }

    public static final class zzaa extends zzecd<zzaa, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzaa zzcdt;
        private static volatile zzedx<zzaa> zzea;
        private int zzbzu = 1000;
        private zzx zzcdf;
        private zzt zzcdg;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzaa, zza> implements zzedq {
            private zza() {
                super(zzaa.zzcdt);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzaa zzaa = new zzaa();
            zzcdt = zzaa;
            zzecd.zza(zzaa.class, zzaa);
        }

        private zzaa() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdt, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzcdf", "zzcdg"});
                case 4:
                    return zzcdt;
                case 5:
                    zzedx<zzaa> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzaa.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdt);
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

    public static final class zzab extends zzecd<zzab, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzab zzcdv;
        private static volatile zzedx<zzab> zzea;
        private int zzbzu = 1000;
        private int zzccv;
        private int zzccw;
        private zzx zzcdf;
        private int zzcdr;
        private long zzcdu;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzab, zza> implements zzedq {
            private zza() {
                super(zzab.zzcdv);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzab zzab = new zzab();
            zzcdv = zzab;
            zzecd.zza(zzab.class, zzab);
        }

        private zzab() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdv, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzcdf", "zzccv", "zzccw", "zzcdr", "zzcdu"});
                case 4:
                    return zzcdv;
                case 5:
                    zzedx<zzab> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzab.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdv);
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

    public static final class zzac extends zzecd<zzac, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzac zzcdw;
        private static volatile zzedx<zzac> zzea;
        private int zzbzu = 1000;
        private zzx zzcdf;
        private zzt zzcdg;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzac, zza> implements zzedq {
            private zza() {
                super(zzac.zzcdw);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzac zzac = new zzac();
            zzcdw = zzac;
            zzecd.zza(zzac.class, zzac);
        }

        private zzac() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdw, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzcdf", "zzcdg"});
                case 4:
                    return zzcdw;
                case 5:
                    zzedx<zzac> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzac.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdw);
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

    public static final class zzad extends zzecd<zzad, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzad zzcdx;
        private static volatile zzedx<zzad> zzea;
        private int zzbzu = 1000;
        private zzx zzcdf;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzad, zza> implements zzedq {
            private zza() {
                super(zzad.zzcdx);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzad zzad = new zzad();
            zzcdx = zzad;
            zzecd.zza(zzad.class, zzad);
        }

        private zzad() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdx, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzcdf"});
                case 4:
                    return zzcdx;
                case 5:
                    zzedx<zzad> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzad.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdx);
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

    public static final class zzae extends zzecd<zzae, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzae zzcea;
        private static volatile zzedx<zzae> zzea;
        private boolean zzcdy;
        private int zzcdz;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzae, zza> implements zzedq {
            private zza() {
                super(zzae.zzcea);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }

            public final zza zzcr(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzae) this.zzhxt).zzcs(i);
                return this;
            }

            public final boolean zzpd() {
                return ((zzae) this.zzhxt).zzpd();
            }

            public final zza zzw(boolean z) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzae) this.zzhxt).zzx(z);
                return this;
            }
        }

        static {
            zzae zzae = new zzae();
            zzcea = zzae;
            zzecd.zza(zzae.class, zzae);
        }

        private zzae() {
        }

        /* access modifiers changed from: private */
        public final void zzcs(int i) {
            this.zzdl |= 2;
            this.zzcdz = i;
        }

        public static zza zzpe() {
            return (zza) zzcea.zzbev();
        }

        /* access modifiers changed from: private */
        public final void zzx(boolean z) {
            this.zzdl |= 1;
            this.zzcdy = z;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcea, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzcdy", "zzcdz"});
                case 4:
                    return zzcea;
                case 5:
                    zzedx<zzae> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzae.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcea);
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

        public final boolean zzpd() {
            return this.zzcdy;
        }
    }

    public static final class zzb extends zzecd<zzb, zzc> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzb zzbwl;
        private static volatile zzedx<zzb> zzea;
        private zzecl<zza> zzbwk = zzecd.zzbfa();

        public static final class zza extends zzecd<zza, C2670zza> implements zzedq {
            /* access modifiers changed from: private */
            public static final zza zzbwp;
            private static volatile zzedx<zza> zzea;
            private int zzbwm;
            private zzd zzbwn;
            private zze zzbwo;
            private int zzdl;

            /* renamed from: com.google.android.gms.internal.ads.zztf$zzb$zza$zza  reason: collision with other inner class name */
            public static final class C2670zza extends zzecd.zza<zza, C2670zza> implements zzedq {
                private C2670zza() {
                    super(zza.zzbwp);
                }

                /* synthetic */ C2670zza(zzte zzte) {
                    this();
                }

                public final C2670zza zza(C2671zzb zzb) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzb(zzb);
                    return this;
                }

                public final C2670zza zza(zzd.zza zza) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zza((zzd) ((zzecd) zza.zzbet()));
                    return this;
                }

                public final C2670zza zza(zze.zza zza) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zza((zze) ((zzecd) zza.zzbet()));
                    return this;
                }
            }

            static {
                zza zza = new zza();
                zzbwp = zza;
                zzecd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* access modifiers changed from: private */
            public final void zza(zzd zzd) {
                zzd.getClass();
                this.zzbwn = zzd;
                this.zzdl |= 2;
            }

            /* access modifiers changed from: private */
            public final void zza(zze zze) {
                zze.getClass();
                this.zzbwo = zze;
                this.zzdl |= 4;
            }

            /* access modifiers changed from: private */
            public final void zzb(C2671zzb zzb) {
                this.zzbwm = zzb.zzw();
                this.zzdl |= 1;
            }

            public static C2670zza zznh() {
                return (C2670zza) zzbwp.zzbev();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzte.zzdk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C2670zza((zzte) null);
                    case 3:
                        return zzecd.zza((zzedo) zzbwp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbwm", C2671zzb.zzx(), "zzbwn", "zzbwo"});
                    case 4:
                        return zzbwp;
                    case 5:
                        zzedx<zza> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zza.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzbwp);
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

        /* renamed from: com.google.android.gms.internal.ads.zztf$zzb$zzb  reason: collision with other inner class name */
        public enum C2671zzb implements zzecf {
            UNSPECIFIED(0),
            IN_MEMORY(1);
            
            private static final zzeci<C2671zzb> zzeh = null;
            private final int value;

            static {
                zzeh = new zztj();
            }

            private C2671zzb(int i) {
                this.value = i;
            }

            public static C2671zzb zzbu(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return IN_MEMORY;
            }

            public static zzech zzx() {
                return zzti.zzej;
            }

            public final String toString() {
                return "<" + C2671zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        public static final class zzc extends zzecd.zza<zzb, zzc> implements zzedq {
            private zzc() {
                super(zzb.zzbwl);
            }

            /* synthetic */ zzc(zzte zzte) {
                this();
            }

            public final zzc zza(zza.C2670zza zza) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zza((zza) ((zzecd) zza.zzbet()));
                return this;
            }
        }

        public static final class zzd extends zzecd<zzd, zza> implements zzedq {
            /* access modifiers changed from: private */
            public static final zzd zzbwv;
            private static volatile zzedx<zzd> zzea;
            private boolean zzbwt;
            private int zzbwu;
            private int zzdl;

            public static final class zza extends zzecd.zza<zzd, zza> implements zzedq {
                private zza() {
                    super(zzd.zzbwv);
                }

                /* synthetic */ zza(zzte zzte) {
                    this();
                }

                public final zza zzbv(int i) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzd) this.zzhxt).zzbw(i);
                    return this;
                }

                public final zza zzq(boolean z) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zzd) this.zzhxt).zzr(z);
                    return this;
                }
            }

            static {
                zzd zzd = new zzd();
                zzbwv = zzd;
                zzecd.zza(zzd.class, zzd);
            }

            private zzd() {
            }

            /* access modifiers changed from: private */
            public final void zzbw(int i) {
                this.zzdl |= 2;
                this.zzbwu = i;
            }

            public static zza zznj() {
                return (zza) zzbwv.zzbev();
            }

            /* access modifiers changed from: private */
            public final void zzr(boolean z) {
                this.zzdl |= 1;
                this.zzbwt = z;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzte.zzdk[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza((zzte) null);
                    case 3:
                        return zzecd.zza((zzedo) zzbwv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u000b\u0001", new Object[]{"zzdl", "zzbwt", "zzbwu"});
                    case 4:
                        return zzbwv;
                    case 5:
                        zzedx<zzd> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zzd.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzbwv);
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

        public static final class zze extends zzecd<zze, zza> implements zzedq {
            /* access modifiers changed from: private */
            public static final zze zzbwy;
            private static volatile zzedx<zze> zzea;
            private int zzbwu;
            private boolean zzbww;
            private boolean zzbwx;
            private int zzdl;

            public static final class zza extends zzecd.zza<zze, zza> implements zzedq {
                private zza() {
                    super(zze.zzbwy);
                }

                /* synthetic */ zza(zzte zzte) {
                    this();
                }

                public final zza zzbx(int i) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zze) this.zzhxt).zzbw(i);
                    return this;
                }

                public final zza zzs(boolean z) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zze) this.zzhxt).zzu(z);
                    return this;
                }

                public final zza zzt(boolean z) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zze) this.zzhxt).zzv(z);
                    return this;
                }
            }

            static {
                zze zze = new zze();
                zzbwy = zze;
                zzecd.zza(zze.class, zze);
            }

            private zze() {
            }

            /* access modifiers changed from: private */
            public final void zzbw(int i) {
                this.zzdl |= 4;
                this.zzbwu = i;
            }

            public static zza zznl() {
                return (zza) zzbwy.zzbev();
            }

            /* access modifiers changed from: private */
            public final void zzu(boolean z) {
                this.zzdl |= 1;
                this.zzbww = z;
            }

            /* access modifiers changed from: private */
            public final void zzv(boolean z) {
                this.zzdl |= 2;
                this.zzbwx = z;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzte.zzdk[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza((zzte) null);
                    case 3:
                        return zzecd.zza((zzedo) zzbwy, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u000b\u0002", new Object[]{"zzdl", "zzbww", "zzbwx", "zzbwu"});
                    case 4:
                        return zzbwy;
                    case 5:
                        zzedx<zze> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zze.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzbwy);
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

        static {
            zzb zzb = new zzb();
            zzbwl = zzb;
            zzecd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            if (!this.zzbwk.zzbci()) {
                this.zzbwk = zzecd.zza(this.zzbwk);
            }
            this.zzbwk.add(zza2);
        }

        public static zzc zznf() {
            return (zzc) zzbwl.zzbev();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zzc((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbwl, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbwk", zza.class});
                case 4:
                    return zzbwl;
                case 5:
                    zzedx<zzb> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzb.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbwl);
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

    public static final class zzc extends zzecd<zzc, zzb> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzc zzbxn;
        private static volatile zzedx<zzc> zzea;
        private int zzbxl;
        private zzr zzbxm;
        private int zzdl;

        public enum zza implements zzecf {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);
            
            private static final zzeci<zza> zzeh = null;
            private final int value;

            static {
                zzeh = new zztl();
            }

            private zza(int i) {
                this.value = i;
            }

            public static zza zzby(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzech zzx() {
                return zztk.zzej;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        public static final class zzb extends zzecd.zza<zzc, zzb> implements zzedq {
            private zzb() {
                super(zzc.zzbxn);
            }

            /* synthetic */ zzb(zzte zzte) {
                this();
            }
        }

        static {
            zzc zzc = new zzc();
            zzbxn = zzc;
            zzecd.zza(zzc.class, zzc);
        }

        private zzc() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbxn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzbxl", zza.zzx(), "zzbxm"});
                case 4:
                    return zzbxn;
                case 5:
                    zzedx<zzc> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzc.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbxn);
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

    public static final class zzd extends zzecd<zzd, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzd zzbxr;
        private static volatile zzedx<zzd> zzea;
        private String zzbxo = "";
        private zzecl<zzc> zzbxp = zzecd.zzbfa();
        private int zzbxq;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzd, zza> implements zzedq {
            private zza() {
                super(zzd.zzbxr);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzd zzd = new zzd();
            zzbxr = zzd;
            zzecd.zza(zzd.class, zzd);
        }

        private zzd() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbxr, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzdl", "zzbxo", "zzbxp", zzc.class, "zzbxq", zztp.zzx()});
                case 4:
                    return zzbxr;
                case 5:
                    zzedx<zzd> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzd.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbxr);
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

    public static final class zze extends zzecd<zze, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zze zzbxx;
        private static volatile zzedx<zze> zzea;
        private String zzbxs = "";
        private zzecl<zzc> zzbxt = zzecd.zzbfa();
        private int zzbxu = 1000;
        private int zzbxv = 1000;
        private int zzbxw = 1000;
        private int zzdl;

        public static final class zza extends zzecd.zza<zze, zza> implements zzedq {
            private zza() {
                super(zze.zzbxx);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }

            public final zza zzbw(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zze) this.zzhxt).zzbv(str);
                return this;
            }
        }

        static {
            zze zze = new zze();
            zzbxx = zze;
            zzecd.zza(zze.class, zze);
        }

        private zze() {
        }

        /* access modifiers changed from: private */
        public final void zzbv(String str) {
            str.getClass();
            this.zzdl |= 1;
            this.zzbxs = str;
        }

        public static zze zznp() {
            return zzbxx;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbxx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001\u0004\f\u0002\u0005\f\u0003", new Object[]{"zzdl", "zzbxs", "zzbxt", zzc.class, "zzbxu", zztp.zzx(), "zzbxv", zztp.zzx(), "zzbxw", zztp.zzx()});
                case 4:
                    return zzbxx;
                case 5:
                    zzedx<zze> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zze.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbxx);
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

    public static final class zzf extends zzecd<zzf, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzf zzbye;
        private static volatile zzedx<zzf> zzea;
        private int zzbxy;
        private zzt zzbxz;
        private zzt zzbya;
        private zzt zzbyb;
        private zzecl<zzt> zzbyc = zzecd.zzbfa();
        private int zzbyd;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzf, zza> implements zzedq {
            private zza() {
                super(zzf.zzbye);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzf zzf = new zzf();
            zzbye = zzf;
            zzecd.zza(zzf.class, zzf);
        }

        private zzf() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbye, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzdl", "zzbxy", "zzbxz", "zzbya", "zzbyb", "zzbyc", zzt.class, "zzbyd"});
                case 4:
                    return zzbye;
                case 5:
                    zzedx<zzf> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzf.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbye);
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

    public static final class zzg extends zzecd<zzg, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzg zzbyn;
        private static volatile zzedx<zzg> zzea;
        private String zzbyf = "";
        private zzt zzbyg;
        private int zzbyh;
        private zzu zzbyi;
        private int zzbyj;
        private int zzbyk = 1000;
        private int zzbyl = 1000;
        private int zzbym = 1000;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzg, zza> implements zzedq {
            private zza() {
                super(zzg.zzbyn);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }

            public final zza zzb(zzu zzu) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzg) this.zzhxt).zza(zzu);
                return this;
            }

            public final zza zzby(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzg) this.zzhxt).zzbx(str);
                return this;
            }
        }

        static {
            zzg zzg = new zzg();
            zzbyn = zzg;
            zzecd.zza(zzg.class, zzg);
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzu zzu) {
            zzu.getClass();
            this.zzbyi = zzu;
            this.zzdl |= 8;
        }

        /* access modifiers changed from: private */
        public final void zzbx(String str) {
            str.getClass();
            this.zzdl |= 1;
            this.zzbyf = str;
        }

        public static zzg zzns() {
            return zzbyn;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbyn, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\t\u0003\u0005\u0004\u0004\u0006\f\u0005\u0007\f\u0006\b\f\u0007", new Object[]{"zzdl", "zzbyf", "zzbyg", "zzbyh", "zzbyi", "zzbyj", "zzbyk", zztp.zzx(), "zzbyl", zztp.zzx(), "zzbym", zztp.zzx()});
                case 4:
                    return zzbyn;
                case 5:
                    zzedx<zzg> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzg.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbyn);
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

    public static final class zzh extends zzecd<zzh, zzb> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzh zzbys;
        private static volatile zzedx<zzh> zzea;
        private int zzbyo;
        private zzu zzbyp;
        private String zzbyq = "";
        private String zzbyr = "";
        private int zzdl;

        public enum zza implements zzecf {
            PLATFORM_UNSPECIFIED(0),
            IOS(1),
            ANDROID(2);
            
            private static final zzeci<zza> zzeh = null;
            private final int value;

            static {
                zzeh = new zztn();
            }

            private zza(int i) {
                this.value = i;
            }

            public static zza zzbz(int i) {
                if (i == 0) {
                    return PLATFORM_UNSPECIFIED;
                }
                if (i == 1) {
                    return IOS;
                }
                if (i != 2) {
                    return null;
                }
                return ANDROID;
            }

            public static zzech zzx() {
                return zztm.zzej;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        public static final class zzb extends zzecd.zza<zzh, zzb> implements zzedq {
            private zzb() {
                super(zzh.zzbys);
            }

            /* synthetic */ zzb(zzte zzte) {
                this();
            }
        }

        static {
            zzh zzh = new zzh();
            zzbys = zzh;
            zzecd.zza(zzh.class, zzh);
        }

        private zzh() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbys, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005\f\u0000\u0006\t\u0001\u0007\b\u0002\b\b\u0003", new Object[]{"zzdl", "zzbyo", zza.zzx(), "zzbyp", "zzbyq", "zzbyr"});
                case 4:
                    return zzbys;
                case 5:
                    zzedx<zzh> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzh.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbys);
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

    public static final class zzi extends zzecd<zzi, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzi zzbzo;
        private static volatile zzedx<zzi> zzea;
        private int zzbzb;
        private String zzbzc = "";
        private int zzbzd;
        private int zzbze = 1000;
        private zzu zzbzf;
        private zzecm zzbzg = zzecd.zzbez();
        private zzg zzbzh;
        private zzh zzbzi;
        private zzm zzbzj;
        private zza zzbzk;
        private zzo zzbzl;
        private zzae zzbzm;
        private zzb zzbzn;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzi, zza> implements zzedq {
            private zza() {
                super(zzi.zzbzo);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }

            public final zza zza(zza.zzb zzb) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zza((zza) ((zzecd) zzb.zzbet()));
                return this;
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zza((zzg) ((zzecd) zza.zzbet()));
                return this;
            }

            public final zza zzb(zzae zzae) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zza(zzae);
                return this;
            }

            public final zza zzb(zzb zzb) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zza(zzb);
                return this;
            }

            public final zza zzb(zzo zzo) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zza(zzo);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zza(iterable);
                return this;
            }

            public final zza zzca(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zzbz(str);
                return this;
            }

            public final String zznv() {
                return ((zzi) this.zzhxt).zznv();
            }

            public final zzg zznx() {
                return ((zzi) this.zzhxt).zznx();
            }

            public final zza zzny() {
                return ((zzi) this.zzhxt).zzny();
            }

            public final zza zzoc() {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzi) this.zzhxt).zznw();
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzbzo = zzi;
            zzecd.zza(zzi.class, zzi);
        }

        private zzi() {
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzbzk = zza2;
            this.zzdl |= 256;
        }

        /* access modifiers changed from: private */
        public final void zza(zzae zzae) {
            zzae.getClass();
            this.zzbzm = zzae;
            this.zzdl |= 1024;
        }

        /* access modifiers changed from: private */
        public final void zza(zzb zzb) {
            zzb.getClass();
            this.zzbzn = zzb;
            this.zzdl |= 2048;
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            this.zzbzh = zzg;
            this.zzdl |= 32;
        }

        /* access modifiers changed from: private */
        public final void zza(zzo zzo) {
            zzo.getClass();
            this.zzbzl = zzo;
            this.zzdl |= 512;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            if (!this.zzbzg.zzbci()) {
                zzecm zzecm = this.zzbzg;
                int size = zzecm.size();
                this.zzbzg = zzecm.zzgx(size == 0 ? 10 : size << 1);
            }
            zzeag.zza(iterable, this.zzbzg);
        }

        /* access modifiers changed from: private */
        public final void zzbz(String str) {
            str.getClass();
            this.zzdl |= 2;
            this.zzbzc = str;
        }

        /* access modifiers changed from: private */
        public final void zznw() {
            this.zzbzg = zzecd.zzbez();
        }

        public static zza zznz() {
            return (zza) zzbzo.zzbev();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbzo, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\t\u0004\u0000\n\b\u0001\u000b\u000b\u0002\f\f\u0003\r\t\u0004\u000e\u0015\u000f\t\u0005\u0010\t\u0006\u0011\t\u0007\u0012\t\b\u0013\t\t\u0014\t\n\u0015\t\u000b", new Object[]{"zzdl", "zzbzb", "zzbzc", "zzbzd", "zzbze", zztp.zzx(), "zzbzf", "zzbzg", "zzbzh", "zzbzi", "zzbzj", "zzbzk", "zzbzl", "zzbzm", "zzbzn"});
                case 4:
                    return zzbzo;
                case 5:
                    zzedx<zzi> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzi.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbzo);
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

        public final String zznv() {
            return this.zzbzc;
        }

        public final zzg zznx() {
            zzg zzg = this.zzbzh;
            return zzg == null ? zzg.zzns() : zzg;
        }

        public final zza zzny() {
            zza zza2 = this.zzbzk;
            return zza2 == null ? zza.zznd() : zza2;
        }
    }

    public static final class zzj extends zzecd<zzj, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzj zzbzt;
        private static volatile zzedx<zzj> zzea;
        private String zzbzp = "";
        private int zzbzq;
        private zzeck zzbzr = zzecd.zzbey();
        private zzt zzbzs;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzj, zza> implements zzedq {
            private zza() {
                super(zzj.zzbzt);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzj zzj = new zzj();
            zzbzt = zzj;
            zzecd.zza(zzj.class, zzj);
        }

        private zzj() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbzt, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzdl", "zzbzp", "zzbzq", zztp.zzx(), "zzbzr", "zzbzs"});
                case 4:
                    return zzbzt;
                case 5:
                    zzedx<zzj> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzj.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbzt);
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

    public static final class zzk extends zzecd<zzk, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzk zzbzv;
        private static volatile zzedx<zzk> zzea;
        private zzeck zzbzr = zzecd.zzbey();
        private int zzbzu;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzk, zza> implements zzedq {
            private zza() {
                super(zzk.zzbzv);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzk zzk = new zzk();
            zzbzv = zzk;
            zzecd.zza(zzk.class, zzk);
        }

        private zzk() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbzv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzbzr"});
                case 4:
                    return zzbzv;
                case 5:
                    zzedx<zzk> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzk.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbzv);
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

    public static final class zzl extends zzecd<zzl, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzl zzbzy;
        private static volatile zzedx<zzl> zzea;
        private zzt zzbzs;
        private int zzbzu;
        private zzj zzbzw;
        private zzecl<zzs> zzbzx = zzecd.zzbfa();
        private int zzdl;

        public static final class zza extends zzecd.zza<zzl, zza> implements zzedq {
            private zza() {
                super(zzl.zzbzy);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzl zzl = new zzl();
            zzbzy = zzl;
            zzecd.zza(zzl.class, zzl);
        }

        private zzl() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzbzy, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzdl", "zzbzw", "zzbzx", zzs.class, "zzbzu", zztp.zzx(), "zzbzs"});
                case 4:
                    return zzbzy;
                case 5:
                    zzedx<zzl> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzl.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzbzy);
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

    public static final class zzm extends zzecd<zzm, zzb> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzm zzcaa;
        private static volatile zzedx<zzm> zzea;
        private int zzbxl;
        private int zzbzz;
        private int zzdl;

        public enum zza implements zzecf {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);
            
            private static final zzeci<zza> zzeh = null;
            private final int value;

            static {
                zzeh = new zzts();
            }

            private zza(int i) {
                this.value = i;
            }

            public static zza zzcb(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
            }

            public static zzech zzx() {
                return zztr.zzej;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        public static final class zzb extends zzecd.zza<zzm, zzb> implements zzedq {
            private zzb() {
                super(zzm.zzcaa);
            }

            /* synthetic */ zzb(zzte zzte) {
                this();
            }

            public final zzb zzb(zza zza) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzm) this.zzhxt).zza(zza);
                return this;
            }

            public final zzb zzb(zzc zzc) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzm) this.zzhxt).zza(zzc);
                return this;
            }
        }

        public enum zzc implements zzecf {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);
            
            private static final zzeci<zzc> zzeh = null;
            private final int value;

            static {
                zzeh = new zztt();
            }

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzcc(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
            }

            public static zzech zzx() {
                return zztu.zzej;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        static {
            zzm zzm = new zzm();
            zzcaa = zzm;
            zzecd.zza(zzm.class, zzm);
        }

        private zzm() {
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            this.zzbzz = zza2.zzw();
            this.zzdl |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            this.zzbxl = zzc2.zzw();
            this.zzdl |= 1;
        }

        public static zzb zzof() {
            return (zzb) zzcaa.zzbev();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zzb((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcaa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzdl", "zzbxl", zzc.zzx(), "zzbzz", zza.zzx()});
                case 4:
                    return zzcaa;
                case 5:
                    zzedx<zzm> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzm.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcaa);
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

    public static final class zzn extends zzecd<zzn, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzn zzcam;
        private static volatile zzedx<zzn> zzea;
        private int zzcak;
        private zzt zzcal;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzn, zza> implements zzedq {
            private zza() {
                super(zzn.zzcam);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzn zzn = new zzn();
            zzcam = zzn;
            zzecd.zza(zzn.class, zzn);
        }

        private zzn() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcam, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzcak", zztp.zzx(), "zzcal"});
                case 4:
                    return zzcam;
                case 5:
                    zzedx<zzn> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzn.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcam);
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

    public static final class zzo extends zzecd<zzo, zzb> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzo zzcas;
        private static volatile zzedx<zzo> zzea;
        private zzecl<zza> zzbwk = zzecd.zzbfa();
        private int zzcan;
        private int zzcao;
        private long zzcap;
        private String zzcaq = "";
        private long zzcar;
        private int zzdl;
        private String zzdm = "";

        public static final class zza extends zzecd<zza, C2672zza> implements zzedq {
            private static final zzecj<Integer, zzc.zza> zzcay = new zztv();
            /* access modifiers changed from: private */
            public static final zza zzcbg;
            private static volatile zzedx<zza> zzea;
            private long zzcat;
            private int zzcau;
            private long zzcav;
            private long zzcaw;
            private zzeck zzcax = zzecd.zzbey();
            private zzm zzcaz;
            private int zzcba;
            private int zzcbb;
            private int zzcbc;
            private int zzcbd;
            private int zzcbe;
            private int zzcbf;
            private int zzdl;

            /* renamed from: com.google.android.gms.internal.ads.zztf$zzo$zza$zza  reason: collision with other inner class name */
            public static final class C2672zza extends zzecd.zza<zza, C2672zza> implements zzedq {
                private C2672zza() {
                    super(zza.zzcbg);
                }

                /* synthetic */ C2672zza(zzte zzte) {
                    this();
                }

                public final C2672zza zzb(zzm zzm) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zza(zzm);
                    return this;
                }

                public final C2672zza zzb(zzc zzc) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zza(zzc);
                    return this;
                }

                public final C2672zza zzci(int i) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzcf(i);
                    return this;
                }

                public final C2672zza zzeu(long j) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).setTimestamp(j);
                    return this;
                }

                public final C2672zza zzev(long j) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzeq(j);
                    return this;
                }

                public final C2672zza zzew(long j) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzer(j);
                    return this;
                }

                public final C2672zza zzf(zztp zztp) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zza(zztp);
                    return this;
                }

                public final C2672zza zzf(Iterable<? extends zzc.zza> iterable) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzd(iterable);
                    return this;
                }

                public final C2672zza zzg(zztp zztp) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzb(zztp);
                    return this;
                }

                public final C2672zza zzh(zztp zztp) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzc(zztp);
                    return this;
                }

                public final C2672zza zzi(zztp zztp) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zzd(zztp);
                    return this;
                }

                public final C2672zza zzj(zztp zztp) {
                    if (this.zzhxu) {
                        zzbep();
                        this.zzhxu = false;
                    }
                    ((zza) this.zzhxt).zze(zztp);
                    return this;
                }
            }

            static {
                zza zza = new zza();
                zzcbg = zza;
                zzecd.zza(zza.class, zza);
            }

            private zza() {
            }

            /* access modifiers changed from: private */
            public final void setTimestamp(long j) {
                this.zzdl |= 1;
                this.zzcat = j;
            }

            /* access modifiers changed from: private */
            public final void zza(zzm zzm) {
                zzm.getClass();
                this.zzcaz = zzm;
                this.zzdl |= 16;
            }

            /* access modifiers changed from: private */
            public final void zza(zzc zzc) {
                this.zzcbf = zzc.zzw();
                this.zzdl |= 1024;
            }

            /* access modifiers changed from: private */
            public final void zza(zztp zztp) {
                this.zzcau = zztp.zzw();
                this.zzdl |= 2;
            }

            /* access modifiers changed from: private */
            public final void zzb(zztp zztp) {
                this.zzcba = zztp.zzw();
                this.zzdl |= 32;
            }

            /* access modifiers changed from: private */
            public final void zzc(zztp zztp) {
                this.zzcbb = zztp.zzw();
                this.zzdl |= 64;
            }

            /* access modifiers changed from: private */
            public final void zzcf(int i) {
                this.zzdl |= 256;
                this.zzcbd = i;
            }

            /* access modifiers changed from: private */
            public final void zzd(zztp zztp) {
                this.zzcbc = zztp.zzw();
                this.zzdl |= 128;
            }

            /* access modifiers changed from: private */
            public final void zzd(Iterable<? extends zzc.zza> iterable) {
                if (!this.zzcax.zzbci()) {
                    this.zzcax = zzecd.zza(this.zzcax);
                }
                for (zzc.zza zzw : iterable) {
                    this.zzcax.zzgw(zzw.zzw());
                }
            }

            /* access modifiers changed from: private */
            public final void zze(zztp zztp) {
                this.zzcbe = zztp.zzw();
                this.zzdl |= 512;
            }

            /* access modifiers changed from: private */
            public final void zzeq(long j) {
                this.zzdl |= 4;
                this.zzcav = j;
            }

            /* access modifiers changed from: private */
            public final void zzer(long j) {
                this.zzdl |= 8;
                this.zzcaw = j;
            }

            public static zza zzg(byte[] bArr) throws zzeco {
                return (zza) zzecd.zza(zzcbg, bArr);
            }

            public static C2672zza zzol() {
                return (C2672zza) zzcbg.zzbev();
            }

            public final long getTimestamp() {
                return this.zzcat;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzte.zzdk[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C2672zza((zzte) null);
                    case 3:
                        return zzecd.zza((zzedo) zzcbg, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0002\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u001e\u0006\t\u0004\u0007\f\u0005\b\f\u0006\t\f\u0007\n\u0004\b\u000b\f\t\f\f\n", new Object[]{"zzdl", "zzcat", "zzcau", zztp.zzx(), "zzcav", "zzcaw", "zzcax", zzc.zza.zzx(), "zzcaz", "zzcba", zztp.zzx(), "zzcbb", zztp.zzx(), "zzcbc", zztp.zzx(), "zzcbd", "zzcbe", zztp.zzx(), "zzcbf", zzc.zzx()});
                    case 4:
                        return zzcbg;
                    case 5:
                        zzedx<zza> zzedx = zzea;
                        if (zzedx == null) {
                            synchronized (zza.class) {
                                zzedx = zzea;
                                if (zzedx == null) {
                                    zzedx = new zzecd.zzc<>(zzcbg);
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

            public final zztp zzok() {
                zztp zzca = zztp.zzca(this.zzcau);
                return zzca == null ? zztp.ENUM_FALSE : zzca;
            }
        }

        public static final class zzb extends zzecd.zza<zzo, zzb> implements zzedq {
            private zzb() {
                super(zzo.zzcas);
            }

            /* synthetic */ zzb(zzte zzte) {
                this();
            }

            public final zzb zzcc(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzn(str);
                return this;
            }

            public final zzb zzcd(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzcb(str);
                return this;
            }

            public final zzb zzcg(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzcd(i);
                return this;
            }

            public final zzb zzch(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzce(i);
                return this;
            }

            public final zzb zze(Iterable<? extends zza> iterable) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzc(iterable);
                return this;
            }

            public final zzb zzes(long j) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzeo(j);
                return this;
            }

            public final zzb zzet(long j) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzo) this.zzhxt).zzep(j);
                return this;
            }
        }

        public enum zzc implements zzecf {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);
            
            private static final zzeci<zzc> zzeh = null;
            private final int value;

            static {
                zzeh = new zztw();
            }

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzcj(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i == 1) {
                    return CONNECTING;
                }
                if (i == 2) {
                    return CONNECTED;
                }
                if (i == 3) {
                    return DISCONNECTING;
                }
                if (i == 4) {
                    return DISCONNECTED;
                }
                if (i != 5) {
                    return null;
                }
                return SUSPENDED;
            }

            public static zzech zzx() {
                return zztx.zzej;
            }

            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        static {
            zzo zzo = new zzo();
            zzcas = zzo;
            zzecd.zza(zzo.class, zzo);
        }

        private zzo() {
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            if (!this.zzbwk.zzbci()) {
                this.zzbwk = zzecd.zza(this.zzbwk);
            }
            zzeag.zza(iterable, this.zzbwk);
        }

        /* access modifiers changed from: private */
        public final void zzcb(String str) {
            str.getClass();
            this.zzdl |= 16;
            this.zzcaq = str;
        }

        /* access modifiers changed from: private */
        public final void zzcd(int i) {
            this.zzdl |= 1;
            this.zzcan = i;
        }

        /* access modifiers changed from: private */
        public final void zzce(int i) {
            this.zzdl |= 2;
            this.zzcao = i;
        }

        /* access modifiers changed from: private */
        public final void zzeo(long j) {
            this.zzdl |= 4;
            this.zzcap = j;
        }

        /* access modifiers changed from: private */
        public final void zzep(long j) {
            this.zzdl |= 32;
            this.zzcar = j;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdl |= 8;
            this.zzdm = str;
        }

        public static zzb zzoi() {
            return (zzb) zzcas.zzbev();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zzb((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcas, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000\u0003\u0004\u0001\u0004\u0002\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005", new Object[]{"zzdl", "zzbwk", zza.class, "zzcan", "zzcao", "zzcap", "zzdm", "zzcaq", "zzcar"});
                case 4:
                    return zzcas;
                case 5:
                    zzedx<zzo> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzo.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcas);
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

    public static final class zzp extends zzecd<zzp, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzp zzcbz;
        private static volatile zzedx<zzp> zzea;
        private int zzcbo = 1000;
        private int zzcbp = 1000;
        private int zzcbq;
        private int zzcbr;
        private int zzcbs;
        private int zzcbt;
        private int zzcbu;
        private int zzcbv;
        private int zzcbw;
        private int zzcbx;
        private zzq zzcby;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzp, zza> implements zzedq {
            private zza() {
                super(zzp.zzcbz);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzp zzp = new zzp();
            zzcbz = zzp;
            zzecd.zza(zzp.class, zzp);
        }

        private zzp() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcbz, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzdl", "zzcbo", zztp.zzx(), "zzcbp", zztp.zzx(), "zzcbq", "zzcbr", "zzcbs", "zzcbt", "zzcbu", "zzcbv", "zzcbw", "zzcbx", "zzcby"});
                case 4:
                    return zzcbz;
                case 5:
                    zzedx<zzp> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzp.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcbz);
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

    public static final class zzq extends zzecd<zzq, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzq zzccc;
        private static volatile zzedx<zzq> zzea;
        private int zzcca;
        private int zzccb;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzq, zza> implements zzedq {
            private zza() {
                super(zzq.zzccc);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzq zzq = new zzq();
            zzccc = zzq;
            zzecd.zza(zzq.class, zzq);
        }

        private zzq() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzccc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzcca", "zzccb"});
                case 4:
                    return zzccc;
                case 5:
                    zzedx<zzq> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzq.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzccc);
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

    public static final class zzr extends zzecd<zzr, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzr zzccf;
        private static volatile zzedx<zzr> zzea;
        private int zzccd;
        private int zzcce;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzr, zza> implements zzedq {
            private zza() {
                super(zzr.zzccf);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzr zzr = new zzr();
            zzccf = zzr;
            zzecd.zza(zzr.class, zzr);
        }

        private zzr() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzccf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzccd", "zzcce"});
                case 4:
                    return zzccf;
                case 5:
                    zzedx<zzr> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzr.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzccf);
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

    public static final class zzs extends zzecd<zzs, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzs zzccg;
        private static volatile zzedx<zzs> zzea;
        private String zzbzp = "";
        private int zzbzq;
        private zzt zzbzs;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzs, zza> implements zzedq {
            private zza() {
                super(zzs.zzccg);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzs zzs = new zzs();
            zzccg = zzs;
            zzecd.zza(zzs.class, zzs);
        }

        private zzs() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzccg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbzp", "zzbzq", zztp.zzx(), "zzbzs"});
                case 4:
                    return zzccg;
                case 5:
                    zzedx<zzs> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzs.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzccg);
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

    public static final class zzt extends zzecd<zzt, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzt zzccj;
        private static volatile zzedx<zzt> zzea;
        private int zzcch;
        private int zzcci;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzt, zza> implements zzedq {
            private zza() {
                super(zzt.zzccj);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzt zzt = new zzt();
            zzccj = zzt;
            zzecd.zza(zzt.class, zzt);
        }

        private zzt() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzccj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzcch", "zzcci"});
                case 4:
                    return zzccj;
                case 5:
                    zzedx<zzt> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzt.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzccj);
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

    public static final class zzu extends zzecd<zzu, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzu zzccn;
        private static volatile zzedx<zzu> zzea;
        private int zzcck;
        private int zzccl;
        private int zzccm;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzu, zza> implements zzedq {
            private zza() {
                super(zzu.zzccn);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }

            public final zza zzcn(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzu) this.zzhxt).zzck(i);
                return this;
            }

            public final zza zzco(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzu) this.zzhxt).zzcl(i);
                return this;
            }

            public final zza zzcp(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzu) this.zzhxt).zzcm(i);
                return this;
            }
        }

        static {
            zzu zzu = new zzu();
            zzccn = zzu;
            zzecd.zza(zzu.class, zzu);
        }

        private zzu() {
        }

        /* access modifiers changed from: private */
        public final void zzck(int i) {
            this.zzdl |= 1;
            this.zzcck = i;
        }

        /* access modifiers changed from: private */
        public final void zzcl(int i) {
            this.zzdl |= 2;
            this.zzccl = i;
        }

        /* access modifiers changed from: private */
        public final void zzcm(int i) {
            this.zzdl |= 4;
            this.zzccm = i;
        }

        public static zza zzos() {
            return (zza) zzccn.zzbev();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzccn, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzdl", "zzcck", "zzccl", "zzccm"});
                case 4:
                    return zzccn;
                case 5:
                    zzedx<zzu> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzu.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzccn);
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

    public static final class zzv extends zzecd<zzv, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzv zzcde;
        private static volatile zzedx<zzv> zzea;
        private zzz zzcco;
        private zzab zzccp;
        private zzac zzccq;
        private zzad zzccr;
        private zzw zzccs;
        private zzaa zzcct;
        private zzy zzccu;
        private int zzccv;
        private int zzccw;
        private zzt zzccx;
        private int zzccy;
        private int zzccz;
        private int zzcda;
        private int zzcdb;
        private int zzcdc;
        private long zzcdd;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzv, zza> implements zzedq {
            private zza() {
                super(zzv.zzcde);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzv zzv = new zzv();
            zzcde = zzv;
            zzecd.zza(zzv.class, zzv);
        }

        private zzv() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcde, "\u0001\u0010\u0000\u0001\u0005\u0014\u0010\u0000\u0000\u0000\u0005\t\u0000\u0006\t\u0001\u0007\t\u0002\b\t\u0003\t\t\u0004\n\t\u0005\u000b\t\u0006\f\u0004\u0007\r\u0004\b\u000e\t\t\u000f\u0004\n\u0010\u0004\u000b\u0011\u0004\f\u0012\u0004\r\u0013\u0004\u000e\u0014\u0003\u000f", new Object[]{"zzdl", "zzcco", "zzccp", "zzccq", "zzccr", "zzccs", "zzcct", "zzccu", "zzccv", "zzccw", "zzccx", "zzccy", "zzccz", "zzcda", "zzcdb", "zzcdc", "zzcdd"});
                case 4:
                    return zzcde;
                case 5:
                    zzedx<zzv> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzv.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcde);
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

    public static final class zzw extends zzecd<zzw, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzw zzcdh;
        private static volatile zzedx<zzw> zzea;
        private int zzbzu = 1000;
        private zzx zzcdf;
        private zzt zzcdg;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzw, zza> implements zzedq {
            private zza() {
                super(zzw.zzcdh);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzw zzw = new zzw();
            zzcdh = zzw;
            zzecd.zza(zzw.class, zzw);
        }

        private zzw() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzcdf", "zzcdg"});
                case 4:
                    return zzcdh;
                case 5:
                    zzedx<zzw> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzw.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdh);
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

    public static final class zzx extends zzecd<zzx, zzb> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzx zzcdj;
        private static volatile zzedx<zzx> zzea;
        private int zzcdi;
        private int zzdl;

        public enum zza implements zzecf {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);
            
            private static final zzeci<zza> zzeh = null;
            private final int value;

            static {
                zzeh = new zztz();
            }

            private zza(int i) {
                this.value = i;
            }

            public static zza zzcq(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
            }

            public static zzech zzx() {
                return zzty.zzej;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            public final int zzw() {
                return this.value;
            }
        }

        public static final class zzb extends zzecd.zza<zzx, zzb> implements zzedq {
            private zzb() {
                super(zzx.zzcdj);
            }

            /* synthetic */ zzb(zzte zzte) {
                this();
            }
        }

        static {
            zzx zzx = new zzx();
            zzcdj = zzx;
            zzecd.zza(zzx.class, zzx);
        }

        private zzx() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zzb((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdj, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzdl", "zzcdi", zza.zzx()});
                case 4:
                    return zzcdj;
                case 5:
                    zzedx<zzx> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzx.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdj);
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

    public static final class zzy extends zzecd<zzy, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzy zzcdq;
        private static volatile zzedx<zzy> zzea;
        private int zzbzu = 1000;
        private zzx zzcdf;
        private zzt zzcdg;
        private zzu zzcdp;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzy, zza> implements zzedq {
            private zza() {
                super(zzy.zzcdq);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzy zzy = new zzy();
            zzcdq = zzy;
            zzecd.zza(zzy.class, zzy);
        }

        private zzy() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcdq, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001\u0003\t\u0002\u0004\t\u0003", new Object[]{"zzdl", "zzcdp", "zzbzu", zztp.zzx(), "zzcdf", "zzcdg"});
                case 4:
                    return zzcdq;
                case 5:
                    zzedx<zzy> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzy.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcdq);
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

    public static final class zzz extends zzecd<zzz, zza> implements zzedq {
        /* access modifiers changed from: private */
        public static final zzz zzcds;
        private static volatile zzedx<zzz> zzea;
        private int zzbzu = 1000;
        private int zzccv;
        private int zzccw;
        private zzx zzcdf;
        private int zzcdr;
        private int zzdl;

        public static final class zza extends zzecd.zza<zzz, zza> implements zzedq {
            private zza() {
                super(zzz.zzcds);
            }

            /* synthetic */ zza(zzte zzte) {
                this();
            }
        }

        static {
            zzz zzz = new zzz();
            zzcds = zzz;
            zzecd.zza(zzz.class, zzz);
        }

        private zzz() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzte.zzdk[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza((zzte) null);
                case 3:
                    return zzecd.zza((zzedo) zzcds, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzdl", "zzbzu", zztp.zzx(), "zzcdf", "zzccv", "zzccw", "zzcdr"});
                case 4:
                    return zzcds;
                case 5:
                    zzedx<zzz> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzz.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzcds);
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
}
