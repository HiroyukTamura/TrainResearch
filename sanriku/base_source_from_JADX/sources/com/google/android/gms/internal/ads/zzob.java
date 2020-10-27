package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzob {
    /* access modifiers changed from: private */
    public final ExecutorService zzbgo;
    /* access modifiers changed from: private */
    public zzod<? extends zzog> zzbgp;
    /* access modifiers changed from: private */
    public IOException zzbgq;

    public zzob(String str) {
        this.zzbgo = zzov.zzbg(str);
    }

    public final boolean isLoading() {
        return this.zzbgp != null;
    }

    public final <T extends zzog> long zza(T t, zzoe<T> zzoe, int i) {
        Looper myLooper = Looper.myLooper();
        zzoh.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzod(this, myLooper, t, zzoe, i, elapsedRealtime).zzek(0);
        return elapsedRealtime;
    }

    public final void zza(Runnable runnable) {
        zzod<? extends zzog> zzod = this.zzbgp;
        if (zzod != null) {
            zzod.zzl(true);
        }
        this.zzbgo.execute(runnable);
        this.zzbgo.shutdown();
    }

    public final void zzbd(int i) throws IOException {
        IOException iOException = this.zzbgq;
        if (iOException == null) {
            zzod<? extends zzog> zzod = this.zzbgp;
            if (zzod != null) {
                zzod.zzbd(zzod.zzbgv);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzir() {
        this.zzbgp.zzl(false);
    }
}
