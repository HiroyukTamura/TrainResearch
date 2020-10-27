package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzh implements Runnable {
    private final zzf zza;
    private final Intent zzb;
    private final TaskCompletionSource zzc;

    zzh(zzf zzf, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.zza = zzf;
        this.zzb = intent;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        zzf zzf = this.zza;
        Intent intent = this.zzb;
        TaskCompletionSource taskCompletionSource = this.zzc;
        try {
            zzf.zzc(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }
}
