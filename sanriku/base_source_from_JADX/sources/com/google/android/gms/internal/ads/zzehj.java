package com.google.android.gms.internal.ads;

public final class zzehj<T> implements zzehm<T> {
    private static final Object zzije = new Object();
    private volatile Object zzdyi = zzije;
    private volatile zzehm<T> zzijf;

    private zzehj(zzehm<T> zzehm) {
        this.zzijf = zzehm;
    }

    public static <P extends zzehm<T>, T> zzehm<T> zzar(P p) {
        return ((p instanceof zzehj) || (p instanceof zzeha)) ? p : new zzehj((zzehm) zzehf.checkNotNull(p));
    }

    public final T get() {
        T t = this.zzdyi;
        if (t != zzije) {
            return t;
        }
        zzehm<T> zzehm = this.zzijf;
        if (zzehm == null) {
            return this.zzdyi;
        }
        T t2 = zzehm.get();
        this.zzdyi = t2;
        this.zzijf = null;
        return t2;
    }
}
