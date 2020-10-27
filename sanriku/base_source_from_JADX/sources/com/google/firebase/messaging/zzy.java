package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class zzy {
    @GuardedBy("TopicsStore.class")
    private static WeakReference<zzy> zza;
    private final SharedPreferences zzb;
    private zzx zzc;
    private final Executor zzd;

    private zzy(SharedPreferences sharedPreferences, Executor executor) {
        this.zzd = executor;
        this.zzb = sharedPreferences;
    }

    @WorkerThread
    public static synchronized zzy zza(Context context, Executor executor) {
        zzy zzy;
        synchronized (zzy.class) {
            zzy = null;
            if (zza != null) {
                zzy = (zzy) zza.get();
            }
            if (zzy == null) {
                zzy = new zzy(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                zzy.zzb();
                zza = new WeakReference<>(zzy);
            }
        }
        return zzy;
    }

    @WorkerThread
    private final synchronized void zzb() {
        this.zzc = zzx.zza(this.zzb, "topic_operation_queue", ",", this.zzd);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final synchronized zzz zza() {
        return zzz.zzc(this.zzc.zza());
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zza(zzz zzz) {
        return this.zzc.zza(zzz.zzc());
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzb(zzz zzz) {
        return this.zzc.zza((Object) zzz.zzc());
    }
}
