package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.data.zzu;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzas;
import com.google.android.gms.internal.fitness.zzao;
import com.google.android.gms.internal.fitness.zzcb;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzel;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzn implements RemoteCall<zzao, TaskCompletionSource<Boolean>> {
    private final /* synthetic */ ListenerHolder zzhq;

    zzn(SensorsClient sensorsClient, ListenerHolder listenerHolder) {
        this.zzhq = listenerHolder;
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        zzao zzao = (zzao) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        zzak zzd = zzam.zzaa().zzd(this.zzhq);
        if (zzd == null) {
            taskCompletionSource.setResult(false);
            return;
        }
        ((zzcb) zzao.getService()).zza(new zzas((zzu) zzd, (PendingIntent) null, (zzcm) zzel.zzb(taskCompletionSource)));
    }
}
