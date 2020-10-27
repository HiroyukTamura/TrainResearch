package com.google.android.gms.fitness;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.request.zzaf;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzbi;
import com.google.android.gms.internal.fitness.zzbr;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzel;
import com.google.android.gms.internal.fitness.zzn;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzc implements RemoteCall<zzn, TaskCompletionSource<Boolean>> {
    private final /* synthetic */ ListenerHolder zzhq;

    zzc(BleClient bleClient, ListenerHolder listenerHolder) {
        this.zzhq = listenerHolder;
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        zzn zzn = (zzn) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        zzb zzb = com.google.android.gms.fitness.request.zzc.zzx().zzb(this.zzhq);
        if (zzb == null) {
            taskCompletionSource.setResult(false);
            return;
        }
        ((zzbr) zzn.getService()).zza(new zzbi((zzaf) zzb, (zzcm) zzel.zzb(taskCompletionSource)));
    }
}
