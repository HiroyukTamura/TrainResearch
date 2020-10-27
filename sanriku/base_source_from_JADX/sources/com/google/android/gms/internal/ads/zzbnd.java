package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbnd extends zzblx {
    private final Executor zzfhi;
    private final zzaem zzfjy;
    private final Runnable zzfjz;

    public zzbnd(zzbnv zzbnv, zzaem zzaem, Runnable runnable, Executor executor) {
        super(zzbnv);
        this.zzfjy = zzaem;
        this.zzfjz = runnable;
        this.zzfhi = executor;
    }

    public final zzxl getVideoController() {
        return null;
    }

    public final void zza(ViewGroup viewGroup, zzum zzum) {
    }

    public final zzdgn zzahd() {
        return null;
    }

    public final View zzahe() {
        return null;
    }

    public final zzdgn zzahi() {
        return null;
    }

    public final int zzahj() {
        return 0;
    }

    @WorkerThread
    public final void zzahk() {
        this.zzfhi.execute(new zzbnf(this, new zzbnc(new AtomicReference(this.zzfjz))));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (!this.zzfjy.zzm(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }

    public final void zzkf() {
    }
}
