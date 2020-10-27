package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzbc extends Binder {
    private final zzbe zza;

    public zzbc(zzbe zzbe) {
        this.zza = zzbe;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbg zzbg) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            this.zza.zza(zzbg.zza).addOnCompleteListener(zzh.zza(), new zzbf(zzbg));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
