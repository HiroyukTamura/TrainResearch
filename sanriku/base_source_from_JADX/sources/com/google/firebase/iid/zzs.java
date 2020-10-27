package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzs implements Runnable {
    private final zzt zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Bundle zze;
    private final TaskCompletionSource zzf;

    zzs(zzt zzt, String str, String str2, String str3, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.zza = zzt;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = bundle;
        this.zzf = taskCompletionSource;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
