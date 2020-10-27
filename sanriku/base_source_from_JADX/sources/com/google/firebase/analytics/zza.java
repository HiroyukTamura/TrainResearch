package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zza2 = this.zza.zzb();
        if (zza2 != null) {
            return zza2;
        }
        String zzh = this.zza.zzb.zzh();
        if (zzh != null) {
            this.zza.zza(zzh);
            return zzh;
        }
        throw new TimeoutException();
    }
}
