package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

public final class zzdxq extends zzecd<zzdxq, zza> implements zzedq {
    private static volatile zzedx<zzdxq> zzea;
    /* access modifiers changed from: private */
    public static final zzdxq zzhpf;
    private int zzhox;
    private zzecl<zzb> zzhpe = zzecd.zzbfa();

    public static final class zza extends zzecd.zza<zzdxq, zza> implements zzedq {
        private zza() {
            super(zzdxq.zzhpf);
        }

        /* synthetic */ zza(zzdxr zzdxr) {
            this();
        }

        public final zza zzb(zzb zzb) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdxq) this.zzhxt).zza(zzb);
            return this;
        }

        public final zza zzfb(int i) {
            if (this.zzhxu) {
                zzbep();
                this.zzhxu = false;
            }
            ((zzdxq) this.zzhxt).zzfa(i);
            return this;
        }
    }

    public static final class zzb extends zzecd<zzb, zza> implements zzedq {
        private static volatile zzedx<zzb> zzea;
        /* access modifiers changed from: private */
        public static final zzb zzhpg;
        private String zzhnz = "";
        private int zzhoq;
        private int zzhpb;
        private int zzhpc;

        public static final class zza extends zzecd.zza<zzb, zza> implements zzedq {
            private zza() {
                super(zzb.zzhpg);
            }

            /* synthetic */ zza(zzdxr zzdxr) {
                this();
            }

            public final zza zza(zzdxj zzdxj) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzb(zzdxj);
                return this;
            }

            public final zza zza(zzdyb zzdyb) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzb(zzdyb);
                return this;
            }

            public final zza zzfc(int i) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzfd(i);
                return this;
            }

            public final zza zzhn(String str) {
                if (this.zzhxu) {
                    zzbep();
                    this.zzhxu = false;
                }
                ((zzb) this.zzhxt).zzhl(str);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzhpg = zzb;
            zzecd.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zzb(zzdxj zzdxj) {
            this.zzhpb = zzdxj.zzw();
        }

        /* access modifiers changed from: private */
        public final void zzb(zzdyb zzdyb) {
            this.zzhoq = zzdyb.zzw();
        }

        public static zza zzbba() {
            return (zza) zzhpg.zzbev();
        }

        /* access modifiers changed from: private */
        public final void zzfd(int i) {
            this.zzhpc = i;
        }

        /* access modifiers changed from: private */
        public final void zzhl(String str) {
            str.getClass();
            this.zzhnz = str;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdxr.zzdk[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzdxr) null);
                case 3:
                    return zzecd.zza((zzedo) zzhpg, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhnz", "zzhpb", "zzhpc", "zzhoq"});
                case 4:
                    return zzhpg;
                case 5:
                    zzedx<zzb> zzedx = zzea;
                    if (zzedx == null) {
                        synchronized (zzb.class) {
                            zzedx = zzea;
                            if (zzedx == null) {
                                zzedx = new zzecd.zzc<>(zzhpg);
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
        zzdxq zzdxq = new zzdxq();
        zzhpf = zzdxq;
        zzecd.zza(zzdxq.class, zzdxq);
    }

    private zzdxq() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        zzb2.getClass();
        if (!this.zzhpe.zzbci()) {
            this.zzhpe = zzecd.zza(this.zzhpe);
        }
        this.zzhpe.add(zzb2);
    }

    public static zza zzbay() {
        return (zza) zzhpf.zzbev();
    }

    /* access modifiers changed from: private */
    public final void zzfa(int i) {
        this.zzhox = i;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdxr.zzdk[i - 1]) {
            case 1:
                return new zzdxq();
            case 2:
                return new zza((zzdxr) null);
            case 3:
                return zzecd.zza((zzedo) zzhpf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzhox", "zzhpe", zzb.class});
            case 4:
                return zzhpf;
            case 5:
                zzedx<zzdxq> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdxq.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhpf);
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
