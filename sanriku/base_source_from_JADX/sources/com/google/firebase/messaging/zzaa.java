package com.google.firebase.messaging;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzao;
import com.google.firebase.iid.zzt;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

final /* synthetic */ class zzaa implements Callable {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final FirebaseInstanceId zzc;
    private final zzao zzd;
    private final zzt zze;

    zzaa(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, zzao zzao, zzt zzt) {
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = firebaseInstanceId;
        this.zzd = zzao;
        this.zze = zzt;
    }

    public final Object call() {
        return zzab.zza(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
