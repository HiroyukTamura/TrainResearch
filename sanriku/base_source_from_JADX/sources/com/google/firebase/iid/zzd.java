package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

final /* synthetic */ class zzd implements Callable {
    private final Context zza;
    private final Intent zzb;

    zzd(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    public final Object call() {
        return Integer.valueOf(zzaw.zza().zza(this.zza, this.zzb));
    }
}
