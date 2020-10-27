package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.util.List;

public final class zzc {

    public static final class zza extends zzrc<zza, C2673zza> implements zzsm {
        /* access modifiers changed from: private */
        public static final zza zznv;
        private static volatile zzsu<zza> zznw;
        private int zznr;
        private int zzns = 1;
        private int zznt;
        private int zznu;

        /* renamed from: com.google.android.gms.internal.gtm.zzc$zza$zza  reason: collision with other inner class name */
        public static final class C2673zza extends zzrc.zza<zza, C2673zza> implements zzsm {
            private C2673zza() {
                super(zza.zznv);
            }

            /* synthetic */ C2673zza(zzd zzd) {
                this();
            }
        }

        public enum zzb implements zzrf {
            NO_CACHE(1),
            PRIVATE(2),
            PUBLIC(3);
            
            private static final zzrg<zzb> zzoa = null;
            private final int value;

            static {
                zzoa = new zze();
            }

            private zzb(int i) {
                this.value = i;
            }

            public static zzb zza(int i) {
                if (i == 1) {
                    return NO_CACHE;
                }
                if (i == 2) {
                    return PRIVATE;
                }
                if (i != 3) {
                    return null;
                }
                return PUBLIC;
            }

            public static zzrh zzd() {
                return zzf.zzoc;
            }

            public final int zzc() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zznv = zza;
            zzrc.zza(zza.class, zza);
        }

        private zza() {
        }

