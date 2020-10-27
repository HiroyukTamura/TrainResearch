package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzt;

public final class zzak extends zzt {
    private final ListenerHolder<OnDataPointListener> zzpp;

    private zzak(ListenerHolder<OnDataPointListener> listenerHolder) {
        this.zzpp = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* synthetic */ zzak(ListenerHolder listenerHolder, zzan zzan) {
        this(listenerHolder);
    }

    public final void release() {
        this.zzpp.clear();
    }

    public final void zzc(DataPoint dataPoint) {
        this.zzpp.notifyListener(new zzan(this, dataPoint));
    }
}
