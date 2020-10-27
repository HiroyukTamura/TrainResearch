package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class zzl implements SuccessContinuation {
    private final String zza;

    zzl(String str) {
        this.zza = str;
    }

    public final Task then(Object obj) {
        zzab zzab = (zzab) obj;
        Task<Void> zza2 = zzab.zza(zzz.zzb(this.zza));
        zzab.zza();
        return zza2;
    }
}
