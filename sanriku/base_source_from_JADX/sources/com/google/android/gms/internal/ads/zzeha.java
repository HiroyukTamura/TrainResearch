package com.google.android.gms.internal.ads;

public final class zzeha<T> implements zzegt<T>, zzehm<T> {
    private static final Object zzije = new Object();
    private volatile Object zzdyi = zzije;
    private volatile zzehm<T> zzijf;

    private zzeha(zzehm<T> zzehm) {
        this.zzijf = zzehm;
    }

    public static <P extends zzehm<T>, T> zzehm<T> zzar(P p) {
        zzehf.checkNotNull(p);
        return p instanceof zzeha ? p : new zzeha(p);
    }

    public static <P extends zzehm<T>, T> zzegt<T> zzas(P p) {
        return p instanceof zzegt ? (zzegt) p : new zzeha((zzehm) zzehf.checkNotNull(p));
    }

    public final T get() {
        T t = this.zzdyi;
        if (t == zzije) {
            synchronized (this) {
                t = this.zzdyi;
                if (t == zzije) {
                    t = this.zzijf.get();
                    T t2 = this.zzdyi;
                    if (t2 != zzije && !(t2 instanceof zzehg)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(valueOf.length() + 118 + valueOf2.length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzdyi = t;
                    this.zzijf = null;
                }
            }
        }
        return t;
    }
}
