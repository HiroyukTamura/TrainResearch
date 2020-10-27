package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import p009e.p010a.p011a.p012a.C0681a;

final class zzbg {
    final Intent zza;
    private final TaskCompletionSource<Void> zzb = new TaskCompletionSource<>();

    zzbg(Intent intent) {
        this.zza = intent;
    }

    /* access modifiers changed from: package-private */
    public final Task<Void> zza() {
        return this.zzb.getTask();
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zzb.trySetResult(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        String action = this.zza.getAction();
        StringBuilder sb = new StringBuilder(C0681a.m336b(action, 61));
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        zzb();
    }
}
