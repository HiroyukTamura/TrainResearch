package com.google.android.gms.fitness.request;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.fitness.data.BleDevice;

final class zza implements ListenerHolder.Notifier<BleScanCallback> {
    private final /* synthetic */ BleDevice zzof;

    zza(zzb zzb, BleDevice bleDevice) {
        this.zzof = bleDevice;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((BleScanCallback) obj).onDeviceFound(this.zzof);
    }

    public final void onNotifyListenerFailed() {
    }
}