        public static zzsu<zza> zza() {
            return (zzsu) zznv.zza(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzd.zznq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C2673zza((zzd) null);
                case 3:
                    return zzrc.zza((zzsk) zznv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zznr", "zzns", zzb.zzd(), "zznt", "zznu"});
                case 4:
                    return zznv;
                case 5:
                    zzsu<zza> zzsu = zznw;
                    if (zzsu == null) {
                        synchronized (zza.class) {
                            zzsu = zznw;
                            if (zzsu == null) {
                                zzsu = new zzrc.zzb<>(zznv);
                                zznw = zzsu;
                            }
                        }
                    }
                    return zzsu;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzrc<zzb, zza> implements zzsm {
        private static volatile zzsu<zzb> zznw;
        /* access modifiers changed from: private */
        public static final zzb zzoj;
        private int zznr;
        private zzri zzod = zzrc.zzpf();
        private int zzoe;
        private int zzof;
        private boolean zzog;
        private boolean zzoh;
        private byte zzoi = 2;

        public static final class zza extends zzrc.zza<zzb, zza> implements zzsm {
            private zza() {
                super(zzb.zzoj);
            }

            /* synthetic */ zza(zzd zzd) {
                this();
            }
        }

        static {
            zzb zzb = new zzb();
            zzoj = zzb;
            zzrc.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        public static zzsu<zzb> zza() {
            return (zzsu) zzoj.zza(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzd.zznq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzd) null);
                case 3:
                    return zzrc.zza((zzsk) zzoj, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001\u0007\u0003\u0002Ԅ\u0000\u0003\u0016\u0004\u0004\u0001\u0006\u0007\u0002", new Object[]{"zznr", "zzoh", "zzoe", "zzod", "zzof", "zzog"});
                case 4:
                    return zzoj;
                case 5:
                    zzsu<zzb> zzsu = zznw;
                    if (zzsu == null) {
                        synchronized (zzb.class) {
                            zzsu = zznw;
                            if (zzsu == null) {
                                zzsu = new zzrc.zzb<>(zzoj);
                                zznw = zzsu;
                            }
                        }
                    }
                    return zzsu;
                case 6:
                    return Byte.valueOf(this.zzoi);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzoi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<Integer> zze() {
            return this.zzod;
        }
    }

    /* renamed from: com.google.android.gms.internal.gtm.zzc$zzc  reason: collision with other inner class name */
    public static final class C2674zzc extends zzrc<C2674zzc, zza> implements zzsm {
        private static volatile zzsu<C2674zzc> zznw;
        /* access modifiers changed from: private */
        public static final C2674zzc zzop;
        private int zznr;
        private String zzok = "";
        private long zzol;
        private long zzom = 2147483647L;
        private boolean zzon;
        private long zzoo;

        /* renamed from: com.google.android.gms.internal.gtm.zzc$zzc$zza */
        public static final class zza extends zzrc.zza<C2674zzc, zza> implements zzsm {
            private zza() {
                super(C2674zzc.zzop);
            }

            /* synthetic */ zza(zzd zzd) {
                this();
            }
        }

        static {
            C2674zzc zzc = new C2674zzc();
            zzop = zzc;
            zzrc.zza(C2674zzc.class, zzc);
        }

        private C2674zzc() {
        }

        public static zzsu<C2674zzc> zza() {
            return (zzsu) zzop.zza(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        public final String getKey() {
            return this.zzok;
        }

        public final boolean hasKey() {
            return (this.zznr & 1) != 0;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzd.zznq[i - 1]) {
                case 1:
                    return new C2674zzc();
                case 2:
                    return new zza((zzd) null);
                case 3:
                    return zzrc.zza((zzsk) zzop, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0007\u0003\u0005\u0002\u0004", new Object[]{"zznr", "zzok", "zzol", "zzom", "zzon", "zzoo"});
                case 4:
                    return zzop;
                case 5:
                    zzsu<C2674zzc> zzsu = zznw;
                    if (zzsu == null) {
                        synchronized (C2674zzc.class) {
                            zzsu = zznw;
                            if (zzsu == null) {
                                zzsu = new zzrc.zzb<>(zzop);
                                zznw = zzsu;
                            }
                        }
                    }
                    return zzsu;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final long zzg() {
            return this.zzol;
        }

        public final long zzh() {
            return this.zzom;
        }

        public final boolean zzi() {
            return this.zzon;
        }

        public final long zzj() {
            return this.zzoo;
        }
    }

    public static final class zzd extends zzrc<zzd, zza> implements zzsm {
        private static volatile zzsu<zzd> zznw;
        /* access modifiers changed from: private */
        public static final zzd zzos;
        private int zznr;
        private byte zzoi = 2;
        private int zzoq;
        private int zzor;

        public static final class zza extends zzrc.zza<zzd, zza> implements zzsm {
            private zza() {
                super(zzd.zzos);
            }

            /* synthetic */ zza(zzd zzd) {
                this();
            }
        }

        static {
            zzd zzd = new zzd();
            zzos = zzd;
            zzrc.zza(zzd.class, zzd);
        }

        private zzd() {
        }

        public static zzsu<zzd> zza() {
            return (zzsu) zzos.zza(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        public final int getValue() {
            return this.zzor;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzd.zznq[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzd) null);
                case 3:
                    return zzrc.zza((zzsk) zzos, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001", new Object[]{"zznr", "zzoq", "zzor"});
                case 4:
                    return zzos;
                case 5:
                    zzsu<zzd> zzsu = zznw;
                    if (zzsu == null) {
                        synchronized (zzd.class) {
                            zzsu = zznw;
                            if (zzsu == null) {
                                zzsu = new zzrc.zzb<>(zzos);
                                zznw = zzsu;
                            }
                        }
                    }
                    return zzsu;
                case 6:
                    return Byte.valueOf(this.zzoi);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzoi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final int zzl() {
            return this.zzoq;
        }
    }

    public static final class zze extends zzrc<zze, zza> implements zzsm {
        private static volatile zzsu<zze> zznw;
        /* access modifiers changed from: private */
        public static final zze zzpd;
        private zzri zzot = zzrc.zzpf();
        private zzri zzou = zzrc.zzpf();
        private zzri zzov = zzrc.zzpf();
        private zzri zzow = zzrc.zzpf();
        private zzri zzox = zzrc.zzpf();
        private zzri zzoy = zzrc.zzpf();
        private zzri zzoz = zzrc.zzpf();
        private zzri zzpa = zzrc.zzpf();
        private zzri zzpb = zzrc.zzpf();
        private zzri zzpc = zzrc.zzpf();

        public static final class zza extends zzrc.zza<zze, zza> implements zzsm {
            private zza() {
                super(zze.zzpd);
            }

            /* synthetic */ zza(zzd zzd) {
                this();
            }
        }

        static {
            zze zze = new zze();
            zzpd = zze;
            zzrc.zza(zze.class, zze);
        }

        private zze() {
        }

        public static zzsu<zze> zza() {
            return (zzsu) zzpd.zza(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzd.zznq[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzd) null);
                case 3:
                    return zzrc.zza((zzsk) zzpd, "\u0001\n\u0000\u0000\u0001\n\n\u0000\n\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004\u0016\u0005\u0016\u0006\u0016\u0007\u0016\b\u0016\t\u0016\n\u0016", new Object[]{"zzot", "zzou", "zzov", "zzow", "zzox", "zzoy", "zzoz", "zzpa", "zzpb", "zzpc"});
                case 4:
                    return zzpd;
                case 5:
                    zzsu<zze> zzsu = zznw;
                    if (zzsu == null) {
                        synchronized (zze.class) {
                            zzsu = zznw;
                            if (zzsu == null) {
                                zzsu = new zzrc.zzb<>(zzpd);
                                zznw = zzsu;
                            }
                        }
                    }
                    return zzsu;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<Integer> zzn() {
            return this.zzot;
        }

        public final List<Integer> zzo() {
            return this.zzou;
        }

        public final List<Integer> zzp() {
            return this.zzov;
        }

        public final List<Integer> zzq() {
            return this.zzow;
        }

        public final List<Integer> zzr() {
            return this.zzox;
        }

        public final List<Integer> zzs() {
            return this.zzoy;
        }

        public final List<Integer> zzt() {
            return this.zzoz;
        }

        public final List<Integer> zzu() {
            return this.zzpa;
        }

        public final List<Integer> zzv() {
            return this.zzpb;
        }

        public final List<Integer> zzw() {
            return this.zzpc;
        }
    }
}
