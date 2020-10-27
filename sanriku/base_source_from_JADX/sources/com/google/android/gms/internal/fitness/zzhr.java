package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzhr<T> implements zzic<T> {
    private final zzho zzxm;
    private final zziu<?, ?> zzxn;
    private final boolean zzxo;
    private final zzfw<?> zzxp;

    private zzhr(zziu<?, ?> zziu, zzfw<?> zzfw, zzho zzho) {
        this.zzxn = zziu;
        this.zzxo = zzfw.zze(zzho);
        this.zzxp = zzfw;
        this.zzxm = zzho;
    }

    static <T> zzhr<T> zza(zziu<?, ?> zziu, zzfw<?> zzfw, zzho zzho) {
        return new zzhr<>(zziu, zzfw, zzho);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzxn.zzm(t).equals(this.zzxn.zzm(t2))) {
            return false;
        }
        if (this.zzxo) {
            return this.zzxp.zza((Object) t).equals(this.zzxp.zza((Object) t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzxn.zzm(t).hashCode();
        return this.zzxo ? (hashCode * 53) + this.zzxp.zza((Object) t).hashCode() : hashCode;
    }

    public final void zza(T t, zzjo zzjo) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzxp.zza((Object) t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzgd zzgd = (zzgd) next.getKey();
            if (zzgd.zzbh() != zzjl.MESSAGE || zzgd.zzbi() || zzgd.zzbj()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzjo.zza(zzgd.zzc(), next instanceof zzgr ? ((zzgr) next).zzbw().zzag() : next.getValue());
        }
        zziu<?, ?> zziu = this.zzxn;
        zziu.zzc(zziu.zzm(t), zzjo);
    }

    public final void zzc(T t) {
        this.zzxn.zzc(t);
        this.zzxp.zzc(t);
    }

    public final void zzd(T t, T t2) {
        zzie.zza(this.zzxn, t, t2);
        if (this.zzxo) {
            zzie.zza(this.zzxp, t, t2);
        }
    }

    public final boolean zzj(T t) {
        return this.zzxp.zza((Object) t).isInitialized();
    }

    public final int zzk(T t) {
        zziu<?, ?> zziu = this.zzxn;
        int zzn = zziu.zzn(zziu.zzm(t)) + 0;
        return this.zzxo ? zzn + this.zzxp.zza((Object) t).zzbf() : zzn;
    }
}
