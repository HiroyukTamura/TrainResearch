package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class zzdqy<V> implements Runnable {
    private final Future<V> zzhhx;
    private final zzdqx<? super V> zzhhy;

    zzdqy(Future<V> future, zzdqx<? super V> zzdqx) {
        this.zzhhx = future;
        this.zzhhy = zzdqx;
    }

    public final void run() {
        Throwable zza;
        Future<V> future = this.zzhhx;
        if (!(future instanceof zzdrz) || (zza = zzdsc.zza((zzdrz) future)) == null) {
            try {
                this.zzhhy.onSuccess(zzdqw.zza(this.zzhhx));
            } catch (ExecutionException e) {
                this.zzhhy.zzb(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzhhy.zzb(e2);
            }
        } else {
            this.zzhhy.zzb(zza);
        }
    }

    public final String toString() {
        return zzdoa.zzx(this).zzy(this.zzhhy).toString();
    }
}
