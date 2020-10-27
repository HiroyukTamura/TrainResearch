package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.internal.fitness.zzao;
import com.google.android.gms.internal.fitness.zzcb;
import com.google.android.gms.internal.fitness.zzel;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzp implements RemoteCall<zzao, TaskCompletionSource<Void>> {
    private final /* synthetic */ ListenerHolder zzhq;
    private final /* synthetic */ SensorRequest zzig;

    zzp(SensorsClient sensorsClient, ListenerHolder listenerHolder, SensorRequest sensorRequest) {
        this.zzhq = listenerHolder;
        this.zzig = sensorRequest;
    }

    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        ((zzcb) ((zzao) obj).getService()).zza(new com.google.android.gms.fitness.request.zzao(this.zzig, zzam.zzaa().zzc(this.zzhq), (PendingIntent) null, zzel.zza((TaskCompletionSource) obj2)));
    }
}
