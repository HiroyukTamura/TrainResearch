package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzj implements OnCompleteListener {
    private final zzf zza;
    private final Intent zzb;

    zzj(zzf zzf, Intent intent) {
        this.zza = zzf;
        this.zzb = intent;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, task);
    }
}
