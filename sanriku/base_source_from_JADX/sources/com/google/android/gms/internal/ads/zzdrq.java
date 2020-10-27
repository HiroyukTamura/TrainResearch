package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpw;

final class zzdrq extends zzdpw.zzj<Void> implements Runnable {
    private final Runnable zzhim;

    public zzdrq(Runnable runnable) {
        this.zzhim = (Runnable) zzdoj.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.zzhim.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdom.zzh(th);
        }
    }
}
