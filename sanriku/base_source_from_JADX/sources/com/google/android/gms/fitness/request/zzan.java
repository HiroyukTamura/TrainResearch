package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.fitness.data.DataPoint;

final class zzan implements ListenerHolder.Notifier<OnDataPointListener> {
    private final /* synthetic */ DataPoint zzps;

    zzan(zzak zzak, DataPoint dataPoint) {
        this.zzps = dataPoint;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((OnDataPointListener) obj).onDataPoint(this.zzps);
    }

    public final void onNotifyListenerFailed() {
    }
}
