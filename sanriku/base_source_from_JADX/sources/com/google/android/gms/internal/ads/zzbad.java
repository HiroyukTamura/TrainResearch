package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;

final class zzbad implements Executor {
    private final Handler zzdzx = new zzawu(Looper.getMainLooper());

    zzbad() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzq.zzkw();
                zzaxa.zza(zzq.zzla().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzdzx.post(runnable);
        }
    }
}
