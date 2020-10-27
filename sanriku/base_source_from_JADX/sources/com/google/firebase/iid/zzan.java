package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import p009e.p010a.p011a.p012a.C0681a;

abstract class zzan<T> {
    final int zza;
    final TaskCompletionSource<T> zzb = new TaskCompletionSource<>();
    final int zzc;
    final Bundle zzd;

    zzan(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public String toString() {
        int i = this.zzc;
        int i2 = this.zza;
        boolean zza2 = zza();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(zza2);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(Bundle bundle);

    /* access modifiers changed from: package-private */
    public final void zza(zzam zzam) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzam);
            Log.d("MessengerIpcClient", C0681a.m314a(valueOf2.length() + valueOf.length() + 14, "Failing ", valueOf, " with ", valueOf2));
        }
        this.zzb.setException(zzam);
    }

    /* access modifiers changed from: package-private */
    public final void zza(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", C0681a.m314a(valueOf2.length() + valueOf.length() + 16, "Finishing ", valueOf, " with ", valueOf2));
        }
        this.zzb.setResult(t);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zza();
}
