package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.BleDevice;

public final class zzb extends zzae {
    private final ListenerHolder<BleScanCallback> zzog;

    private zzb(ListenerHolder<BleScanCallback> listenerHolder) {
        this.zzog = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* synthetic */ zzb(ListenerHolder listenerHolder, zza zza) {
        this(listenerHolder);
    }

    public final void onDeviceFound(BleDevice bleDevice) {
        this.zzog.notifyListener(new zza(this, bleDevice));
    }

    public final void onScanStopped() {
        this.zzog.notifyListener(new zzd(this));
    }

    public final void release() {
        this.zzog.clear();
    }
}
